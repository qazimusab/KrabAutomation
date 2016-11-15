package krab.base;

import krab.abstraction.Helper;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by qazimusab on 07/09/16.
 */

public abstract class KrabTest {

    protected WebDriver driver;
    protected Helper helper;

    @Before
    public void setup() {
        File file = new File(getDriverExecutableLocation());
        System.setProperty(getDriverSystemProperty(), file.getAbsolutePath());
        driver = getWebDriver();
        helper = new Helper(driver);
        driver.get(getUrlToOpen());
    }

    protected abstract String getUrlToOpen();

    protected abstract String getDriverSystemProperty();

    protected abstract String getDriverExecutableLocation();

    protected abstract WebDriver getWebDriver();

    @After
    public void tearDown() {
        driver.close();
    }

}
