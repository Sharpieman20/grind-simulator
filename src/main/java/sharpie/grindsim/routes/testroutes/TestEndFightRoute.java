package sharpie.grindsim.routes.testroutes;

import sharpie.grindsim.routes.Route;
import sharpie.grindsim.splits.end.End;

public class TestEndFightRoute extends Route {

    public TestEndFightRoute() {

        addSplit(new End());
    }
}