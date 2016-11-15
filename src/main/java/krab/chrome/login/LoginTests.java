package krab.chrome.login;

import krab.chrome.ChromeKrabTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by qazimusab on 08/09/16.
 */
public class LoginTests extends ChromeKrabTest {

    @Test
    public void successfulLoginTest() {
        helper.waitByIdAndType("LoginViewModel_Email", "ba5bdb47-3b83-45ee-8f43-9a7cf09df204@gmail.com");
        helper.waitByIdAndType("LoginViewModel_Password", "393cb598-a78f-41b5-b6dd-49650c5f291d");
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        assertTrue(helper.elementExistsByXpath("/html/body/div[1]/div/div/div/div/a"));
    }

    @Test
    public void incorrectPasswordTest() throws InterruptedException {
        helper.waitByIdAndType("LoginViewModel_Email", "ba5bdb47-3b83-45ee-8f43-9a7cf09df204@gmail.com");
        helper.waitByIdAndType("LoginViewModel_Password", helper.getRandomString());
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        Thread.sleep(3000);
        assertTrue(helper.getTextInElementByXpath("//*[@id=\"loginForm\"]/form/div[1]/ul/li").equals("Invalid login attempt."));
    }

    @Test
    public void incorrectEmailTest() throws InterruptedException {
        helper.waitByIdAndType("LoginViewModel_Email", helper.getRandomEmailAddress());
        helper.waitByIdAndType("LoginViewModel_Password", "393cb598-a78f-41b5-b6dd-49650c5f291d");
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        Thread.sleep(3000);
        assertTrue(helper.getTextInElementByXpath("//*[@id=\"loginForm\"]/form/div[1]/ul/li").equals("Invalid login attempt."));
    }

    @Test
    public void noEmailTest() throws InterruptedException {
        helper.waitByIdAndType("LoginViewModel_Password", "393cb598-a78f-41b5-b6dd-49650c5f291d");
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        Thread.sleep(3000);
        assertTrue(helper.getTextInElementByXpath("//*[@id=\"loginForm\"]/form/div[2]/div/span").equals("The Email field is required."));
    }

    @Test
    public void noPasswordTest() throws InterruptedException {
        helper.waitByIdAndType("LoginViewModel_Email", "ba5bdb47-3b83-45ee-8f43-9a7cf09df204@gmail.com");
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[4]/div/button");
        Thread.sleep(3000);
        assertTrue(helper.getTextInElementByXpath("//*[@id=\"loginForm\"]/form/div[3]/div/span").equals("The Password field is required."));
    }

}
