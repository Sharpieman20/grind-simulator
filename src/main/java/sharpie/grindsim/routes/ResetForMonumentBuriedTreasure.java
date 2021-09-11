package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.SimpleBarter;

public class ResetForMonumentBuriedTreasure extends ResetForMonument {

//    private ResetForMonumentBuriedTreasure(int rd) {
//
//        super(rd);
//    }

    public ResetForMonumentBuriedTreasure(int monumentRd, int portalRd) {

        super(monumentRd);

        // addSplitAfter(CheckForMonument.class, new CheckForRuinedPortal(portalRd));

        replaceSplit(SimpleBarter.class, new SimpleBarter(0.55));
    }
}