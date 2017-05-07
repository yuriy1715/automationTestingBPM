package pages;

import keyword.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Y.Borzak on 22.07.2016.
 */
public abstract class BasePage {

    public Screenshot screenshot;

    public WebDriverWait wait;

    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.screenshot = new Screenshot(driver);
        this.wait = new WebDriverWait(driver, 30);

    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
