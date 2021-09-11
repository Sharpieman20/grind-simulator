package sharpie.grindsim.splits.nether.bartering;

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
//    public MonumentTreasureBarterTree() {
//
//        LootCondition = new LootCondition(BuriedTreasureLoot.getDiamonds(), 3);
//
//        addLootBarter(lootCondition, barter);
//
//        GoldLoot loot = new MonumentAndBuriedTreasure();
//
//        addLootBarter(loot, barter);
//    }
}
