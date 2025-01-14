package org.example.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.example.utils.Locators.*;

public class LoginPage {
    private AppiumDriver<MobileElement> driver;
    @FindBy(xpath = USERNAME_XPATH)
    private MobileElement usernameField;
    @FindBy(xpath = PASSWORD_XPATH)
    private MobileElement passwordField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private MobileElement loginButton;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
