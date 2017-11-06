package com.aia.aem.utils;

import com.aia.aem.enums.PathType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by aadm221 on 22/10/2017.
 */
public class Locator {
    private String locatorValue;
    private PathType locatorType;

    public Locator(String locator, PathType type){
        this.locatorValue = locator;
        this.locatorType = type;
    }
    protected Locator(){}

    public WebElement element(){return WD.get().d.findElement(by());}
    public List<WebElement> elements(){ return WD.get().d.findElements(by());}

    /***
     * Gets the Webdriver BY object based on Path Type
     * @return By object
     */
    public By by(){
        return locatorType.by(locatorValue);
    }

    /**
     * Get Locator String
     * @return Locator String
     */
    public String locator(){ return locatorValue;}
    /**
     * Gets the Locator Type
     * @return PathType
     */
    public PathType type(){ return locatorType;}

    /***
     * Updates the locator values
     * @param value Locator String
     * @param type PathType
     * @return This
     */
    public Locator locator(String value, PathType type){locatorValue = value; locatorType = type; return this;}
}
