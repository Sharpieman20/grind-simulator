package sharpie.grindsim.splits.nether.bartering;

import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.overworld.loot.BuriedTreasureLoot;
import sharpie.grindsim.splits.overworld.loot.GoldSupplier;

public class MonumentTreasureBarterTree extends BarterTree {

    public static class MonumentAndBuriedTreasure implements GoldSupplier {

        public int rollGold() {

            return 72 + new BuriedTreasureLoot().rollGold();
        }
    }

    public MonumentTreasureBarterTree() {
    }

    public SplitResult sim() {

        int diamonds = new BuriedTreasureLoot().rollDiamonds();

        if (diamonds >= 3) {

            return new BarterNoObby(new MonumentAndBuriedTreasure()).sim();
        }

        return new BarterMinimum(new MonumentAndBuriedTreasure()).sim();
    }
}
