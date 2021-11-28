package sharpie.grindsim.splits.stronghold.location;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.end.EndFightAgent;
import sharpie.grindsim.splits.end.TwoCycleAgent;

public class End extends Split {

    private static final double DIG_TIME = 20.0;

    EndFightAgent agent;

    public End() {

        this(new TwoCycleAgent());
    }

    public End(EndFightAgent agent) {

        this.agent = agent;
    }

    public SplitResult sim() {

        return this.agent.doEndFight();
    }
}
