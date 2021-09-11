package sharpie.grindsim.results;

public class SplitResult {


    public boolean didSucceed;

    public double timeToComplete;

    public void setDidSucceed(boolean didSucceed) {

        this.didSucceed = didSucceed;
    }

    public void setTime(double time) {

        timeToComplete = time;
    }
}