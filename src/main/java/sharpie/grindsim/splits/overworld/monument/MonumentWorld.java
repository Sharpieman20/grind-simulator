package sharpie.grindsim.splits.overworld.monument;

import static sharpie.grindsim.utils.Utils.getDistanceBetween;

public class MonumentWorld {

    public int spawnX;

    public int spawnZ;

    public boolean hasMonument;

    public int monumentX;

    public int monumentZ;

    public boolean hasRuinedPortal;

    public int ruinedportalX;

    public int ruinedportalZ;

    public boolean hasMonumentInRd(int rd) {

        if (!hasMonument) {

            return false;
        }

        int xDist = Math.abs(spawnX - monumentX);

        int zDist = Math.abs(spawnZ - monumentZ);

        int furtherDist = Math.max(xDist, zDist);

        int furtherDistInChunks = (int) Math.round(Math.ceil(furtherDist / 16.0));

        return furtherDistInChunks <= rd;
    }

    public int getSpawnX() {

        return spawnX;
    }

    public int getSpawnZ() {

        return spawnZ;
    }

    public double getTravelDistance() {

        double distanceSpawnToMonument = getDistanceBetween(spawnX, spawnZ, monumentX, monumentZ);

        double distanceSpawnToRuinedPortal = getDistanceBetween(spawnX, spawnZ, ruinedportalX, ruinedportalZ);

        double distanceMonumentToRuinedPortal = getDistanceBetween(monumentX, monumentZ, ruinedportalX, ruinedportalZ);

        double path1 = distanceSpawnToMonument + distanceMonumentToRuinedPortal;

        double path2 = distanceSpawnToRuinedPortal + distanceMonumentToRuinedPortal;

        return Math.min(path1, path2);
    }

    public double getMonumentDistance() {

        return getDistanceBetween(spawnX, spawnZ, monumentX, monumentZ);
    }
}
