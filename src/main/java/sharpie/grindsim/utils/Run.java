package sharpie.grindsim.utils;

import java.util.HashMap;

public class Run {

    private static Run currentRun;

    HashMap<String, Object> fieldValues;

    private long seed;

    private Run() {

        this.seed = Utils.nextLong();
    }

    public long getWorldSeed() {

        return seed;
    }

    public void setField(String field, Object value) {

        fieldValues.put(field, value);
    }

    public Object getField(String field) {

        return fieldValues.get(field);
    }

    public static void startNewRun() {

        currentRun = new Run();
    }

    public static Run getCurrentRun() {

        return currentRun;
    }
}
