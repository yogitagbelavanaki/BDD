import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	

	public static String readDataFromJson(String jsonKey) throws FileNotFoundException, IOException, ParseException {
		FileReader reader=new FileReader(".\\src\\main\\resources\\AppData.json");
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(reader);
		JSONObject jsonData = (JSONObject)obj;
		String name = jsonData.get(jsonKey).toString();
		return name;
	}

}
