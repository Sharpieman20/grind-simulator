package sharpie.grindsim.agents.nethertravel;

import sharpie.grindsim.utils.Point;

public class TradeoffBlindAgent extends BlindAgent {

    double innerNetherDistance;
    double outerNetherDistance;

    public TradeoffBlindAgent(double innerNetherDistance, double outerNetherDistance) {

        this.innerNetherDistance = innerNetherDistance;
        this.outerNetherDistance = outerNetherDistance;
    }

    public Point doNetherTravel(Point startPoint) {

        Point overworldStartPoint = startPoint.asOverworldPoint();

        double travelInDistance = Math.max(0.0, Point.origin().distanceTo(overworldStartPoint) - outerNetherDistance*8);

        double travelOutDistance = -Math.max(0.0, innerNetherDistance*8 - Point.origin().distanceTo(overworldStartPoint));

        Point exitPoint = overworldStartPoint.travelDistanceTowardsPoint(Point.origin(), travelInDistance);

        exitPoint = exitPoint.travelDistanceTowardsPoint(Point.origin(), travelOutDistance);

        return exitPoint.asNetherPoint();
    }
}
