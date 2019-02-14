package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.soundtransit.Pages.TripPlanningPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TripPlanningTest extends BaseTest {
    @Test
    public void tripPlannerLocations() throws Exception {

        String depart = "Fremont Troll";
        String going = "Seattle Center Pavillion";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.selectTripPlanningTab();

        homePage.enterTripPlannerDepartAddress(depart);

        CommonPage commonPage = new CommonPage(driver);
        commonPage.selectSmartSearchOption(depart);

        homePage.enterTripPlannerGoingAddress(going);
        commonPage.selectSmartSearchOption(going);

        TripPlanningPage tripPlannerPage = homePage.clickPlanYourTripButton();
        tripPlannerPage.waitForTripPlan();

        Assert.assertTrue(tripPlannerPage.getTripPlannerSteps().contains("Metro Transit"));
    }
}
