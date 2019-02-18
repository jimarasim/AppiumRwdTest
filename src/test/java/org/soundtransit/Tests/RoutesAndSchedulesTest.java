package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.soundtransit.Pages.RoutesAndSchedulesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RoutesAndSchedulesTest extends BaseTest {
    @Test
    public void FindBusRouteTest(){
        String routeNumber = "511";
        String routeName = "511 - Ash Way";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.selectRoutesAndSchedulesTab();

        homePage.enterRouteNumber(routeNumber);

        CommonPage commonPage = new CommonPage(driver);
        commonPage.selectSmartSearchOption(routeName);

        RoutesAndSchedulesPage routesAndSchedulesPage = homePage.clickFindScheduleButton();

        Assert.assertTrue(routesAndSchedulesPage.getResultsText().contains("Sound Transit"));

    }
}
