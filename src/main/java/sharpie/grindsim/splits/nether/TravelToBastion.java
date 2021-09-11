package sharpie.grindsim.splits.nether;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class TravelToBastion extends SimpleSplit {

    public TravelToBastion() {

        super(0.625, new SplitLength(45.0, TimeUnit.SECONDS));
    }
}
