package sharpie.grindsim.splits;

import sharpie.grindsim.results.SplitResult;

public abstract class Split {

    public SplitLength splitLength;

    public abstract SplitResult sim();
}