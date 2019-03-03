package org.soundtransit.Tests;

import io.appium.java_client.ios.IOSDriver;
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

    @Test
    public void ShowScheduleTest() throws Exception{
        String routeNumber = "511";
        String routeName = "511 - Ash Way";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.selectRoutesAndSchedulesTab();

        homePage.enterRouteNumber(routeNumber);

        CommonPage commonPage = new CommonPage(driver);
        commonPage.selectSmartSearchOption(routeName);

        RoutesAndSchedulesPage routesAndSchedulesPage = homePage.clickFindScheduleButton();

        routesAndSchedulesPage.clickDownloadPdfButton();

        String websiteTab;
        if(driver instanceof IOSDriver) {
            //ios uses contexts instead of windows for newly opened tabs
            websiteTab = commonPage.switchToNewContext();
        } else {
            websiteTab = commonPage.switchToNewTab();
        }

        commonPage.waitForPageToLoad(".pdf");
        Assert.assertTrue(driver.getCurrentUrl().endsWith(".pdf"));
        if(driver instanceof IOSDriver) {
            commonPage.closeCurrentContext();
        } else {
            commonPage.closeCurrentAndSwitchToTab(websiteTab);
        }

    }
}
