package sharpie.grindsim.routes.testroutes;

import sharpie.grindsim.routes.MaximumTimeRoute;
import sharpie.grindsim.splits.Split;
import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.custom.JsonTimeListSplit;
import sharpie.grindsim.utils.TimeUnit;

public class TestCustomJsonMaximumTimeRoute extends MaximumTimeRoute {

    public TestCustomJsonMaximumTimeRoute() {

        super(new SplitLength(12.0, TimeUnit.MINUTES));

        addSplit(new JsonTimeListSplit("sample_split"));
    }

    public String toString() {

        String result = "TestCustomJsonMaximumTimeRoute";

        result += "\n\t";

        result += "Maximum Time = " + maxTime;

        result += "\n\t";

        result += "Splits:";

        for (Split split : splits) {

            result += "\n\t\t";

            result += ((JsonTimeListSplit)split).name;
        }

        return result;
    }
}
