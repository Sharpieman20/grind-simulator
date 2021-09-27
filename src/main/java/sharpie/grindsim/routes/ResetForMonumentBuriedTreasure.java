package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.bartering.MonumentTreasureBarterTree;
import sharpie.grindsim.splits.nether.bartering.SimpleBarter;
import sharpie.grindsim.splits.overworld.CheckForBuriedTreasure;
import sharpie.grindsim.splits.overworld.monument.CheckForMonument;

public class ResetForMonumentBuriedTreasure extends SimpleMonumentRoute {



    public ResetForMonumentBuriedTreasure(int monumentRd, int buriedTreasureRd) {

        super(monumentRd);

         addSplitAfter(CheckForMonument.class, new CheckForBuriedTreasure(buriedTreasureRd));

        replaceSplit(SimpleBarter.class, new MonumentTreasureBarterTree());
    }
}