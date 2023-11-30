package utils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
public class JsonReader {

    public static Object[][] getJSONScript(String strJSONPath, String strJSONData, int intNumOfAttributes) throws IOException, ParseException {
        /* Read the entire JSON file and assign its entire content to an object*/
        Object object = new JSONParser().parse(new FileReader(strJSONPath));
        JSONObject jsonObject = (JSONObject) object;
        JSONArray jsonArray = (JSONArray) jsonObject.get(strJSONData);
        Object[][] arrObjects = new String[jsonArray.size()][intNumOfAttributes];
        /* Loop through all the key-value pair arrays */
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            /* Get all the key attribute names  */
            Set<String> keySet = obj.keySet();
            String strSplit = keySet.toString().replace("[","").replace("]","");
            String[] arrSplit = strSplit.split(",");
            /* Fill the array objects with the corresponding key-value pairs */
            for (int j = 0; j < arrSplit.length; j++) {
                arrObjects[i][(arrSplit.length-1) - j] = String.valueOf(obj.get(arrSplit[j].trim()));
            }
        }
        return arrObjects;
    }
}
