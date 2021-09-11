package sharpie.grindsim.results;

public class SimulatorResults {

    int successes;

    int attempts;

    double playtime;


    public SimulatorResults() {


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

        this.successes += other.successes;

        this.attempts += other.attempts;

        this.playtime += other.playtime;
    }

    public String toString() {

        if (successes == 0.0) {

            return "0.0";
        }

        return String.format("%.3f",playtime / successes);
    }
}