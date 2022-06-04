package sharpie.grindsim.routes.testroutes;

import sharpie.grindsim.routes.Route;
import sharpie.grindsim.splits.custom.JsonTimeListSplit;

public class TestCustomJsonRoute extends Route {

    public TestCustomJsonRoute() {

        addSplit(new JsonTimeListSplit("sample_split"));
    }
}
