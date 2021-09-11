package sharpie.grindsim.splits.nether.bartering;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.overworld.loot.BuriedTreasureLoot;
import sharpie.grindsim.splits.overworld.loot.GoldSupplier;
import sharpie.grindsim.utils.TimeUnit;

import static sharpie.grindsim.utils.Utils.nextDouble;

public class BarterMinimum extends Split {

    GoldSupplier goldSupplier;


    public BarterMinimum(GoldSupplier goldSupplier) {

        this.goldSupplier = goldSupplier;

        this.splitLength = new SplitLength(2.0, TimeUnit.MINUTES);
    }

    private static double getCompletableChance(int gold) {

        double[] chances = new double[] {0.069, 0.074, 0.081, 0.09, 0.097, 0.108, 0.114, 0.125, 0.133, 0.145, 0.156, 0.166, 0.178, 0.187, 0.200, 0.212, 0.224, 0.238, 0.252};

        if (gold-72 >= chances.length) {

            return chances[chances.length-1];
        }

        return chances[gold-72];
    }

    public SplitResult sim() {

        SplitResult result = new SplitResult();

        int gold = goldSupplier.rollGold();

        double chance = getCompletableChance(gold);

        result.setDidSucceed(nextDouble() < chance);

        result.setTime(splitLength.getTime());

        return result;
    }
}