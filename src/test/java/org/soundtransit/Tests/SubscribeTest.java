package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Base.Utilities;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeTest extends BaseTest {

    @Test
    public void subscribeWithEmail() throws Exception {
        String email = "example@website.com";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.enterSubscribeText(email);
        homePage.clickSubscribeButton();

        CommonPage commonPage = new CommonPage(driver);
        String oldTab = commonPage.switchToNewTab();

        Assert.assertEquals(driver.getCurrentUrl(),"https://public.govdelivery.com/accounts/WASOUND/subscribers/qualify?qsp=CODE_RED&country_code=1&subscription_type=email&email=example%40website.com");

        commonPage.closeCurrentAndSwitchToTab(oldTab);
    }

}
