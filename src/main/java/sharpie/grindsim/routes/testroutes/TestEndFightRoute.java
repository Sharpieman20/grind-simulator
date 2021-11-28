package sharpie.grindsim.routes.testroutes;

import sharpie.grindsim.agents.nethertravel.*;
import sharpie.grindsim.agents.nethertravel.divine.SimplePortalDivineAgent;
import sharpie.grindsim.agents.nethertravel.divine.SmartPortalDivineAgent;
import sharpie.grindsim.results.SimulatorResults;
import sharpie.grindsim.routes.MaximumTimeRoute;
import sharpie.grindsim.routes.Route;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.nether.CheckForBastion;
import sharpie.grindsim.splits.nether.ExitNetherFromBastion;
import sharpie.grindsim.splits.nether.TravelToBastion;
import sharpie.grindsim.splits.overworld.CheckForOcean;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.stronghold.location.BlindTravelSplit;
import sharpie.grindsim.splits.stronghold.location.DivineTravelSplit;
import sharpie.grindsim.splits.stronghold.location.End;
import sharpie.grindsim.splits.stronghold.location.NetherTravelSplit;
import sharpie.grindsim.splits.worldgen.WorldGen;
import sharpie.grindsim.utils.TimeUnit;

public class TestEndFightRoute extends Route {

    public TestEndFightRoute() {

        addSplit(new End());
    }
}