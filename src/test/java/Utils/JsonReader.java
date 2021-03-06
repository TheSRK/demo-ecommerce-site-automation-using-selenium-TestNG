package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    WebDriver driver;
    String email;
    String password;

    public JsonReader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //read JSONfile [not array]
    public void readJSONFile() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        JSONObject jsonObject = (JSONObject) obj;

        setEmail ((String) jsonObject.get("email")); ;
        setPassword ((String) jsonObject.get("password"));
    }

    //read JSONArray file
    public void readJSONArray(int pos) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/test/resources/users.json"));
        Object obj = jsonArray.get(pos);
        JSONObject jsonObject = (JSONObject) obj;

        setEmail((String) jsonObject.get("email"));
        setPassword((String) jsonObject.get("password"));
    }




}
