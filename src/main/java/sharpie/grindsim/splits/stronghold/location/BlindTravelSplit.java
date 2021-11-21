package sharpie.grindsim.splits.stronghold.location;

import sharpie.grindsim.agents.nethertravel.RingBlindAgent;

public class BlindTravelSplit extends NetherTravelSplit {

    public BlindTravelSplit() {

        super(new RingBlindAgent());
    }
}
