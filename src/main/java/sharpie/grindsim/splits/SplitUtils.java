package sharpie.grindsim.splits;

import sharpie.grindsim.utils.TimeUnit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SplitUtils {

    /**
     * Only supported format is HH:MM:SS.sss
     *
     * @return SplitLength
     */
    public static SplitLength getSplitLengthFromTimeString(String timeString) {

        String[] subArrays = timeString.split("[:\\.]");

        int millis = 0;

        int hours = Integer.parseInt(subArrays[0]);

        millis += hours;

        millis *= 60;

        int minutes = Integer.parseInt(subArrays[1]);

        millis += minutes;

        millis *= 60;

        int seconds = Integer.parseInt(subArrays[2]);

        millis += seconds;

        millis *= 1000;

        millis += Integer.parseInt(subArrays[3]);

        return new SplitLength(millis, TimeUnit.MILLISECONDS);
    }
}
