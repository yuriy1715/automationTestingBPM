package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kie on 02.09.2016.
 */
public class MainPageSite extends BasePage {
    //WebElements
    @FindBy(xpath = ".//*[@id='edit-submit-1']")
    private WebElement lookupButton;

    @FindBy(xpath = ".//*[@id='edit-keys-1']")
    private WebElement fieldLookup;

    @FindBy(xpath = ".//*[@id='search-close']")
    private WebElement searchClose;

    @FindBy(xpath = ".//*[@id='academy-banner-inner']/a[3]/img")
    private WebElement banner;

    @FindBy(xpath = ".//*[@id='bullet-banner-sales']/img")
    private WebElement boxSales;

    @FindBy(xpath = ".//*[@id='bullet-banner-marketing']/img")
    private WebElement boxMarketing;

    @FindBy(xpath = ".//*[@id='bullet-banner-service']/img")
    private WebElement boxServise;

    @FindBy(xpath = ".//*[@id='bullet-banner-gartner']/img")
    private WebElement otherBox;

    public MainPageSite(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    //Methods
    public void checkLookupField() {
        otherBox.
        lookupButton.click();
        fieldLookup.sendKeys("testtesttest____test___test");
        screenshot.capturePageScreenshot("text.png");
        searchClose.click();
    }

    public void checkBanner(){
        screenshot.capturePageScreenshot("displayBanner.png");
        banner.click();
        screenshot.capturePageScreenshot("afterClick.png");
    }

    public void checkBoxinBanner(){
        boxSales.click();
        boxMarketing.click();
        boxServise.click();
        otherBox.click();
    }
}

