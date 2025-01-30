package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final AppiumDriver<MobileElement> driver;
    public static final String USERNAME_XPATH = "//android.widget.EditText[@content-desc=\"test-Username\"]";
    public static final String PASSWORD_XPATH = "//android.widget.EditText[@content-desc=\"test-Password\"]";
    public static final String LOGIN_BUTTON_XPATH = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]";
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
