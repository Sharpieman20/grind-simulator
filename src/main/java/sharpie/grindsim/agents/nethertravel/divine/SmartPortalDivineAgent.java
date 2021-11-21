package sharpie.grindsim.agents.nethertravel.divine;

import sharpie.grindsim.agents.nethertravel.NetherTravelAgent;
import sharpie.grindsim.agents.nethertravel.SafeTradeoffBlindAgent;
import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.Run;
import sharpie.grindsim.utils.WorldSeedInfo;

public class SmartPortalDivineAgent extends PortalDivineAgent {

    public static int count;

    public SmartPortalDivineAgent() {
    }

    public Point doNetherTravel(Point startPoint) {

        long seed = Run.getCurrentRun().getWorldSeed();

        long info = WorldSeedInfo.getAngleInfoFromSeed(seed, 2);

        Point divineCenter = getClosestCenterPoint(startPoint, 2, info);

        double distanceToTravel = Math.max(0, startPoint.distanceTo(divineCenter)*8-1000);

        distanceToTravel *= 0.5;

        Point exitPoint = startPoint.travelDistanceTowardsPoint(divineCenter, distanceToTravel/8);

        NetherTravelAgent subAgent = new SafeTradeoffBlindAgent();

        if (subAgent.doNetherTravel(startPoint).distanceTo(startPoint) >= exitPoint.distanceTo(startPoint)) {

            exitPoint = subAgent.doNetherTravel(startPoint);
            count++;
        }

        return exitPoint;
    }
}
