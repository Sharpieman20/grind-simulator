package sharpie.grindsim.routes;

import sharpie.grindsim.splits.nether.SimpleBarter;
import sharpie.grindsim.splits.overworld.CheckForMonument;
import sharpie.grindsim.splits.overworld.CheckForRuinedPortal;

public class ResetForMonumentRuinedPortal extends ResetForMonument {

    public ResetForMonumentRuinedPortal(int monumentRd, int portalRd) {

        super(monumentRd);

        addSplitAfter(CheckForMonument.class, new CheckForRuinedPortal(portalRd));

        replaceSplit(SimpleBarter.class, new SimpleBarter(0.3));
    }
}