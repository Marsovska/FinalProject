package utils;

import io.restassured.RestAssured;

public class APIConstants {


    public static final String BaseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    public static final String CREATE_USER_URI = BaseURI + "/createUser.php";


    public static final String HEADER_CONTENT_TYPE_KEY = "Content-Type";
    public static final String HEADER_CONTENT_TYPE_VALUE = "application/json";

}
