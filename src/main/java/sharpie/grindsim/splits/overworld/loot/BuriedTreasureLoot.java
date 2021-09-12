package sharpie.grindsim.splits.overworld.loot;

public class BuriedTreasureLoot implements GoldSupplier, DiamondSupplier {

    static final Rollable goldRoller = new BuriedTreasureGold();

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

    static final Rollable diamondRoller = new BuriedTreasureDiamonds();

    static class BuriedTreasureDiamonds extends Rollable {

        public BuriedTreasureDiamonds() {

            this.setNumChests(1);
            this.setMinStacks(1);
            this.setMaxStacks(3);
            this.setWeight(5);
            this.setTotWeight(15);
            this.setMinCount(1);
            this.setMaxCount(2);
        }
    }


    public int rollGold() {

        return goldRoller.roll();
    }

    public int rollDiamonds() {

        return diamondRoller.roll();
    }
}
