package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.microsoft.playwright.Page;
import utils.PlaywrightFactory;

public class Hooks {
    public static Page page;

    @Before
    public void setUp() {
        page = PlaywrightFactory.initBrowser();
    }

    @After
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}