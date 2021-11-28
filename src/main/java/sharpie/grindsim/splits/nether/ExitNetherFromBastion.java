package sharpie.grindsim.splits.nether;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class ExitNetherFromBastion extends SimpleSplit {

    public ExitNetherFromBastion() {

        super(0.14, new SplitLength(5.0, TimeUnit.MINUTES));
    }
}
