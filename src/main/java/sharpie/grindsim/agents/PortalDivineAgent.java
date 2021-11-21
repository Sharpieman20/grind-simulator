package sharpie.grindsim.agents;

import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.Run;
import sharpie.grindsim.utils.WorldSeedInfo;

public class PortalDivineAgent extends NetherTravelAgent {

    public PortalDivineAgent() {
    }

    public Point doNetherTravel(Point startPoint) {

        long seed = Run.getCurrentRun().getWorldSeed();

        long info = WorldSeedInfo.getAngleInfoFromSeed(seed, 2);

        System.out.println(info);

        return startPoint;
    }
}
