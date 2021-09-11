package sharpie.sim.config;

public abstract class SimConfig {

    Route routeToRun;

    SimulatorResults results;

    public void runTrial() {

        SimulatorResults trialResults = routeToRun.sim();

        results.add(trialResults);
    }

    public abstract boolean shouldKeepRunning();
}