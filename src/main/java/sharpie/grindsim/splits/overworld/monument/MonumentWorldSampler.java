package sharpie.grindsim.splits.overworld.monument;

import sharpie.grindsim.utils.Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MonumentWorldSampler {

    static List<MonumentWorld> worlds;

    private static int currentWorld = -1;

    public static void init() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("/Users/sharpieman20/Documents/Coding/Active/minecraft/grind-simulator/monument_seeds.txt"));

            String line;

            worlds = new ArrayList<>();

            while ((line = reader.readLine())!=null) {

                MonumentWorld world = MonumentWorldParser.parseWorld(line);

                worlds.add(world);
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

//        System.out.println(worlds.size());
    }

    public static MonumentWorld sampleWorld() {

        return sampleWorld(false);
    }

    public static MonumentWorld sampleWorld(boolean shouldBeDifferentWorld) {

        if (shouldBeDifferentWorld || currentWorld == -1) {

            currentWorld = Settings.random.nextInt(worlds.size());
        }

        return worlds.get(currentWorld);
    }
}
