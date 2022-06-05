package sharpie.grindsim.results;

import sharpie.grindsim.splits.SplitLength;

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

    public String showSuccessRatesByThreshold(List<SplitLength> thresholdTimes) {

        List<Double> copiedTimes = new ArrayList<>();

        for (Double time : successPlaytimes) {

            copiedTimes.add(time);
        }

        Collections.sort(copiedTimes);

        Collections.sort(thresholdTimes);

        List<Integer> thresholdCounts = new ArrayList<>();

        thresholdCounts.add(0);

        int thresholdIndex = 0;
        int timeIndex = 0;

        while (timeIndex < copiedTimes.size()) {

            if (copiedTimes.get(timeIndex) > thresholdTimes.get(thresholdIndex).getTime()) {

                thresholdCounts.add(thresholdCounts.get(thresholdIndex++));
                continue;
            }

            thresholdCounts.set(thresholdIndex, thresholdCounts.get(thresholdIndex)+1);
            timeIndex++;
        }

        while (thresholdCounts.size() < thresholdTimes.size()) {

            thresholdCounts.add(thresholdCounts.get(thresholdCounts.size()-1));
        }

        String result = "Total Percentage Better than Max Time";

        for (int i = 0; i < thresholdTimes.size(); i++) {

            result += "\n\t";

            double thresholdPercentage = ((double)thresholdCounts.get(i)) / getAttempts();

            String partialString = thresholdTimes.get(i).toString();

            while (partialString.length() < 13) {

                partialString += " ";
            }

            result += partialString + " | " + String.format("%02.3f", thresholdPercentage*100.0) + "%";
        }

        return result;
    }

    public String toString() {

        String result = "";

        result += "Average time on successes: " + showTimeForSuccesses() + "\n";
        result += "Success rate: " + showSuccessRate() + "\n";
        result += "Total playtime per success: " + showTotalTimePerSuccess() + "\n";
        result += "Attempts per success: " + attempts / successes + "\n";

        return result;
    }
}