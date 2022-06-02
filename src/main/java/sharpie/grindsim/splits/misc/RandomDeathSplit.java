package sharpie.grindsim.splits.misc;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.end.EndFightAgent;
import sharpie.grindsim.splits.end.NSGroundAgent;
import sharpie.grindsim.splits.end.TwoCycleAgent;
import sharpie.grindsim.utils.TimeUnit;

public class RandomDeathSplit extends Split {

    public RandomDeathSplit() {
    }

    public SplitResult sim() {

        SplitResult result = new SplitResult();

        if (Math.random() < 0.5) {

            result.setDidSucceed(true);
        } else {

            result.setDidSucceed(false);
        }

        result.setTime(new SplitLength(1.0, TimeUnit.SECONDS).getTime());

        return result;
    }
}
