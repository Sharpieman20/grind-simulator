package sharpie.grindsim.splits.stronghold.navigation;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;
import sharpie.grindsim.utils.Utils;

public class SimpleStrongholdNavAgent extends StrongholdNavigationAgent {

    public SplitResult doStrongholdNav() {

        SplitResult result = new SplitResult();

        if (Utils.nextDouble() < 0.25) {

            result.setDidSucceed(true);
            result.setTime(new SplitLength(30.0, TimeUnit.SECONDS).getTime());
        } else {

            result.setDidSucceed(false);
            result.setTime(new SplitLength(2.0, TimeUnit.MINUTES).getTime());
        }

        return result;
    }
}
