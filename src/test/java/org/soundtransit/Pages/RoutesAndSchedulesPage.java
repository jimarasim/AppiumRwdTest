package org.soundtransit.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

public class RoutesAndSchedulesPage extends BasePage {

    @FindBy(id="route_schedule_search_results")
    WebElement results;

    @FindBy(css="button.btn--download-pdf")
    WebElement downloadPdfButton;

    public RoutesAndSchedulesPage(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForPage() {
        ((new WebDriverWait(driver,10))).until(ExpectedConditions.visibilityOf(downloadPdfButton));
    }

    public String getResultsText() {
        return results.getText();
    }

    public void clickDownloadPdfButton() {
        //need to scroll element into view on iphone
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downloadPdfButton);

        downloadPdfButton.click();

        if(driver instanceof IOSDriver) {
            ((new WebDriverWait(driver,10))).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    try {
                        return ((AppiumDriver) driver).getContextHandles().size() == 3;
                    } catch (WebDriverException var3) {
                        return null;
                    }
                }
            });
        } else {
            ((new WebDriverWait(driver,10))).until(ExpectedConditions.numberOfWindowsToBe(2));
        }

    }

}
