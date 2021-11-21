package sharpie.grindsim.routes;

import sharpie.grindsim.results.SimulatorResults;
import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.utils.Run;

import java.util.ArrayList;
import java.util.List;

public abstract class Route {

    List<Split> splits;

    boolean doesBackgroundResets;

    public Route() {

        splits = new ArrayList<>();
    }

    protected void addSplit(Split newSplit) {

        splits.add(newSplit);
    }

    protected void addSplitAfter(Class splitClass, Split newSplit) {

        int index = 0;

        for (Split split : splits) {

            if (splitClass.isInstance(split)) {

                splits.add(index+1, newSplit);

                return;
            }

            index++;
        }
    }

    protected void replaceSplit(Class splitClass, Split newSplit) {

        int index = 0;

        for (Split split : splits) {

            if (splitClass.isInstance(split)) {

                splits.set(index, newSplit);

                return;
            }

            index++;
        }
    }

    public SimulatorResults sim() {

        double time = 0.0;

        boolean successful = true;

        Run.startNewRun();

        for (Split split : splits) {

            SplitResult result = split.sim();

            time += result.timeToComplete;

            if (!result.didSucceed) {

                successful = false;

                break;
            }
        }

        SimulatorResults results = new SimulatorResults();

        results.setAttempts(1);

        results.addSuccess(successful);

        results.setTime(time);

        return results;
    }
}