package org.soundtransit.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

public class TripPlanningPage extends BasePage {

    @FindBy(id="trip_planner_search_results")
    WebElement tripPlannerSearchResults;

    @FindBy(id="tripOverlaysRiderPanel1_trip_steps")
    WebElement tripPlannerSteps;

    public TripPlanningPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        ((new WebDriverWait(driver,10))).until(ExpectedConditions.urlContains("tripplanner"));
    }

    public void waitForTripPlan() {
        ((new WebDriverWait(driver, 10))).until(ExpectedConditions.elementToBeClickable(tripPlannerSteps));
    }

    public String getTripPlannerSteps() {
        return tripPlannerSteps.getText();
    }
}
