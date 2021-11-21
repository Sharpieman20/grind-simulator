package sharpie.grindsim.agents.nethertravel;

import sharpie.grindsim.agents.NetherTravelAgent;
import sharpie.grindsim.splits.stronghold.location.Divine;
import sharpie.grindsim.utils.Point;

import java.util.ArrayList;
import java.util.List;

public class DivineAgent extends NetherTravelAgent {

    Divine divine;

    public DivineAgent() {

    }

    public Point doNetherTravel(Point startPoint) {

        return startPoint;
    }

    private static final double baseDistance = 216;


    private static List<Point> getCenterPoints(long bits, long value) {

        double baseAngle = 0.125 + 0.25*value;

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            double angle = baseAngle + (2/3.0)*i;

            double radianAngle = Math.PI * angle;

            int pointX = (int) (Math.cos(radianAngle) * baseDistance);

            int pointZ = (int) (Math.sin(radianAngle) * baseDistance);

            Point point = new Point(pointX, pointZ);

            points.add(point);
        }

        return points;
    }

    protected static Point getClosestCenterPoint(Point basePoint, long bits, long value) {

        List<Point> points = getCenterPoints(bits, value);

        Point closestPoint = points.get(0);

        for (int i = 1; i < points.size(); i++) {

            if (points.get(i).distanceTo(basePoint) < closestPoint.distanceTo(basePoint)) {

                closestPoint = points.get(i);
            }
        }

        return closestPoint;
    }
}
