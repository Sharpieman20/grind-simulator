package sharpie.grindsim.splits.overworld;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class CheckForRuinedPortal extends SimpleSplit {


    public CheckForRuinedPortal(int rd) {

        super(getCompletableChance(rd), new SplitLength(30.0, TimeUnit.SECONDS));
    }


    private static double getCompletableChance(int rd) {

        if (rd == 9) {

            return 0.1837;
        }
        if (rd == 7) {

            return 0.1067;
        }

        return 0.0;
    }
}