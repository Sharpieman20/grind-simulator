package sharpie.grindsim.splits.nether.bartering;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.overworld.loot.BuriedTreasureLoot;
import sharpie.grindsim.splits.overworld.loot.GoldSupplier;
import sharpie.grindsim.utils.TimeUnit;

import static sharpie.grindsim.utils.Utils.nextDouble;

public class BarterNoObby extends Split {

    GoldSupplier goldSupplier;


    public BarterNoObby(GoldSupplier goldSupplier) {

        this.goldSupplier = goldSupplier;

        this.splitLength = new SplitLength(2.0, TimeUnit.MINUTES);
    }

    private static double getCompletableChance(int gold) {

        double[] chances = new double[] {0.552, 0.569, 0.578, 0.591, 0.604, 0.616, 0.631, 0.641, 0.652, 0.665, 0.676, 0.689, 0.698, 0.711, 0.720, 0.730, 0.742, 0.749, 0.758};

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