package sharpie.grindsim.splits.stronghold.navigation;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.utils.Utils;

public class SimpleStrongholdNavAgent extends StrongholdNavigationAgent {

    public SplitResult doStrongholdNav() {

        SplitResult result = new SplitResult();

        if (Utils.nextDouble() < 0.25) {

            result.setDidSucceed(true);
            result.setTime(30.0);
        } else {

            result.setDidSucceed(false);
            result.setTime(120.0);
        }

        return result;
    }
}
