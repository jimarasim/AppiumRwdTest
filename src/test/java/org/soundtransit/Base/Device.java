package org.soundtransit.Base;

public enum Device {
    IPHONESAFARI("iOS","12.1","iPhone 7","safari",""),
    IPHONESAFARI8("iOS","12.1","iPhone 8","safari",""),
    IPHONESAFARIOLD("iOS","11.2","iPhone 7","safari",""),
    ANDROIDCHROME("Android","9.0","Android Emulator","Chrome","Pixel"),
    DESKTOPCHROME("","","","","");

    public final String platformName;
    public final String platformVersion;
    public final String deviceName;
    public final String browserName;
    public final String avd;

    Device(String platformName, String platformVersion, String deviceName, String browserName, String avd) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.browserName = browserName;
        this.avd = avd;
    }
}
