package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeProductPage {
    private final AppiumDriver<MobileElement> driver;
    private static final String HOME_ICON_XPATH = "//android.widget.ImageView[@content-desc='home']";
    private static final String CART_BADGE_XPATH = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView";
    private static final String PRODUCT_XPATH = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]/android.widget.TextView";
    @FindBy(xpath = HOME_ICON_XPATH)
    private MobileElement homeTitle;

    public HomeProductPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isHomeTitleDisplayed() {
        return homeTitle.isDisplayed();
    }

    public void selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HOME_ICON_XPATH)));
        MobileElement productElement = driver.findElement(By.xpath(PRODUCT_XPATH));
        productElement.click();
    }
    public boolean isProductAddedToCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_BADGE_XPATH)));

            MobileElement cartBadge = driver.findElement(By.xpath(CART_BADGE_XPATH));

            String badgeText = cartBadge.getText();
            int itemCount = Integer.parseInt(badgeText);
            return itemCount > 0;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }
}
