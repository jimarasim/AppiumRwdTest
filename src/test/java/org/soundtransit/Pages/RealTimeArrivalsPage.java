package org.soundtransit.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

public class RealTimeArrivalsPage extends BasePage {
    @FindBy(id = "arrivalsAddress1")
    WebElement realTimeArrivalsTextBox;

    @FindBy(css="#rta_search_results h4")
    WebElement realTimeSearchResults;

    public RealTimeArrivalsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        ((new WebDriverWait(driver,10))).until(ExpectedConditions.urlContains("real-time"));
    }

    public void waitForRealTimeArrivalsResult() {
        ((new WebDriverWait(driver, 10))).until(ExpectedConditions.elementToBeClickable(realTimeSearchResults));
    }

    public String getRealTimeArrivalsSearchResultsText() {
        return realTimeSearchResults.getText();
    }
}
