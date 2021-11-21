package sharpie.grindsim.routes.netherexitroutes;

import sharpie.grindsim.agents.MonumentResetAgent;
import sharpie.grindsim.routes.Route;
import sharpie.grindsim.splits.nether.bartering.SimpleBarter;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.overworld.monument.CheckForRuinedPortalAfterMonument;
import sharpie.grindsim.splits.overworld.monument.ResetForMonument;
import sharpie.grindsim.splits.overworld.monument.TravelToMonument;
import sharpie.grindsim.splits.worldgen.WorldGen;

public class PosposumentRoute extends Route {

    public PosposumentRoute(MonumentResetAgent agent) {

        super();

        addSplit(new WorldGen());

        addSplit(new ResetForMonument(agent));

        addSplit(new TravelToMonument());

        addSplit(new CheckForRuinedPortalAfterMonument(agent));

        addSplit(new OceanEntry(0.75));

//        addSplit(new SimpleBarter(0.27));
    }
}