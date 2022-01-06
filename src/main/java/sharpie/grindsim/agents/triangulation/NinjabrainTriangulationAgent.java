package sharpie.grindsim.agents.triangulation;

import bot.ninjabrain.calculator.Throw;
import bot.ninjabrain.calculator.TriangulationResult;
import bot.ninjabrain.calculator.Triangulator;
import sharpie.grindsim.splits.stronghold.location.Stronghold;
import sharpie.grindsim.utils.Point;

import java.util.ArrayList;

public class NinjabrainTriangulationAgent {

    private Stronghold wrapSimSituation(Point basePoint, double angle, double sigma) {

        Triangulator triangulator = new Triangulator(0.002);

        angle = Math.toDegrees(angle);

        angle = -90.0+angle;

        Throw myThrow = new Throw(basePoint.x, basePoint.z, angle);

        ArrayList<Throw> throwsList = new ArrayList<Throw>();

        throwsList.add(myThrow);

        TriangulationResult result = triangulator.triangulate(throwsList);

        Stronghold strongholdResult = new Stronghold(result.x, result.z);

        return strongholdResult;
    }


    public Stronghold guessStronghold() {

        Point startPoint = new Point();

        Point theStronghold = Stronghold.getNearestStrongholdToCoords(startPoint);

        return ((Stronghold) theStronghold);
    }
}
