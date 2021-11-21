package sharpie.grindsim.agents.nethertravel.divine;

import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.Run;
import sharpie.grindsim.utils.WorldSeedInfo;

public class SimplePortalDivineAgent extends PortalDivineAgent {

    public SimplePortalDivineAgent() {
    }

    public Point doNetherTravel(Point startPoint) {

        long seed = Run.getCurrentRun().getWorldSeed();

        long info = WorldSeedInfo.getAngleInfoFromSeed(seed, 2);

        Point divineCenter = getClosestCenterPoint(startPoint, 2, info);

        return divineCenter;
    }
}
