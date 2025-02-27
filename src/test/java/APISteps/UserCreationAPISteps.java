package APISteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayloadConstants;
import utils.ConfigReader;


public class UserCreationAPISteps {
    private RequestSpecification prepRequest;
    private Response response;

    @Given("Request is prepared using dynamic payload")
    public void request_is_prepared_using_dynamic_payload() {
        prepRequest = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,
                        APIConstants.HEADER_CONTENT_TYPE_VALUE).
                body(APIPayloadConstants.CREATE_USER_PAYLOAD_JSON_DYNAMIC
                        (ConfigReader.READ("nameAPI"),
                                ConfigReader.READ("email"),
                                ConfigReader.READ("passwordAPI")));
    }

    @When("Post call is send for user creation")
    public void post_call_is_send_for_user_creation() {
        response = prepRequest.when().post(APIConstants.CREATE_USER_URI);
    }

    @Then("the status code received is {int}")
    public void the_status_code_received_is(Integer expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response {string} is {string}")
    public void the_response_is(String key, String expectedValue) {
        response.then().assertThat().body(key, equalTo(expectedValue));
    }

    @Given("Request is prepared with invalid email using dynamic payload")
    public void request_is_prepared_with_invalid_email_using_dynamic_payload() {
        prepRequest = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants.CREATE_USER_PAYLOAD_JSON_DYNAMIC
                        (ConfigReader.READ("nameAPI"),
                                "donnasimon.gmail.com",
                                ConfigReader.READ("passwordAPI")));
    }

    @Given("Request is prepared without password using dynamic payload")
    public void request_is_prepared_without_password_using_dynamic_payload() {
        prepRequest = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants.CREATE_USER_PAYLOAD_JSON_DYNAMIC
                        (ConfigReader.READ("nameAPI"),
                                ConfigReader.READ("email")
                                , ""));

    }

    @Given("Request is prepared without name using dynamic payload")
    public void request_is_prepared_without_name_using_dynamic_payload() {
        prepRequest = given()
                .header(APIConstants.HEADER_CONTENT_TYPE_KEY, APIConstants.HEADER_CONTENT_TYPE_VALUE)
                .body(APIPayloadConstants.CREATE_USER_PAYLOAD_JSON_DYNAMIC
                        (""
                                , ConfigReader.READ("email"),
                                ConfigReader.READ("passwordAPI")));

    }

}
