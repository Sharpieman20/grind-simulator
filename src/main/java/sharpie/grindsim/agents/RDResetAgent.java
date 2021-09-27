package sharpie.grindsim.agents;

import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class RDResetAgent extends MonumentResetAgent {

    public RDResetAgent(int rd) {

        super(rd);
    }

    public boolean shouldReset(int x, int z) {

        return false;
    }

    public boolean shouldResetAfterExitMonumentAtTime(SplitLength time) {

        return false;
    }

    public boolean shouldResetAfterExitRuinedPortalAtTime(SplitLength time) {

        if (time.getTime() > new SplitLength(3.5, TimeUnit.MINUTES).getTime()) {

            return true;
        }

        return false;
    }
}
