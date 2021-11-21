package sharpie.grindsim.routes;

import sharpie.grindsim.results.SimulatorResults;
import sharpie.grindsim.splits.SplitLength;

public class MaximumTimeRoute extends Route {

    SplitLength maxTime;

    public MaximumTimeRoute(SplitLength maxTime) {

        super();

        this.maxTime = maxTime;
    }

    @Override
    public SimulatorResults sim() {

        SimulatorResults results = super.sim();

        if (results.getSuccesses() == 1) {

            if (results.getTime() > maxTime.getTime()) {

                results.markUnsuccessful();
            }
        }

        return results;
    }
}
