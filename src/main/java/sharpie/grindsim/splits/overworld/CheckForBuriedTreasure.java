package sharpie.grindsim.splits.overworld;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class CheckForBuriedTreasure extends SimpleSplit {


    public CheckForBuriedTreasure(int rd) {

        super(getCompletableChance(rd), new SplitLength(1.0, TimeUnit.SECONDS));
    }

    private static double getCompletableChance(int rd) {

        double chanceToPass = 0.0;

        if (rd == 9) {

            chanceToPass = 0.123;
        }

        return chanceToPass;
    }
}