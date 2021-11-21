package sharpie.grindsim.utils;

public class Run {

    private static Run currentRun;

    private long seed;

    private Run() {

        this.seed = Utils.nextLong();
    }

    public long getWorldSeed() {

        return seed;
    }

    public static void startNewRun() {

        currentRun = new Run();
    }

    public static Run getCurrentRun() {

        return currentRun;
    }
}
