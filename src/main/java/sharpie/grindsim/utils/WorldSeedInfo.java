package sharpie.grindsim.utils;

public class WorldSeedInfo {


    public static long getAngleInfoFromSeed(long seed, int bits) {

        long info = seed & ((1 << bits) - 1);

        return info;
    }
}
