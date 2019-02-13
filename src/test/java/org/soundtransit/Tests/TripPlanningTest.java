package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.soundtransit.Pages.TripPlanningPage;
import org.testng.annotations.Test;

public class TripPlanningTest extends BaseTest {
    @Test
    public void tripPlannerAddresses() throws Exception {

        String depart = "401 S Jackson St, Seattle, WA 98104";
        String going = "3504 SW Webster St, Seattle, WA 98126";

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

//        Assert.assertEquals(strtap.getRealTimeArrivalsSearchResultsText(),address);
    }
}
