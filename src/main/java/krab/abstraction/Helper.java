package krab.abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Created by qazimusab on 08/09/16.
 */
@SuppressWarnings("unused")
public class Helper {

    private WebDriver driver;
    private static int DEFAULT_WAIT_TIME = 15;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickById(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void waitById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void waitByIdAndClick(String id) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
    }

    public void typeById(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void typeByName(String name, String text) {
        driver.findElement(By.name(name)).sendKeys(text);
    }

    public void typeByClassName(String className, String text) {
        driver.findElement(By.className(className)).sendKeys(text);
    }

    public void waitByIdAndType(String id, String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(text);
    }

    public void waitById(String id, int maxTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void clickByName(String name) {
        driver.findElement(By.name(name)).click();
    }

    public void waitByName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    public void waitByNameAndClick(String name) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name))).click();
    }

    public void waitByNameAndType(String name, String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name))).sendKeys(text);
    }

    public void waitByName(String name, int maxTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    public void clickByClassName(String className) {
        driver.findElement(By.className(className)).click();
    }

    public void waitByClassName(String className) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void waitByClassNameAndClick(String className) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className))).click();
    }

    public void waitByClassName(String className, int maxTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
    }

    public void clickByLinkText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void waitByLinkText(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
    }

    public void waitByLinkTextAndClick(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText))).click();
    }

    public void waitByLinkText(String linkText, int maxTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
    }

    public void clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void waitByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitByXpathAndClick(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }

    public void waitByXpathAndType(String xpath, String text) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(text);
    }

    public void waitByXpath(String xpath, int maxTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, maxTimeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public boolean elementExistsByXpath(String xpath) {
        return (driver.findElements( By.xpath(xpath) ).size() != 0);
    }

    public boolean elementExistsByName(String name) {
        return (driver.findElements( By.name(name) ).size() != 0);
    }

    public boolean elementExistsByCss(String css) {
        return (driver.findElements( By.cssSelector(css) ).size() != 0);
    }

    public void waitUntilClickableByXpathAndClick(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public void waitByCssSelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }

    public void waitUntilClickableByLinkTextAndClick(String linkText) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
    }

    public String getTextInElementByXpath(String xpath) {
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement.getText();
    }

    public void waitUntilVisibleByXpath(String xpath) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
    }

    public void login() {
        waitByIdAndType("LoginViewModel_Email", "ba5bdb47-3b83-45ee-8f43-9a7cf09df204@gmail.com");
        waitByIdAndType("LoginViewModel_Password", "393cb598-a78f-41b5-b6dd-49650c5f291d");
        waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        waitUntilVisibleByXpath("/html/body/div[1]/div/div/div/div/a");
    }

    public void login(String username, String password) {
        waitByIdAndType("LoginViewModel_Email", username);
        waitByIdAndType("LoginViewModel_Password", password);
        waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        waitUntilVisibleByXpath("/html/body/div[1]/div/div/div/div/a");
    }

    public void linkRedditAccount() {
        waitByXpathAndClick("/html/body/div[1]/div/div/div/div/a");
        waitByXpathAndClick("/html/body/div[2]/div[2]/div[2]/a");
        waitByIdAndType("user_login", "krabot");
        waitByIdAndType("passwd_login", "abcd1234");
        waitByXpathAndClick("//*[@id=\"login-form\"]/div[5]/button");
        waitByXpathAndClick("/html/body/div[3]/div/div[2]/form/div/input[1]");
        waitUntilVisibleByXpath("//*[@id=\"header\"]/div[2]/a[1]");
        assertTrue("Could not link Reddit account" ,elementExistsByXpath("//*[@id=\"header\"]/div[2]/a[1]"));
    }

    public void linkRedditAccount(String username, String password) {
        waitByXpathAndClick("/html/body/div[1]/div/div/div/div/a");
        waitByXpathAndClick("/html/body/div[2]/div[2]/div[2]/a");
        waitByIdAndType("user_login", username);
        waitByIdAndType("passwd_login", password);
        waitByXpathAndClick("//*[@id=\"login-form\"]/div[5]/button");
        waitByXpathAndClick("/html/body/div[3]/div/div[2]/form/div/input[1]");
        waitUntilVisibleByXpath("//*[@id=\"header\"]/div[2]/a[1]");
        assertTrue("Could not link Reddit account" ,elementExistsByXpath("//*[@id=\"header\"]/div[2]/a[1]"));
    }

    public void unlinkRedditAccount() {
        waitByXpathAndClick("//*[@id=\"logoutForm\"]/ul/li[1]/a");
        waitByXpathAndClick("/html/body/div[2]/div[2]/div[2]/a");
    }

    public String getRandomEmailAddress() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString() + "@gmail.com";
    }

    public String getRandomString() {
        return UUID.randomUUID().toString();
    }

    public int getNumberOfChildElementsByXpath(String xpath) {
        WebElement rootWebElement = driver.findElement(By.xpath(xpath));
        List<WebElement> children = rootWebElement.findElements(By.xpath(".//*"));
        return children.size();
    }

    public int getNumberOfChildElementsByClassName(String className) {
        WebElement rootWebElement = driver.findElement(By.className(className));
        List<WebElement> children = rootWebElement.findElements(By.xpath(".//*"));
        return children.size();
    }
}
