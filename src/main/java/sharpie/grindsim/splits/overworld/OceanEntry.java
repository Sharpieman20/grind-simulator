package sharpie.grindsim.splits.overworld;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class OceanEntry extends SimpleSplit {


    public OceanEntry() {

        super(0.5, new SplitLength(3.0, TimeUnit.MINUTES));
    }

    public OceanEntry(double time) {

        super(1.0, new SplitLength(time, TimeUnit.MINUTES));
    }
}
