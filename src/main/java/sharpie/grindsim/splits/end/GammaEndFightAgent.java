package sharpie.grindsim.splits.end;

import org.apache.commons.math3.distribution.GammaDistribution;
import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public abstract class GammaEndFightAgent extends EndFightAgent {

    GammaDistribution distribution;
    double minTime;

    public GammaEndFightAgent(double alpha, double beta, double minTime) {

        distribution = new GammaDistribution(alpha, beta);
        this.minTime = minTime;
    }

    private double getEndFightLength() {

        return distribution.sample() + minTime;
    }

    public SplitResult doEndFight() {

        SplitResult result = new SplitResult();

        result.setDidSucceed(true);

        result.setTime(new SplitLength(getEndFightLength(), TimeUnit.SECONDS).getTime());

        return result;
    }
}
