package sharpie.grindsim.splits.custom;

import sharpie.grindsim.splits.SplitLength;
import sharpie.grindsim.splits.TimeListSplit;

import javax.json.JsonObject;
import java.util.List;

public class JsonTimeListSplit extends TimeListSplit {

    public String name;

    public JsonTimeListSplit(String fileName) {

        this(JsonSplitUtils.loadJsonObjectFromFile(fileName));

        this.name = fileName;
    }

    public JsonTimeListSplit(JsonObject jsonObject) {

        this(JsonSplitUtils.getChanceToSucceedFromJsonObject(jsonObject), JsonSplitUtils.getSplitLengthListFromJsonObject(jsonObject));
    }

    public JsonTimeListSplit(double chanceToSucceed, List<SplitLength> splitLengthPossibilities) {

        super(chanceToSucceed, splitLengthPossibilities);
    }
}
