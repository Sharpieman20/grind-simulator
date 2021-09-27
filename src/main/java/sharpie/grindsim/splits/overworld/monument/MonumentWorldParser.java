package sharpie.grindsim.splits.overworld.monument;

import java.util.StringTokenizer;

public class MonumentWorldParser {

    public static MonumentWorld parseWorld(String line) {

        MonumentWorld world = new MonumentWorld();

        StringTokenizer st = new StringTokenizer(line);

        st.nextToken();

        world.spawnX = Integer.parseInt(st.nextToken());

        world.spawnZ = Integer.parseInt(st.nextToken());

        String monumentInfo = st.nextToken();

        if (!monumentInfo.equals("null")) {

            world.hasMonument = true;

            world.monumentX = Integer.parseInt(monumentInfo);
            world.monumentZ = Integer.parseInt(st.nextToken());
        }

        String ruinedportalInfo = st.nextToken();

        if (!ruinedportalInfo.equals("null")) {

            world.hasRuinedPortal = true;

            world.ruinedportalX = Integer.parseInt(ruinedportalInfo);
            world.ruinedportalZ = Integer.parseInt(st.nextToken());
        }

        return world;
    }
}
