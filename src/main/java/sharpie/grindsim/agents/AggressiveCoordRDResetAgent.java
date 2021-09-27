package sharpie.grindsim.agents;

public class AggressiveCoordRDResetAgent extends RDResetAgent {

    public AggressiveCoordRDResetAgent(int rd) {

        super(rd);
    }

    @Override
    public boolean shouldReset(int x, int z) {

        if (x < 0 || z < 0) {

            return true;
        }

        return false;
    }
}
