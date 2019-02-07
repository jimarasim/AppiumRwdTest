package org.soundtransit.Tests;

import org.soundtransit.Base.BaseTest;
import org.soundtransit.Pages.HomePage;
import org.soundtransit.Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void searchForSounder() throws Exception {

        String searchTerm = "sounder";

        HomePage homePage = new HomePage(driver);
        homePage.navigate();

        homePage.clickHomeButton();

        SearchPage searchPage = homePage.enterSearchTerm(searchTerm);
        Assert.assertTrue(searchPage.getFirstResultText().toLowerCase().contains(searchTerm));
    }

}
