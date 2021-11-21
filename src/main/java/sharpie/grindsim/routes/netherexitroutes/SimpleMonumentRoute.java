package sharpie.grindsim.routes.netherexitroutes;

import sharpie.grindsim.routes.Route;
import sharpie.grindsim.splits.nether.bartering.SimpleBarter;
import sharpie.grindsim.splits.overworld.monument.CheckForMonument;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.worldgen.WorldGen;

public class SimpleMonumentRoute extends Route {

    public SimpleMonumentRoute(int rd) {

        addSplit(new WorldGen());

        addSplit(new CheckForMonument(rd));

        addSplit(new OceanEntry());

        addSplit(new SimpleBarter(0.069));
    }
}