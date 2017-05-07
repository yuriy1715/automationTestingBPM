package steps;

import com.google.gson.JsonObject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import keyword.Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import util.Browser;
import util.PropertyLoader;
import util.testrail.APIClient;
import util.testrail.APIException;
import webdriver.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;

/**
 * Created by Y.Borzak on 22.07.2016.
 */
public class TestBase extends TestListenerAdapter {

    public static WebDriver driver;
    protected String gridHubURl;
    protected String webSiteUrl;
    protected Browser browser;
    protected APIClient client;

    @Before
    public void init(){
         webSiteUrl = PropertyLoader.loadProperty("site.url");
//        gridHubURl = PropertyLoader.loadProperty("grid2.url");

        browser = new Browser();

        browser.setName(PropertyLoader.loadProperty("browser.name"));
    //    browser.setVersion(PropertyLoader.loadProperty("browser.version"));
    //    browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

        String username = PropertyLoader.loadProperty("user.name");
        String password = PropertyLoader.loadProperty("user.password");

        try {
            driver = WebDriverFactory.getInstance(gridHubURl, browser);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get(webSiteUrl);


        EventFiringWebDriver webdriver = new EventFiringWebDriver(driver);
		WebDriverEventListener errorListener = new AbstractWebDriverEventListener() {
			@Override
			public void onException(Throwable throwable, WebDriver webDriver) {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try {
                    FileUtils.copyFile(scrFile, new File("target/screenshot/" + new Date() + ".png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
// Screenshot screenshot = new Screenshot(driver);
//                screenshot.capturePageScreenshot("bug.png");
			}
		};
		webdriver.register(errorListener);
		driver = webdriver;

    }

    @After
    public void closeBrowser(){
        driver.close();
    }


    //Test_NG LISTENER

    public void onTestFailure(ITestResult testResult){
    System.out.println("--Failure--^^:))");
    setScreenshot(testResult);
    postTestResult(testResult);

}

    public void setScreenshot(ITestResult result){
        Screenshot screenshot = new Screenshot(driver);
        screenshot.capturePageScreenshot(result.getTestName() + new Date());
    }

    public void postTestResult(ITestResult result){
        Map data = new HashMap();
        data.put("status_id", new Integer(1)); //Failed Status
        data.put("comment", "This test worked fine");

        JsonObject r = null;

        try {
            r = (JsonObject) client.sendPost("add_result_for_case", data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (APIException e) {
            e.printStackTrace();
        }
        System.out.println(r.toString());
    }

}
