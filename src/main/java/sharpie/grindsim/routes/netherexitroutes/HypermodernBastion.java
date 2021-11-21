package sharpie.grindsim.routes.netherexitroutes;

import sharpie.grindsim.routes.Route;
import sharpie.grindsim.splits.nether.ExitNetherFromBastion;
import sharpie.grindsim.splits.overworld.CheckForOcean;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.worldgen.WorldGen;

public class HypermodernBastion extends Route {

    public HypermodernBastion() {

        addSplit(new WorldGen());

        addSplit(new CheckForOcean());

        addSplit(new OceanEntry());

//        addSplit(new CheckForBastion(16));
//
//        addSplit(new TravelToBastion());

        addSplit(new ExitNetherFromBastion());

//        addSplit(new SimpleBarter(0.07));
    }
}