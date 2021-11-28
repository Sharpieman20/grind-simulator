package sharpie.grindsim.splits.stronghold.navigation;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;

public class StrongholdNavigationSplit extends Split {

    StrongholdNavigationAgent agent;

    public StrongholdNavigationSplit() {

        this(new SimpleStrongholdNavAgent());
    }

    public StrongholdNavigationSplit(StrongholdNavigationAgent agent) {

        this.agent = agent;
    }

    public SplitResult sim() {

        return this.agent.doStrongholdNav();
    }
}
