package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    //WebElements
    @FindBy(xpath = ".//*[@id='edit-name']")
    private WebElement userName;

    @FindBy(xpath = ".//*[@id='edit-pass']")
    private WebElement password;

    @FindBy(xpath = ".//*[@id='sign-block']/a[1]")
    private WebElement loginbtn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    //Methods
    public LoginPage login() {
        loginbtn.click();
        userName.sendKeys("test");
        password.sendKeys("test");
        screenshot.capturePageScreenshot("test.png");
        return new LoginPage(driver);
    }


}
