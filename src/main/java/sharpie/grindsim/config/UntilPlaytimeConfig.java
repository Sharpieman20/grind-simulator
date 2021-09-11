package sharpie.grindsim.config;

import sharpie.grindsim.config.SimConfig;

public class UntilPlaytimeConfig extends SimConfig {

    double playtimeHours;

    public UntilPlaytimeConfig(double hours) {

        playtimeHours = hours;
    }

    public boolean shouldKeepRunning() {

        return results.getTotalPlaytimeHours() < playtimeHours;
    }
}