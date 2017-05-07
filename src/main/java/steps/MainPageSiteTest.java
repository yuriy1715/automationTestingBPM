package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPageSite;

/**
 * Created by Kie on 02.09.2016.
 */
public class MainPageSiteTest {
    WebDriver driver = TestBase.driver;

    MainPageSite mainPageSite;

    public void init(){mainPageSite = PageFactory.initElements(driver,MainPageSite.class);}

    @When("^открыть поле поиска ввести значение и удалить$")
    public void openFieldSearch(){
        init();
        mainPageSite.checkLookupField();
    }
    @And("^проверить наличие баннера, нажать на него$")
    public void clickBanner(){
        init();
        mainPageSite.checkBanner();
    }

    @And("^нажать чекбоксы на баннере$")
    public void clickAllcheakBox(){
        init();
        mainPageSite.checkBoxinBanner();
    }

}
