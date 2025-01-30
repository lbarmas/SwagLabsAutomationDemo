package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomeProductPage;
import org.example.pages.LoginPage;
import org.example.utils.DriverSetup;
import org.testng.Assert;

public class AddProductSteps extends DriverSetup {
    private HomeProductPage homeProductPage;
    @Given("the user is logged into the SwagLabs app")
    public void theUserIsLoggedIntoTheSwagLabsApp(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton("standard_user", "secret_sauce");
        homeProductPage = new HomeProductPage(driver);
    }

    @When("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        homeProductPage.selectProduct();
    }

    @Then("the product is added to the cart successfully")
    public void theProductIsAddedToTheCartSuccessfully() {
        Assert.assertTrue(homeProductPage.isProductAddedToCart());
    }
}
