package APISteps;

import utils.ConfigReader;
import utils.Constants;

public class ththt {
    public static void main(String[] args) {
        String name= ConfigReader.read("nameAPI",Constants.CONFIG_FILE_PATH);
        String email= ConfigReader.read("email",Constants.CONFIG_FILE_PATH);
        String pass= ConfigReader.read("passwordAPI",Constants.CONFIG_FILE_PATH);
        String requestBody="{\"name\":\""+name+"\"," + " " +"\"email\":\""+email+"\"+" + "\"password\":\""+pass+"\"}";
        System.out.println(requestBody);
    }
}
