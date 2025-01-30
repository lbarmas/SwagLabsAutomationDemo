package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomeProductPage;
import org.example.pages.LoginPage;
import org.example.utils.DriverSetup;
import org.junit.Assert;

public class LoginSteps extends DriverSetup {
    private LoginPage loginPage;
    private HomeProductPage homeProductPage;


    @Given("the user open the SwagLabs app")
    public void theUserIsOnTheLoginPage() throws Exception {
        setup();
        loginPage = new LoginPage(driver);
    }

    @When("the user enter a valid username {string} and password {string}")
    public void enterValidUserNameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("the user click on the login button with username {string} and password {string}")
    public void clickOnTheLoginButton(String username, String password) {
        loginPage.clickLoginButton(username, password);
        homeProductPage = new HomeProductPage(driver);
    }

    @Then("the app navigates to the home screen")
    public void appNavigatesToTheHomeScreen() {
        Assert.assertTrue(homeProductPage.isHomeTitleDisplayed());
        tearDown();
    }
}
