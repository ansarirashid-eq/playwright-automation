package steps;

import io.cucumber.java.en.*;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    private Page page;
    private LoginPage loginPage;

    public LoginSteps() {
        this.page = Hooks.page;
    }

    @Given("i am on login page")
    public void iAmOnLoginPage() {
        loginPage = new LoginPage(page);
        loginPage.navigateToLogin();
    }

    @When("i enter valid username and valid password")
    public void iEnterValidUsernameAndValidPassword() {
        String user = ConfigReader.get("validUsername");
        String pass = ConfigReader.get("validPassword");
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @And("i click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLogin();
    }

    @Then("i should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {

        page.waitForSelector("//h6[normalize-space()='Dashboard']");

        boolean textVisible = page.locator("//h6[normalize-space()='Dashboard']").isVisible();

        Assert.assertTrue(
                textVisible,
                "Login failed — Dashboard not visible. Current URL: " + page.url()
        );
    }

    @When("i enter invalid user name or invalid password")
    public void iEnterInvalidUserNameOrInvalidPassword() {
        String user = ConfigReader.get("validUsername");
        String pass = ConfigReader.get("invalidPassword");
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
    }

    @Then("i should see the error message")
    public void iShouldSeeTheErrorMessage() {
        page.waitForSelector("//p[normalize-space()='Invalid credentials']");

        boolean textVisible = page.locator("//p[normalize-space()='Invalid credentials']").isVisible();

        Assert.assertTrue(
                textVisible,
                "Login failed — Dashboard visible. Current URL: " + page.url()
        );
    }


    @When("i click login button without entering username and password")
    public void iClickLoginButtonWithoutEnteringUsernameAndPassword() {
        loginPage.clickLogin();
    }


    @Then("i should see the required error message")
    public void iShouldSeeTheRequiredErrorMessage() {
        page.waitForSelector("(//span[text()='Required'])[1]");
        page.waitForSelector("(//span[text()='Required'])[2]");


        boolean textVisible1 = page.locator("(//span[text()='Required'])[1]").isVisible();
        boolean textVisible2 = page.locator("(//span[text()='Required'])[1]").isVisible();

        Assert.assertTrue(
                (textVisible1 && textVisible2),
                "Failed" + page.url()
        );
    }
}
