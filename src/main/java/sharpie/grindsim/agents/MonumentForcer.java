package sharpie.grindsim.agents;

import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class MonumentForcer extends MonumentResetAgent {

    public MonumentForcer() {

        super(32);
    }

    public boolean shouldResetAfterExitMonumentAtTime(SplitLength time) {

        return false;
    }

    public boolean shouldReset(int x, int z) {

        return false;
    }

    public boolean shouldResetAfterExitRuinedPortalAtTime(SplitLength time) {

        return false;
    }
}
