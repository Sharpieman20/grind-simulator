package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.CheckForBastion;
import sharpie.grindsim.splits.nether.SimpleBarter;
import sharpie.grindsim.splits.nether.TravelToBastion;
import sharpie.grindsim.splits.overworld.CheckForMonument;
import sharpie.grindsim.splits.overworld.CheckForOcean;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.worldgen.WorldGen;

public class HypermodernBastion extends Route {

    public HypermodernBastion() {

        addSplit(new WorldGen());

        addSplit(new CheckForOcean());

        addSplit(new OceanEntry());

        addSplit(new CheckForBastion(16));

        addSplit(new TravelToBastion());

//        addSplit(new SimpleBarter(0.07));
    }
}