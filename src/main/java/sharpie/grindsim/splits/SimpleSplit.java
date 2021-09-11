package sharpie.grindsim.splits;

import sharpie.grindsim.results.SplitResult;

import static sharpie.grindsim.utils.Utils.nextDouble;

public abstract class SimpleSplit extends Split {

    double chanceToSucceed;



    public SimpleSplit() {


    }

    public SimpleSplit(double chanceToSucceed, SplitLength length) {

        this.chanceToSucceed = chanceToSucceed;

        this.splitLength = length;
    }


    public SplitResult sim() {

        SplitResult result = new SplitResult();

        result.setDidSucceed(nextDouble() < chanceToSucceed);

        result.setTime(splitLength.getTime());

        return result;
    }
}