package sharpie.grindsim.routes.fullroutes;

import sharpie.grindsim.agents.nethertravel.*;
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
import sharpie.grindsim.splits.stronghold.location.NetherTravelSplit;
import sharpie.grindsim.splits.worldgen.WorldGen;
import sharpie.grindsim.utils.TimeUnit;

public class TestNetherTravelRoute extends Route {

    // SOME AVERAGES
    // Aggro tradeoff = 7.15
    // FSG blind = 7.048
    // Blind = 7.04
    // Divine (2000) = 6.985
    // Divine (500) = 6.969
    // Ring Blind = 6.956
    // Divine (1500) = 6.908
    // Divine (750) = 6.901
    // Divine (1000) = 6.877
    // Force optimal = 6.799
    // Safe tradeoff = 6.741

    public TestNetherTravelRoute() {

        addSplit(new NetherTravelSplit(new ForceOptimalBlindAgent()));
    }
}