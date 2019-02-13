package org.soundtransit.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @FindBy(id="arrivalsRiderTab2")
    WebElement tripPlanningTab;

    @FindBy(id="tripDepart1")
    WebElement tripPlanningDepartTextBox;

    @FindBy(id="tripGoing1")
    WebElement tripPlanningGoingTextBox;

    @FindBy(xpath="//button[@data-role='trip-planning']")
    WebElement tripPlanningPlanYourTripButton;

    public final String url = "https://www.soundtransit.org";

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public void navigate() {
        driver.get(url);
    }

    //MENU
    public void clickHomeButton() {
        homeButton.click();

        ((new WebDriverWait(driver,10))).until(ExpectedConditions.visibilityOf(searchTextBox));
    }

    //GLOBAL SEARCH
    public SearchPage enterSearchTerm(String searchTerm) {
        searchTextBox.sendKeys(searchTerm);
        searchButton.click();

        SearchPage srp = new SearchPage(driver);
        srp.waitForPage();

        return srp;
    }

    //REAL TIME ARRIVALS
    public void enterRealTimeArrivalsAddress(String address){
        realTimeArrivalsTextBox.sendKeys(address);
    }

    public RealTimeArrivalsPage clickRealTimeArrivalsButton() {
        RealTimeArrivalsPage strtap = new RealTimeArrivalsPage(driver);

        realTimeArrivalsButton.click();

        strtap.waitForPage();

        return strtap;
    }

    //TRIP PLANNING
    public void selectTripPlanningTab() {
        tripPlanningTab.click();
        ((new WebDriverWait(driver,10))).until(ExpectedConditions.visibilityOf(tripPlanningDepartTextBox));
    }

    public void enterTripPlannerDepartAddress(String address) {
        tripPlanningDepartTextBox.sendKeys(address);
    }

    public void enterTripPlannerGoingAddress(String address) {
        tripPlanningGoingTextBox.sendKeys(address);
    }

    public TripPlanningPage clickPlanYourTripButton() {
        TripPlanningPage tripPlanningPage = new TripPlanningPage(driver);

        ((new WebDriverWait(driver,10))).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.form__typeaheadOption")));

        tripPlanningPlanYourTripButton.click();

        tripPlanningPage.waitForPage();

        return tripPlanningPage;
    }

    //SUBSCRIBE
    public void enterSubscribeText(String text) {
        subscribeTextBox.sendKeys(text);
    }

    public void clickSubscribeButton() {
        subscribeButton.click();
    }

}
