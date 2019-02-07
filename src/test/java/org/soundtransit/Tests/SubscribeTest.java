package org.soundtransit.Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.soundtransit.Base.BaseTest;
import org.soundtransit.Base.Utilities;
import org.soundtransit.Pages.CommonPage;
import org.soundtransit.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class SubscribeTest extends BaseTest {

    @Test
    public void subscribeWithEmail() throws Exception {
        String email = "example@website.com";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.enterSubscribeText(email);
        homePage.clickSubscribeButton();

        Thread.sleep(2000);

        CommonPage commonPage = new CommonPage(driver);
        //iphone safari throws a current location alert
        if(driver instanceof IOSDriver) {
            commonPage.waitForAndAcceptAlert();

            Set<String> contextView = ((AppiumDriver)driver).getContextHandles();
            ArrayList<String> s = new ArrayList<String>(contextView);
            ((AppiumDriver)driver).context(s.get(contextView.size()-1));

            Assert.assertEquals(driver.getCurrentUrl(), "https://public.govdelivery.com/accounts/WASOUND/subscribers/qualify?qsp=CODE_RED&country_code=1&subscription_type=email&email=example%40website.com");

            driver.close();
        } else {

            String oldTab = commonPage.switchToNewTab();

            Assert.assertEquals(driver.getCurrentUrl(), "https://public.govdelivery.com/accounts/WASOUND/subscribers/qualify?qsp=CODE_RED&country_code=1&subscription_type=email&email=example%40website.com");

            commonPage.closeCurrentAndSwitchToTab(oldTab);
        }
    }

}
