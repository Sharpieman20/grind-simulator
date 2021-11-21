package sharpie.grindsim.splits.overworld.monument;

import sharpie.grindsim.agents.MonumentResetAgent;
import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.TimeUnit;

import static sharpie.grindsim.utils.Settings.WORLDGEN_TIME;

public class ResetForMonument extends Split {

    MonumentResetAgent agent;


    public ResetForMonument(MonumentResetAgent agent) {

        this.agent = agent;
    }


    public SplitResult sim() {

        MonumentWorld monumentWorld = MonumentWorldSampler.sampleWorld(true);

        double time = WORLDGEN_TIME;

        SplitResult result = new SplitResult();

        if (monumentWorld.hasMonumentInRd(agent.getRD())) {

            if (!monumentWorld.hasMonumentInRd(6)) {

                if (!agent.shouldReset(monumentWorld.getSpawnX(), monumentWorld.getSpawnZ())) {

                    result.setDidSucceed(true);
                }
                else {

                    time -= WORLDGEN_TIME;

                    time += 2.0;
                }
            }
            else {

                time += 2.0;
            }


        }



        result.setTime(new SplitLength(time, TimeUnit.SECONDS).getTime());

        return result;
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