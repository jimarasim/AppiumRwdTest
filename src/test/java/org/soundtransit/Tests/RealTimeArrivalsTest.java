package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.soundtransit.Pages.RealTimeArrivalsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RealTimeArrivalsTest extends BaseTest {
    @Test
    public void realTimeArrival() throws Exception {

        String address = "401 S Jackson St, Seattle, WA 98104";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.enterRealTimeArrivalsAddress(address);

        CommonPage commonPage = new CommonPage(driver);
        commonPage.selectSmartSearchOption(address);

        RealTimeArrivalsPage strtap = homePage.clickRealTimeArrivalsButton();
        strtap.waitForRealTimeArrivalsResult();

        Assert.assertEquals(strtap.getRealTimeArrivalsSearchResultsText(),address);
    }
}
