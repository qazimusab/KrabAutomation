package krab.chrome;

import krab.base.KrabTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by qazimusab on 08/09/16.
 */
public class ChromeKrabTest extends KrabTest {

    @Override
    protected String getUrlToOpen() {
        return "https://krab.azurewebsites.net";
    }

    @Override
    protected String getDriverSystemProperty() {
        return "webdriver.chrome.driver";
    }

    @Override
    protected String getDriverExecutableLocation() {
        return "src/main/resources/chromedriver";
    }

    @Override
    protected WebDriver getWebDriver() {
        return new ChromeDriver();
    }


}
