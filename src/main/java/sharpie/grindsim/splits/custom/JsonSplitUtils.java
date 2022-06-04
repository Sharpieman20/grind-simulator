package sharpie.grindsim.splits.custom;


import sharpie.grindsim.splits.SplitLength;

import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static sharpie.grindsim.splits.SplitUtils.getSplitLengthFromTimeString;

public interface JsonSplitUtils {

    private static JsonParser getParserForFile(String fileName) {

        System.out.println(System.getProperty("user.dir"));

        try {
            return Json.createParser(new FileInputStream("resources/"+fileName+".json"));
        } catch (IOException ioException) {

        }
        return null;
    }

    public static JsonObject loadJsonObjectFromFile(String fileName) {

        JsonParser parser = getParserForFile(fileName);

        parser.next();

        return parser.getObject();
    }

    public static double getChanceToSucceedFromJsonObject(JsonObject jsonObject) {

        JsonNumber val = jsonObject.getJsonNumber("conversion_rate");

        return val.doubleValue();
    }

    public static List<SplitLength> getSplitLengthListFromJsonObject(JsonObject jsonObject) {

        List<SplitLength> listOfSplitLengths = new ArrayList<>();

        for (JsonValue value : jsonObject.getJsonArray("distribution")) {

            String valueString = value.toString();

            String stringValue = valueString.substring(1, valueString.length()-1);

            listOfSplitLengths.add(getSplitLengthFromTimeString(stringValue));
        }

        return listOfSplitLengths;
    }
}
