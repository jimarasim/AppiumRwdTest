package org.soundtransit.Base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;

public class BaseTest {
    protected RemoteWebDriver driver = null;
    private Device devicebrowser = Device.IPHONESAFARI;

    @Parameters("device")
    @BeforeMethod(alwaysRun = true)
    public void BeforeTest(String testngdevicebrowser) throws Exception{

        if(testngdevicebrowser!=null && !testngdevicebrowser.isEmpty()) {
            devicebrowser = Device.valueOf(testngdevicebrowser);
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", devicebrowser.platformName);
        capabilities.setCapability("platformVersion", devicebrowser.platformVersion);
        capabilities.setCapability("deviceName", devicebrowser.deviceName);
        capabilities.setCapability("browserName", devicebrowser.browserName);

        /* REAL DEVICE NOTES
            brew install libimobiledevice --HEAD
            npm install -g ios-deploy
            https://github.com/appium/appium-xcuitest-driver/blob/master/docs/real-device-config.md
            install ios_webkit_debug_proxy (IWDP) http://appium.io/docs/en/writing-running-appium/web/mobile-web/
            settings > safari > advanced > web inspector on
         */
        if(devicebrowser == Device.IPHONESAFARIREAL) {
            capabilities.setCapability("udid",devicebrowser.udid);
            //capabilities.setCapability("xcodeOrgId", "<team id in developer site > membership>");
            //capabilities.setCapability("xcodeSigningId", "iPhone Developer");
            capabilities.setCapability("startIWDP", true);
            capabilities.setCapability("automationName", "XCUITest");
        }

        if(devicebrowser.toString().contains("IPHONE")) {
            /*SAFARI NOTES
             * Download Xcode
             * Install Carthage. Might have to use an old version of carthage if your os/xcode is old. Go to the site and download/install the pkg; otherwise, use brew install carthage
             * Use a device that is installed in xcode (see Device)
             * */
            capabilities.setCapability("nativeWebTap",true); //normal button click doesn't work without this
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else if (devicebrowser == Device.ANDROIDCHROME) {
        /*ANDROID NOTES
        DOWNLOAD ANDROID STUDIO
        IN ANDROID STUDIO, OPEN AVD MANAGER AND ADD A DEVICE (Pixel 2 XL worked)
        SET ANDROID HOME AND JAVA HOME IN .bash_profile
            export ANDROID_HOME=/Users/jameskarasim/Library/Android/sdk
            export JAVA_HOME=$(/usr/libexec/java_home)
        DOWNLOAD CHROMEDRIVER AND PUT PATH IN APPIUM ADVANCED SETTINGS (full path ../chromedriver)
            chromedriver needs to be compatible with version of chrome installed on device http://appium.io/docs/en/writing-running-appium/web/chromedriver/
            {
              "platformName": "Android",
              "platformVersion": "9.0",
              "deviceName": "Android Emulator",
              "browserName": "Chrome",
              "avd": "Pixel"
            }
         */
            capabilities.setCapability("avd",devicebrowser.avd);
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } else if (devicebrowser == Device.DESKTOPCHROME) {
            System.setProperty("webdriver.chrome.driver", "./chromedriver245");
            driver = new ChromeDriver();

            Dimension d = new Dimension(420,600);
            //Resize the current window to the given dimension
            driver.manage().window().setSize(d);
        }
    }

    @AfterMethod
    public void AfterTest(){
        driver.quit();
        driver = null;
    }

    protected void SetDeviceBrowser(Device devicebrowser) {
        this.devicebrowser = devicebrowser;
    }
}
