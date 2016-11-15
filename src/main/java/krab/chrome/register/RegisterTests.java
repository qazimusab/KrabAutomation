package krab.chrome.register;

import krab.chrome.ChromeKrabTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by qazimusab on 13/11/16.
 */
public class RegisterTests extends ChromeKrabTest {

    @Test
    public void registerTest() throws InterruptedException {
        String email = helper.getRandomEmailAddress();
        String password = helper.getRandomString();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[5]/a");
        helper.waitByIdAndType("Email", email);
        helper.waitByIdAndType("Password", password);
        helper.waitByIdAndType("ConfirmPassword", password);
        helper.clickByXpath("//*[@id=\"Register\"]/form/div[5]/div/button");
        helper.waitByXpath("/html/body/div[1]/div[1]/h3");
        assertTrue(helper.elementExistsByXpath("/html/body/div[1]/div[1]/h3"));
    }

    @Test
    public void registerWithInvalidEmailTest() throws InterruptedException {
        String email = helper.getRandomString();
        String password = helper.getRandomString();
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[5]/a");
        helper.waitByIdAndType("Email", email);
        helper.waitByIdAndType("Password", password);
        helper.waitByIdAndType("ConfirmPassword", password);
        helper.clickByXpath("//*[@id=\"Register\"]/form/div[5]/div/button");
        helper.waitByXpath("//*[@id=\"Register\"]/form/div[1]/ul/li");
        assertTrue(helper.getTextInElementByXpath("//*[@id=\"Register\"]/form/div[1]/ul/li").equals("The Email field is not a valid e-mail address."));
    }

    @Test
    public void registerWithNoEmailTest() throws InterruptedException {
        String password = helper.getRandomString();
        System.out.println("Password: " + password);
        helper.waitByXpathAndClick("//*[@id=\"loginForm\"]/form/div[5]/a");
        helper.waitByIdAndType("Password", password);
        helper.waitByIdAndType("ConfirmPassword", password);
        helper.clickByXpath("//*[@id=\"Register\"]/form/div[5]/div/button");
        helper.waitByXpath("//*[@id=\"Register\"]/form/div[1]/ul/li");
        assertTrue(helper.getTextInElementByXpath("//*[@id=\"Register\"]/form/div[1]/ul/li").equals("The Email field is required."));
    }

}
