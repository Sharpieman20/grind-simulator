package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.bartering.SimpleBarter;
import sharpie.grindsim.splits.overworld.monument.CheckForMonument;
import sharpie.grindsim.splits.overworld.CheckForRuinedPortal;

public class ResetForMonumentRuinedPortal extends SimpleMonumentRoute {

    public ResetForMonumentRuinedPortal(int monumentRd, int portalRd) {

        super(monumentRd);

        addSplitAfter(CheckForMonument.class, new CheckForRuinedPortal(portalRd));

        replaceSplit(SimpleBarter.class, new SimpleBarter(0.3));
    }
}