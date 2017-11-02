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

    public WebElement element(){return WD.get().d.findElement(locatorType.by(locatorValue));}
    public List<WebElement> elements(){ return WD.get().d.findElements(locatorType.by(locatorValue));}

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
     * Sets the Locator String
     * @param value Locator String value
     * @return This
     */
    public Locator locator(String value){ locatorValue = value; return this;}

    /**
     * Gets the Locator Type
     * @return PathType
     */
    public PathType type(){ return locatorType;}

    /**
     * Updates the Locator Type
     * @param type PathType to update to
     * @return This
     */
    public Locator type(PathType type){ locatorType = type; return this;}
}
