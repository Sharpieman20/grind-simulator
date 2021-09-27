package sharpie.grindsim.agents;

import sharpie.grindsim.splits.SplitLength;

public abstract class MonumentResetAgent {

    int rd;

    public MonumentResetAgent(int rd) {

        this.rd = rd;
    }

    public int getRD() {

        return rd;
    }

    public abstract boolean shouldResetAfterExitMonumentAtTime(SplitLength time);

    public abstract boolean shouldResetAfterExitRuinedPortalAtTime(SplitLength time);

    public abstract boolean shouldReset(int xCoord, int zCoord);
}
