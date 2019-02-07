package org.soundtransit.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

public class SearchPage extends BasePage {
    @FindBy(id="formsText1_searchPage")
    WebElement searchTextBox;

    @FindBy(xpath="//div[@class='search-results-item'][1]/div[1]")
    WebElement firstResultText;

    public SearchPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        ((new WebDriverWait(driver,10))).until(ExpectedConditions.visibilityOf(searchTextBox));
    }

    public String getFirstResultText() {
        return firstResultText.getText();
    }
}
