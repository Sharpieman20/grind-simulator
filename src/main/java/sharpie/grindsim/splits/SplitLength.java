package sharpie.grindsim.splits;

import sharpie.grindsim.utils.TimeUnit;

public class SplitLength {

    double length;

    TimeUnit unit;

    public SplitLength(double length, TimeUnit unit) {

        this.length = length;

        this.unit = unit;
    }

    public double getTime() {

        double time = length;

        if (unit == TimeUnit.SECONDS) {

            time /= 60.0;
        } else if (unit == TimeUnit.HOURS) {

            time *= 60.0;
        }

        return time;
    }
}