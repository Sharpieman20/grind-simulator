package sharpie.grindsim.config;

import sharpie.grindsim.results.SimulatorResults;
import sharpie.grindsim.routes.Route;

public abstract class SimConfig {

    public Route routeToRun;

    public SimulatorResults results;

    public void runTrial() {

        SimulatorResults trialResults = routeToRun.sim();

        results.add(trialResults);
    }

    public SimulatorResults getResults() {

        return results;
    }

    public void resetStats() {

        results = new SimulatorResults();
    }

    public abstract boolean shouldKeepRunning();
}