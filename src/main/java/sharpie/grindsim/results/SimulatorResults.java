package sharpie.grindsim.results;

import java.util.ArrayList;
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

    public void addSuccess(boolean shouldAddSuccess) {

        if (shouldAddSuccess) {

            successes++;
        }
    }

    public void setTime(double playtime) {

        this.playtime = playtime;
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

        return String.format("%.3f",100.0*successes/attempts);
    }

    public String showTotalTimePerSuccess() {

        if (successes == 0.0) {

            return "0.0";
        }

        return String.format("%.3f",60.0*getTotalPlaytimeHours() / successes);
    }

    public String toString() {

        String result = "";

        result += "Time on successes: " + showTimeForSuccesses() + "\n";
        result += "Success rate: " + showSuccessRate() + "\n";
        result += "Time per success: " + showTotalTimePerSuccess() + "\n";

        return result;
    }
}