package sharpie.grindsim.splits.overworld;

import sharpie.grindsim.splits.SimpleSplit;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

public class CheckForMonument extends SimpleSplit {


    public CheckForMonument(int rd) {
        
        super(getCompletableChance(rd), new SplitLength(1.0, TimeUnit.SECONDS));
    }

    private static double getCompletableChance(int rd) {

        double spawnChunkChance = 0.0095;

        double chanceOfAnyMonument = spawnChunkChance;

        if (rd == 22) {

            chanceOfAnyMonument = 0.0625;
        }
        else if (rd == 15) {

            chanceOfAnyMonument = 0.0314;
        }
        else if (rd == 13) {

            chanceOfAnyMonument = 0.0231;
        }

        double completableChance = chanceOfAnyMonument - spawnChunkChance;

        return completableChance;
    }
}