package sharpie.grindsim.splits.end;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.end.EndFightAgent;
import sharpie.grindsim.splits.end.NSGroundAgent;
import sharpie.grindsim.splits.end.TwoCycleAgent;

public class End extends Split {

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
