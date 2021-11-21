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

    public double distanceTo(Point other) {

        return Math.sqrt(Math.pow(x - other.x,2.0)+Math.pow(z-other.z,2.0));
    }

    public Point asOverworldPoint() {

        Point overworldPoint = new Point(this.x*8, this.z*8);

        return overworldPoint;
    }

    public String toString() {

        return x + " " + z;
    }
}
