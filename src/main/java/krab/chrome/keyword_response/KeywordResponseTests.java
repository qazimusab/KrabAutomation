package krab.chrome.keyword_response;

import krab.chrome.ChromeKrabTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by qazimusab on 14/11/16.
 */
public class KeywordResponseTests extends ChromeKrabTest {


    @Override
    @Before
    public void setup() {
        super.setup();
        helper.login();
        helper.linkRedditAccount();
    }

    @Test
    public void createKeywordResponse() {
        try {
            String keyword = helper.getRandomString();
            String response = helper.getRandomString();
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/a[1]");
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[1]/div/input", keyword);
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[2]/div/input", response);
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/div/div[2]/div/button[1]");
            Thread.sleep(3000);
        }
        catch (Exception e) {
            e.printStackTrace();
            helper.unlinkRedditAccount();
        }
    }

    @Test
    public void createKeywordResponseWithShortKeyword() {
        try {
            String keyword = "Hi";
            String response = helper.getRandomString();
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/a[1]");
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[1]/div/input", keyword);
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[2]/div/input", response);
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/div/div[2]/div/button[1]");
            Thread.sleep(3000);
            assertTrue(helper.getTextInElementByXpath("//*[@id=\"header\"]/div[2]/div/div[2]/div/label").equals("Keyword must be 5 - 50 characters."));
        }
        catch (Exception e) {
            e.printStackTrace();
            helper.unlinkRedditAccount();
        }
    }

    @Test
    public void createKeywordResponseWithEmptyKeyword() {
        try {
            String keyword = "";
            String response = helper.getRandomString();
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/a[1]");
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[1]/div/input", keyword);
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[2]/div/input", response);
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/div/div[2]/div/button[1]");
            Thread.sleep(3000);
            assertTrue(helper.getTextInElementByXpath("//*[@id=\"header\"]/div[2]/div/div[2]/div/label").equals("Keyword must be 5 - 50 characters."));
        }
        catch (Exception e) {
            e.printStackTrace();
            helper.unlinkRedditAccount();
        }
    }

    @Test
    public void createKeywordResponseWithEmptyResponse() {
        try {
            String keyword = helper.getRandomString();
            String response = "";
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/a[1]");
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[1]/div/input", keyword);
            helper.waitByXpathAndType("//*[@id=\"header\"]/div[2]/div/div[1]/div[2]/div/input", response);
            helper.waitByXpathAndClick("//*[@id=\"header\"]/div[2]/div/div[2]/div/button[1]");
            Thread.sleep(3000);
            assertTrue(helper.getTextInElementByXpath("//*[@id=\"header\"]/div[2]/div/div[2]/div/label").equals("Response must be 1 - 1000 characters."));
        }
        catch (Exception e) {
            e.printStackTrace();
            helper.unlinkRedditAccount();
        }
    }

    @After
    public void teardown() {
        helper.unlinkRedditAccount();
    }
}
