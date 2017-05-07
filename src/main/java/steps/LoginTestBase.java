package steps;


import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

/**
 * Created by Y.Borzak on 22.07.2016.
 */
public class LoginTestBase {

    WebDriver driver = TestBase.driver;

    LoginPage loginPage;

    public void init (){loginPage = PageFactory.initElements(driver, LoginPage.class);};


    @When("^22")
    public void loginTest() {
        init();
        loginPage.login();
    }

}
