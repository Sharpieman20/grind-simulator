package sharpie.grindsim.splits.overworld.monument;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

import static sharpie.grindsim.utils.Settings.OCEAN_TRAVEL_CONSTANT;

public class TravelToMonument extends Split {

    public TravelToMonument() {


    }

    public SplitResult sim() {

        MonumentWorld world = MonumentWorldSampler.sampleWorld();

        SplitResult result = new SplitResult();

        result.setDidSucceed(true);

        result.setTime(new SplitLength(world.getMonumentDistance()/OCEAN_TRAVEL_CONSTANT, TimeUnit.SECONDS).getTime());

        result.setTime(result.timeToComplete + new SplitLength(30.0, TimeUnit.SECONDS).getTime());

        return result;
    }
}
