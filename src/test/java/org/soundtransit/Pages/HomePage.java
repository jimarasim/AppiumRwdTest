package org.soundtransit.Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

public class HomePage extends BasePage {
    @FindBy(id="formsText1_mainMenu")
    WebElement searchTextBox;

    @FindBy(xpath="//button[@class='global-search--submit-btn']")
    WebElement searchButton;

    @FindBy(id = "menu_expand")
    WebElement homeButton;

    @FindBy(id = "arrivalsAddress1")
    WebElement realTimeArrivalsTextBox;

    @FindBy(css = "button[data-role=real-time-arrivals]")
    WebElement realTimeArrivalsButton;

    @FindBy(id="subscribe-target")
    WebElement subscribeTextBox;

    @FindBy(css=".footer__service-alerts-submit button")
    WebElement subscribeButton;

    @FindBy(id="service-alerts-subscription-form")
    WebElement subscribeForm;


    public final String url = "https://www.soundtransit.org";

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(url);
    }

    public void clickHomeButton() {
        homeButton.click();

        ((new WebDriverWait(driver,10))).until(ExpectedConditions.visibilityOf(searchTextBox));
    }

    public SearchPage enterSearchTerm(String searchTerm) {
        searchTextBox.sendKeys(searchTerm);
        searchButton.click();

        SearchPage srp = new SearchPage(driver);
        srp.waitForPage();

        return srp;
    }

    public void enterRealTimeArrivalsAddress(String address){
        realTimeArrivalsTextBox.sendKeys(address);
    }

    public void selectRealTimeDropdownEntry(String address) {
        String optionXpath = "//div[@class='option_name' and contains(text(),'"+address+"')]";
        (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath(optionXpath)));
        WebElement option = driver.findElement(By.xpath(optionXpath));
        option.click();
    }

    public RealTimeArrivalsPage clickRealTimeArrivalsButton() {
        RealTimeArrivalsPage strtap = new RealTimeArrivalsPage(driver);

        realTimeArrivalsButton.click();

        strtap.waitForPage();

        return strtap;
    }

    public void enterSubscribeText(String text) {
        subscribeTextBox.sendKeys(text);
    }

    public void clickSubscribeButton() {
        subscribeButton.click();
    }


}
