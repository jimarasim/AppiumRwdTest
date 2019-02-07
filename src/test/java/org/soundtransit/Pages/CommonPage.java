package org.soundtransit.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.soundtransit.Base.BasePage;

import java.util.ArrayList;

public class CommonPage extends BasePage {
    public CommonPage(RemoteWebDriver driver) {
        super(driver);
    }

    /**
     * Switches to new tab that's been opened
     * @return Old tab window handle
     */
    public String switchToNewTab() {
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
    public void ClickWithJQuery(String selector) {
        ((JavascriptExecutor) driver).executeScript("jQuery('"+selector+"').click();");
    }


}
