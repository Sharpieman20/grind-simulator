package sharpie.grindsim.routes.fullroutes;

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
import sharpie.grindsim.splits.worldgen.WorldGen;
import sharpie.grindsim.utils.TimeUnit;

public class HypermodernBastionFull extends MaximumTimeRoute {

    public HypermodernBastionFull() {

        super(new SplitLength(15.0, TimeUnit.MINUTES));

        addSplit(new WorldGen());

        addSplit(new CheckForOcean());

        addSplit(new OceanEntry());

        addSplit(new CheckForBastion(16));

        addSplit(new TravelToBastion());

        addSplit(new ExitNetherFromBastion());

        addSplit(new DivineTravelSplit());
    }
}