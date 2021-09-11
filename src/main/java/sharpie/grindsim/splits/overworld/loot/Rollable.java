package sharpie.grindsim.splits.overworld.loot;

import static sharpie.grindsim.utils.Utils.nextDouble;

class Rollable {

    int numChests;
    int minStacks;
    int maxStacks;
    int weight;
    int totalWeight;
    int minCount;
    int maxCount;

    public Rollable() {


    }

    protected void setNumChests(int numChests) {

        this.numChests = numChests;
    }

    protected void setMinStacks(int minStacks) {

        this.minStacks = minStacks;
    }

    protected void setMaxStacks(int maxStacks) {

        this.maxStacks = maxStacks;
    }

    protected void setWeight(int weight) {

        this.weight = weight;
    }

    protected void setTotWeight(int weight) {

        this.totalWeight = weight;
    }

    protected void setMinCount(int minCount) {

        this.minCount = minCount;
    }

    protected void setMaxCount(int maxCount) {

        this.maxCount = maxCount;
    }

    public int roll() {

        int total = 0;

        for (int i = 0; i < numChests; i++) {

            int stacks = minStacks;

            stacks += (int) (nextDouble() * (maxStacks-minStacks+1));

            for (int j = 0; j < stacks; j++) {

                int weight = (int) (nextDouble() * totalWeight);

                if (weight < this.weight) {

                    int count = minCount;

                    count += (int) (nextDouble() * (maxCount - minCount +1));

                    total += count;

                }
            }
        }

        return total;
    }
}