package sharpie.grindsim.agents.nethertravel;

import sharpie.grindsim.agents.nethertravel.DivineAgent;
import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.Run;
import sharpie.grindsim.utils.WorldSeedInfo;

public class PortalDivineAgent extends DivineAgent {

    public PortalDivineAgent() {
    }

    public Point doNetherTravel(Point startPoint) {

        long seed = Run.getCurrentRun().getWorldSeed();

        long info = WorldSeedInfo.getAngleInfoFromSeed(seed, 2);

        Point divineCenter = getClosestCenterPoint(startPoint, 2, info);

        int distanceToTravel = (int) Math.max(0, startPoint.distanceTo(divineCenter)*8-1500);

        Point exitPoint = startPoint.travelDistanceTowardsPoint(divineCenter, distanceToTravel/8);

        return exitPoint;
    }
}
