package sharpie.grindsim.splits;

import sharpie.grindsim.results.SplitResult;

import java.util.List;

import static sharpie.grindsim.utils.Utils.nextDouble;
import static sharpie.grindsim.utils.Utils.nextInt;

public abstract class TimeListSplit extends SimpleSplit {

    List<SplitLength> splitLengthPossibilities;

    public TimeListSplit(double chanceToSucceed, List<SplitLength> splitLengthPossibilities) {

        super(chanceToSucceed, null);

        this.splitLengthPossibilities = splitLengthPossibilities;
    }


    public SplitResult sim() {

        this.splitLength = splitLengthPossibilities.get(nextInt(0, splitLengthPossibilities.size()));

        return super.sim();
    }
}