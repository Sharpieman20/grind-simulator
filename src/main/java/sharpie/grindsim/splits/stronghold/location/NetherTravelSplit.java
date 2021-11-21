package sharpie.grindsim.splits.stronghold.location;

import sharpie.grindsim.agents.nethertravel.BlindAgent;
import sharpie.grindsim.agents.NetherTravelAgent;
import sharpie.grindsim.results.SplitResult;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.utils.Point;
import sharpie.grindsim.utils.TimeUnit;
import sharpie.grindsim.utils.Utils;

public class NetherTravelSplit extends Split {

    private static final double DIG_TIME = 20.0;

    NetherTravelAgent agent;
    double netherWeight;
    double overworldWeight;
    boolean shouldDig;

    public NetherTravelSplit() {

        this(new BlindAgent());
    }

    public NetherTravelSplit(NetherTravelAgent agent) {

        this(agent, 0.4, 0.2, true);
    }


    public NetherTravelSplit(NetherTravelAgent agent, double netherWeight, double overworldWeight, boolean shouldDig) {

        this.agent = agent;
        this.netherWeight = netherWeight;
        this.overworldWeight = overworldWeight;
        this.shouldDig = shouldDig;
    }

    protected double getWeightedNetherDistance(double distance) {

        return netherWeight * distance;
    }

    protected double getWeightedOverworldDistance(double distance) {

        return overworldWeight * distance;
    }

    protected boolean shouldDig() {

        return shouldDig;
    }

    protected Point getStartPoint() {

        Point blazeSpawnerPoint = new Point();

        blazeSpawnerPoint.x = (int) (Utils.nextDouble() * 368.0 * 2 - 368.0);
        blazeSpawnerPoint.z = (int) (Utils.nextDouble() * 368.0 * 2 - 368.0);

        return blazeSpawnerPoint;
    }

    public SplitResult sim() {

        Point startPoint = getStartPoint();

        Point exitNetherPoint = agent.doNetherTravel(startPoint);

        double netherDistance = startPoint.distanceTo(exitNetherPoint);

        double weightedNetherDistance = getWeightedNetherDistance(netherDistance);

        Point stronghold = Stronghold.getNearestStrongholdToCoords(exitNetherPoint);

        double weightedOverworldDistance = getWeightedOverworldDistance(exitNetherPoint.asOverworldPoint().distanceTo(stronghold));

        double totalTime = weightedNetherDistance + weightedOverworldDistance;

        if (shouldDig()) {

            totalTime += DIG_TIME;
        }

        SplitResult result = new SplitResult();

        result.setTime(new SplitLength(totalTime, TimeUnit.SECONDS).getTime());

        result.setDidSucceed(true);

        return result;
    }
}
