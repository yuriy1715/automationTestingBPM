package keyword;
import org.openqa.selenium.WebDriver;


/**
 * Created by Y.Borzak on 22.07.2016.
 */
public abstract class Keyword {

    protected WebDriver driver;

    public Keyword(WebDriver driver) {
        this.driver = driver;
    }

}
