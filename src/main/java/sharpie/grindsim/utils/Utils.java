package sharpie.grindsim.utils;

public class Utils {

    public static double nextDouble() {

        return Settings.random.nextDouble();
    }

    public static long nextLong() {

        return Settings.random.nextLong();
    }

    public static double getDistanceBetween(int x1, int z1, int x2, int z2) {

        return Math.sqrt(Math.pow(x1-x2,2.0)+Math.pow(z1-z2,2.0));
    }
}