package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator logInButton;

    public LoginPage(Page page) {
        this.page = page;

        this.usernameInput = page.locator("xpath=//input[@name='username']");
        this.passwordInput = page.locator("xpath=//input[@name='password']");
        this.logInButton = page.locator("xpath=//button[@type='submit']");
    }

    public void navigateToLogin() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void enterUsername(String username) {
        usernameInput.fill(username);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void clickLogin() {
        logInButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}