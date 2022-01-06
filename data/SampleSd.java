public class SampleSd {

    public static void main(String[] args) {

        int trials = 110;
        int successes = 48;

        double mean = ((double)successes)/trials;

        System.out.println(mean);

        double sumOfSquaredDiffs = 0.0;

        for (int i = 0; i < successes; i++) {

            double diff = 1.0 - mean;

            double squaredDiff = diff * diff;

            sumOfSquaredDiffs += squaredDiff;
        }

        for (int i = successes; i < trials; i++) {

            double diff = 0.0 - mean;

            double squaredDiff = diff * diff;

            sumOfSquaredDiffs += squaredDiff;
        }

        double variance = sumOfSquaredDiffs / (trials-1);

        double sd = Math.sqrt(variance);

        System.out.println(sd);
    }
}