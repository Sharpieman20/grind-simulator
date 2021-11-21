package sharpie.grindsim.utils;

public class Point {

    public int x;

    public int z;

    public Point() {


    }

    public Point(int x, int z) {

        this.x = x;
        this.z = z;
    }

    public static Point origin() {

        return new Point();
    }

    public double distanceTo(Point other) {

        return Math.sqrt(Math.pow(x - other.x,2.0)+Math.pow(z-other.z,2.0));
    }

    public Point asOverworldPoint() {

        Point overworldPoint = new Point(this.x*8, this.z*8);

        return overworldPoint;
    }

    public Point asNetherPoint() {

        Point netherPoint = new Point(this.x/8, this.z/8);

        return netherPoint;
    }

    public Point travelPercentageDistanceTowardsPoint(Point otherPoint, double percentage) {

        Point midpoint = new Point();

        midpoint.x = (int) (((1-percentage) * this.x) + (percentage * otherPoint.x));
        midpoint.z = (int) (((1-percentage) * this.z) + (percentage * otherPoint.z));

        return midpoint;
    }

    public Point travelDistanceTowardsPoint(Point otherPoint, double distance) {

        return travelPercentageDistanceTowardsPoint(otherPoint, distance/this.distanceTo(otherPoint));
    }

    public String toString() {

        return x + " " + z;
    }
}
