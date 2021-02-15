package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonDataReader {

	public String firstName,lastName,email,password;
	public void jsonReader() 
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
		File srcFile=new File(filePath);
		JSONParser parser=new JSONParser();
		JSONArray jarray;
		try {
			jarray = (JSONArray)parser.parse(new FileReader(srcFile));
			for(Object hsonObj:jarray)
			{
				JSONObject person=(JSONObject)hsonObj;
				firstName=(String) person.get("firstname");
				System.out.println(firstName);
				lastName=(String)person.get("lastname");
				System.out.println(lastName);
				email=(String)person.get("email");
				password=(String)person.get("password");
				
			}	
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
