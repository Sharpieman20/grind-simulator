package sharpie.grindsim.splits.worldgen;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class WorldGen extends SimpleSplit {

//    WorldCriteria criteria;

    public WorldGen() {

        super(1.0, new SplitLength(0.1, TimeUnit.SECONDS));
    }
}