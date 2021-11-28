package sharpie.grindsim.splits.stronghold.location;

import sharpie.grindsim.agents.nethertravel.BlindAgent;
import sharpie.grindsim.agents.nethertravel.NetherTravelAgent;
import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.end.EndFightAgent;
import sharpie.grindsim.splits.end.NSGroundAgent;
import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.TimeUnit;
import sharpie.grindsim.utils.Utils;

public class End extends Split {

    private static final double DIG_TIME = 20.0;

    EndFightAgent agent;

    public End() {

        this(new NSGroundAgent());
    }

    public End(EndFightAgent agent) {

        this.agent = agent;
    }

    public SplitResult sim() {

        return this.agent.doEndFight();
    }
}
