package sharpie.grindsim.splits.nether;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class SimpleBarter extends SimpleSplit {


    public SimpleBarter(double chance) {

        super(chance, new SplitLength(2.0, TimeUnit.MINUTES));
    }
}