package org.soundtransit.Base;

public enum Device {
    IPHONESAFARI("iOS","12.1","iPhone 7","safari","",""),
    IPHONESAFARI8("iOS","12.1","iPhone 8","safari","",""),
    IPHONESAFARIOLD("iOS","11.2","iPhone 7","safari","",""),
    IPHONESAFARIREAL("iOS","12.1","iPhone 6s","safari","","e4bd336879e62840d7750c0e8f989673c167bcfc"),
    ANDROIDCHROME("Android","9.0","Android Emulator","Chrome","NexusOne",""),
    DESKTOPCHROME("","","","","","");

    public final String platformName;
    public final String platformVersion;
    public final String deviceName;
    public final String browserName;
    public final String avd;
    public final String udid;

    Device(String platformName, String platformVersion, String deviceName, String browserName, String avd, String udid) {
        this.platformName = platformName;
        this.platformVersion = platformVersion;
        this.deviceName = deviceName;
        this.browserName = browserName;
        this.avd = avd;
        this.udid = udid;
    }
}
