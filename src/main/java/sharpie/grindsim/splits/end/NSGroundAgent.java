package sharpie.grindsim.splits.end;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class NSGroundAgent extends EndFightAgent {

    public SplitResult doEndFight() {

        SplitResult result = new SplitResult();

        result.setDidSucceed(true);

        result.setTime(new SplitLength(5.0, TimeUnit.MINUTES).getTime());

        return result;
    }
}
