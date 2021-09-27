package sharpie.grindsim.splits.overworld.monument;

import sharpie.grindsim.agents.MonumentResetAgent;
import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

import static sharpie.grindsim.utils.Settings.OCEAN_TRAVEL_CONSTANT;

public class CheckForRuinedPortalAfterMonument extends Split {

    MonumentResetAgent agent;

    public CheckForRuinedPortalAfterMonument(MonumentResetAgent agent) {

        this.agent = agent;
    }

    public SplitResult sim() {

        MonumentWorld world = MonumentWorldSampler.sampleWorld();

        SplitResult result = new SplitResult();

        SplitLength totalTravelSplit = new SplitLength(world.getTravelDistance()/OCEAN_TRAVEL_CONSTANT, TimeUnit.SECONDS);

        if (agent.shouldResetAfterExitRuinedPortalAtTime(totalTravelSplit)) {

            result.setDidSucceed(false);

            result.setTime(totalTravelSplit.getTime());

            return result;
        }

        if (!world.hasRuinedPortal) {

            result.setDidSucceed(false);

            result.setTime(new SplitLength(5.0, TimeUnit.SECONDS).getTime());
        } else {

            result.setDidSucceed(true);

            result.setTime(new SplitLength((world.getTravelDistance()-world.getMonumentDistance())/OCEAN_TRAVEL_CONSTANT, TimeUnit.SECONDS).getTime());
        }

        return result;
    }
}
