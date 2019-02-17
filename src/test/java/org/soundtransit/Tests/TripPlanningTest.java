package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.soundtransit.Pages.TripPlanningPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TripPlanningTest extends BaseTest {
    @Test(dataProvider = "DepartGoingProvider")
    public void tripPlannerLocations(String depart, String going) throws Exception {
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

    @DataProvider(name="DepartGoingProvider")
    public Object[][] getData(){
        return new Object[][]{
                {"Fremont Troll", "Seattle Center Pavillion"},
                {"Carkeek Park", "Gas Works Park"},
                {"Discovery Park", "Volunteer Park"}
        };
    }
}
