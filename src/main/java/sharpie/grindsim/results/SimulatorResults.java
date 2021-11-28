package sharpie.grindsim.results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulatorResults {

    int successes;

    int attempts;

    double playtime;

    List<Double> successPlaytimes;


    public SimulatorResults() {

        successPlaytimes = new ArrayList<>();
    }

    public void setAttempts(int attempts) {

        this.attempts = attempts;
    }

    public int getAttempts() {

        return attempts;
    }

    public int getSuccesses() {

        return successes;
    }

    public void addSuccess(boolean shouldAddSuccess) {

        if (shouldAddSuccess) {

            successes++;
        }
    }

    public void markUnsuccessful() {

        successes = 0;
    }

    public void setTime(double playtime) {

        this.playtime = playtime;
    }

    public double getTime() {

        return playtime;
    }

    public double getTotalPlaytimeHours() {

        return playtime / 60.0;
    }

    public void add(SimulatorResults other) {

        if (other.successes > 0) {

            successPlaytimes.add(other.playtime);
        }

        this.successes += other.successes;

        this.attempts += other.attempts;

        this.playtime += other.playtime;
    }

    public String showTimeForSuccesses() {

        double total = 0.0;

        for (Double value : successPlaytimes) {

            total += value;
        }

        return String.format("%.3f",total/successes);
    }

    public String showSuccessRate() {

        return String.format("%.3f",100.0*successes/attempts)+"%";
    }

    public String showTotalTimePerSuccess() {

        if (successes == 0.0) {

            return "0.0";
        }

        return String.format("%.3f",60.0*getTotalPlaytimeHours() / successes);
    }

    public String showSuccessTimePercentiles() {

        List<Double> copiedTimes = new ArrayList<>();

        for (Double time : successPlaytimes) {

            copiedTimes.add(time);
        }

        Collections.sort(copiedTimes);

        double[] percentiles = new double[]{0.01, 0.1, 0.5, 1.0, 2.0, 4.0, 8.0, 16.0, 32.0, 50.0, 75.0, 99.0};

        double[] results = new double[percentiles.length];

        for (int i = 0; i < percentiles.length; i++) {

            results[i] = copiedTimes.get((int) (copiedTimes.size()*percentiles[i]/100.0));
        }

        String result = "";

        for (int i = 0; i < percentiles.length; i++) {

            result += percentiles[i] + " " + String.format("%.1f", results[i]) + "\n";
        }

        return result;
    }

    public String toString() {

        String result = "";

        result += "Time on successes: " + showTimeForSuccesses() + "\n";
        result += "Success rate: " + showSuccessRate() + "\n";
        result += "Total playtime per success: " + showTotalTimePerSuccess() + "\n";

        return result;
    }
}