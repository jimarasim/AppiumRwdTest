package org.soundtransit.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

public class RoutesAndSchedulesPage extends BasePage {

    @FindBy(id="route_schedule_search_results")
    WebElement results;

    public RoutesAndSchedulesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        ((new WebDriverWait(driver,10))).until(ExpectedConditions.visibilityOf(results));
    }

    public String getResultsText() {
        return results.getText();
    }

}
