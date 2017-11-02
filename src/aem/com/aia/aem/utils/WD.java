package com.aia.aem.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by AADM221 on 26/10/2017.
 */
public class WD {
    public WebDriver d;
    public WebDriverWait wait;
    public int timeout;
    private static WD instance = null;

    protected WD(WebDriver d,int timeout){
        this.d = d;
        this.timeout = timeout;
        wait = new WebDriverWait(this.d,this.timeout);
    }

    /***
     * Inistialize the global WD object to set WebDriver object and other options
     * @param driver Webdriver Object
     * @param timeoutSeconds Timeout in seconds
     * @return
     */
    public static WD initialize(WebDriver driver, int timeoutSeconds){
        if (instance == null)
            instance = new WD(driver,timeoutSeconds);
        return instance;
    }

    /***
     * Use this only to get the already initialized instance
     * @return
     */
    public static WD get(){
        if (instance == null)
            throw new RuntimeException("WD not initialized. Call WD.instantiate with Webdriver Object and other settings in your webdriver initializer");
        return instance;
    }
}
