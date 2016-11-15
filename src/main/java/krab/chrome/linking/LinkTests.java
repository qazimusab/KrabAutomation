package krab.chrome.linking;

import krab.chrome.ChromeKrabTest;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by qazimusab on 13/11/16.
 */
public class LinkTests extends ChromeKrabTest {

    @Before
    public void setup() {
        helper.login();
    }

    @Test
    public void testLinkingValidAccount() throws InterruptedException {
        helper.waitByXpathAndClick("/html/body/div[1]/div/div/div/div/a");
        helper.waitByXpathAndClick("/html/body/div[2]/div[2]/div[2]/a");
        helper.waitByIdAndType("user_login", "krabot");
        helper.waitByIdAndType("passwd_login", "abcd1234");
        helper.waitByXpathAndClick("//*[@id=\"login-form\"]/div[5]/button");
        helper.waitByXpathAndClick("/html/body/div[3]/div/div[2]/form/div/input[1]");
        helper.waitUntilVisibleByXpath("//*[@id=\"header\"]/div[2]/a[1]");
        assertTrue("Could not link Reddit account" ,helper.elementExistsByXpath("//*[@id=\"header\"]/div[2]/a[1]"));
        helper.waitByXpathAndClick("//*[@id=\"logoutForm\"]/ul/li[1]/a");
        helper.waitByXpathAndClick("/html/body/div[2]/div[2]/div[2]/a");
        Thread.sleep(3000);
        assertTrue("Could not unlink Reddit account", helper.getTextInElementByXpath("/html/body/div[2]/div[2]/div[2]/a").equals("Link"));
    }

}
