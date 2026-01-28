
package utils;

import com.microsoft.playwright.*;
import java.nio.file.Paths;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page initBrowser() {

        System.setProperty("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setExecutablePath(Paths.get("C:/Program Files/Google/Chrome/Application/chrome.exe"))
                        .setHeadless(false)
        );

        context = browser.newContext();

        page = context.newPage();

        return page;
    }

    public static void closeBrowser() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}
