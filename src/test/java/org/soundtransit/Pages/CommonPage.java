package org.soundtransit.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.soundtransit.Base.BasePage;

import java.util.ArrayList;
import java.util.Set;

public class CommonPage extends BasePage {
    public CommonPage(RemoteWebDriver driver) {
        super(driver);
    }

    /**
     * Switches to new tab that's been opened
     * @return Old tab window handle
     */
    public String switchToNewTab() {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.numberOfWindowsToBe(2));

        String oldTab = driver.getWindowHandle();
        String newTab = "";

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        for(String tab:tabs) {
            if(!tab.equals(oldTab)) {
                newTab = tab;
                break;
            }
        }

        driver.switchTo().window(newTab);
        return oldTab;
    }

    /**
     * Closes the current tab and switches to provided window handle
     * @param tab
     */
    public void closeCurrentAndSwitchToTab(String tab) {
        driver.close();
        driver.switchTo().window(tab);
    }


    /**
     * uses jquery to click an element provided by a selector
     * @param selector
     */
    public void clickWithJQuery(String selector) {
        ((JavascriptExecutor) driver).executeScript("jQuery('"+selector+"').click();");
    }

    /**
     * This function waits for alert and accepts it
     */
    public void waitForAndAcceptAlert() {
        (new WebDriverWait(driver,10)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    /**
     * This function switches to the newest context.
     * Safari "tabs" are actually separate contexts.
     */
    public String switchToNewContext() throws Exception{
        if(driver instanceof AppiumDriver) {
            String oldContext = ((AppiumDriver) driver).getContext();

            Set<String> contextView = ((AppiumDriver)driver).getContextHandles();
            ArrayList<String> s = new ArrayList<String>(contextView);
            ((AppiumDriver)driver).context(s.get(contextView.size()-1));

            return oldContext;
        } else {
            throw new Exception("THIS IS NOT AN APPIUM DRIVER, YOU CAN'T USE THIS");
        }
    }

    /**
     * Closes the current context
     */
    public void closeCurrentContext() {
        driver.close();
    }

}
