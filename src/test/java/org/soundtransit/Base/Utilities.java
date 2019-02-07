package org.soundtransit.Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Scanner;

public class Utilities {
    public static void breakExecution() throws Exception{
        System.out.println("Press \"control + c\" to break execution...");
        Scanner sc = new Scanner(System.in);
        String entered = sc.nextLine();
    }

    public static void WaitForAjax(RemoteWebDriver driver) throws InterruptedException
    {
        while (true)
        {
            Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active == 0");
            if (ajaxIsComplete){
                break;
            }
            Thread.sleep(100);
        }
    }
}
