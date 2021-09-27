package sharpie.grindsim.agents;

public class CoordRDResetAgent extends RDResetAgent {

    public CoordRDResetAgent(int rd) {

        super(rd);
    }

    @Override
    public boolean shouldReset(int x, int z) {

        if (x < -100 && z < -100) {

            return true;
        }

        return false;
    }
}
