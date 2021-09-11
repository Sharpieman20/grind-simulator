package sharpie.grindsim.splits.overworld.loot;

public class BuriedTreasureLoot implements GoldSupplier {

    static final BuriedTreasureGold goldRoller = new BuriedTreasureGold();

    static class BuriedTreasureGold extends Rollable {

        public BuriedTreasureGold() {

            this.setNumChests(1);
            this.setMinStacks(5);
            this.setMaxStacks(8);
            this.setWeight(10);
            this.setTotWeight(20+10+5);
            this.setMinCount(1);
            this.setMaxCount(4);
        }
    }


    public int rollGold() {

        return goldRoller.roll();
    }
}
