package sharpie.grindsim.splits.nether;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class CheckForBastion extends SimpleSplit {

    public CheckForBastion(int rd) {

        super(getCompletableChance(rd), new SplitLength(1.0, TimeUnit.SECONDS));
    }

    private static double getCompletableChance(int rd) {

        if (rd == 16) {

            return 0.40;
        }

        return 0.0;
    }
}
