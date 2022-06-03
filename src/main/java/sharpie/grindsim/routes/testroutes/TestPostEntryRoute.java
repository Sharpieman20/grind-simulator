package sharpie.grindsim.routes.testroutes;

import sharpie.grindsim.agents.nethertravel.AggressiveTradeoffBlindAgent;
import sharpie.grindsim.routes.MaximumTimeRoute;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.end.End;
import sharpie.grindsim.splits.misc.RandomDeathSplit;
import sharpie.grindsim.splits.nether.CheckForBastion;
import sharpie.grindsim.splits.nether.ExitNetherFromBastion;
import sharpie.grindsim.splits.nether.TravelToBastion;
import sharpie.grindsim.splits.overworld.CheckForOcean;
import sharpie.grindsim.splits.overworld.OceanEntry;
import sharpie.grindsim.splits.stronghold.location.NetherTravelSplit;
import sharpie.grindsim.splits.stronghold.navigation.StrongholdNavigationSplit;
import sharpie.grindsim.splits.worldgen.WorldGen;
import sharpie.grindsim.utils.TimeUnit;

public class TestPostEntryRoute extends MaximumTimeRoute {

    public TestPostEntryRoute() {

        super(new SplitLength(12.0, TimeUnit.MINUTES));

        addSplit(new CheckForBastion(16));

        addSplit(new TravelToBastion());

        addSplit(new ExitNetherFromBastion());

        addSplit(new NetherTravelSplit(new AggressiveTradeoffBlindAgent()));

        addSplit(new StrongholdNavigationSplit());

        addSplit(new End());
    }
}