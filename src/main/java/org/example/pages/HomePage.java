package org.example.pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.utils.Locators;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = Locators.HOME_ICON_XPATH)
    private MobileElement homeTitle;

    public HomePage(AppiumDriver<MobileElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isHomeTitleDisplayed(){
        return homeTitle.isDisplayed();
    }
}
