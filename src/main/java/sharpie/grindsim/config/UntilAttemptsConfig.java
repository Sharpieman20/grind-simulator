package sharpie.sim.config;

import sharpie.grindsim.config.SimConfig;

public class UntilAttemptsConfig extends SimConfig {

    int attempts;

    public UntilAttemptsConfig(int attempts) {

        this.attempts = attempts;
    }

    public boolean shouldKeepRunning() {

        return results.getAttempts() < attempts;
    }
}