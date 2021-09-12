package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.bartering.SimpleBarter;
import sharpie.grindsim.splits.overworld.CheckForMonument;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.worldgen.WorldGen;

public class ResetForMonument extends Route {

    public ResetForMonument(int rd) {

        addSplit(new WorldGen());

        addSplit(new CheckForMonument(rd));

        addSplit(new OceanEntry());

        addSplit(new SimpleBarter(0.069));
    }
}