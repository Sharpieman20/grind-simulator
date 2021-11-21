package sharpie.grindsim.agents.nethertravel;

import sharpie.grindsim.utils.Point;

public class FSGBlindAgent extends BlindAgent {

    public Point doNetherTravel(Point startPoint) {

        int x = (int) (150*Math.signum(startPoint.x));

        int z = (int) (150*Math.signum(startPoint.z));

        return new Point(x, z);
    }
}
