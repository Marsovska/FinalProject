package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    //this is for precondition of the project
   // @Before
   // public void start(){
     //   driver = new ChromeDriver();
       // driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //}


    //What is above was initial @before method to run before every scenario common for all user stories
    // and it was now replaced with a method developed in Common Methods
    @Before
    public void begin() {
        OPEN_BROWSER();
    }


    @After
    public void finish(Scenario scenario) {
        byte[] pic;
        if (scenario.isFailed()) {
            pic = TAKE_SCREENSHOT("failed/" + scenario.getName());
        } else {
            pic = TAKE_SCREENSHOT("passed/" + scenario.getName());
        }
        scenario.attach(pic, "image.png", scenario.getName());

        SHUT_DOWN_BROWSER();
    }
}
