package org.soundtransit.Base;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected RemoteWebDriver driver;

    public BasePage(RemoteWebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver,this);  //THIS BINDS THE FINDBYs TO THEIR WEBELEMENTS. THEY DON'T GET FOUND UNTIL THEY ARE USED. THIS REDUCES THE EFFORT OF USING A LOT OF DRIVER.FINDBY CALLS
    }
}
