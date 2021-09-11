package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.bartering.BarterMinimum;
import sharpie.grindsim.splits.nether.bartering.MonumentTreasureBarterTree;
import sharpie.grindsim.splits.nether.bartering.SimpleBarter;
import sharpie.grindsim.splits.overworld.loot.BuriedTreasureLoot;
import sharpie.grindsim.splits.overworld.loot.GoldSupplier;

public class ResetForMonumentBuriedTreasure extends ResetForMonument {



    public ResetForMonumentBuriedTreasure(int monumentRd, int buriedTreasureRd) {

        super(monumentRd);

        // addSplitAfter(CheckForMonument.class, new CheckForRuinedPortal(portalRd));

        replaceSplit(SimpleBarter.class, new BarterMinimum(new MonumentTreasureBarterTree.MonumentAndBuriedTreasure()));
    }
}