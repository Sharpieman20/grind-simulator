package sharpie.grindsim.splits.overworld;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class CheckForOcean extends SimpleSplit {


    public CheckForOcean() {

        super(0.1, new SplitLength(1.0, TimeUnit.SECONDS));
    }
}