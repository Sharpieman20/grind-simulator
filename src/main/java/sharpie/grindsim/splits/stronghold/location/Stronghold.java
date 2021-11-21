package sharpie.grindsim.splits.stronghold.location;

import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.Run;
import sharpie.grindsim.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stronghold extends Point {

    public Stronghold(int x, int z) {

        super(x*16, z*16);
    }

    public static List<Stronghold> genStrongholds() {

        List<Stronghold> strongholds = new ArrayList<>();;

        Random worldSeedRandom = new Random(Run.getCurrentRun().getWorldSeed());
        double d = worldSeedRandom.nextDouble() * Math.PI * 2.0;
        int i = 32;
        int j = 128;
        int k = 3;
        int l = 0;
        int m = 0;
        for (int n = 0; n < 3; ++n) {
            double e = (double)(4 * i + i * m * 6) + (worldSeedRandom.nextDouble() - 0.5) * ((double)i * 2.5);
            int o = (int)Math.round(Math.cos(d) * e);
            int p = (int)Math.round(Math.sin(d) * e);
            strongholds.add(new Stronghold(o, p));
            d += Math.PI * 2 / ((double)k);
        }

        return strongholds;
    }


    public static Stronghold getClosestStrongholdInSet(Point base, List<Stronghold> strongholds) {

        Stronghold closest = null;
        double minDist = 999999.0;

        for (Stronghold stronghold : strongholds) {

            double dist = base.distanceTo(stronghold);

            if (dist < minDist) {

                minDist = dist;
                closest = stronghold;
            }
        }

        return closest;
    }

    public static Point getNearestStrongholdToCoords(Point point) {

        return getClosestStrongholdInSet(point, genStrongholds());
    }
}
