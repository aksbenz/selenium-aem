package com.aia.aem.enums;

import org.openqa.selenium.By;

/**
 * Created by aadm221 on 20/10/2017.
 */
public enum PathType {
    XPATH,
    CSS,
    CLASS,
    ID,
    LINKTEXT,
    NAME,
    PARTIALLINKTEXT,
    TAGNAME;

    public By by(String locator){
        switch (this.name()){
            case "XPATH": return By.xpath(locator);
            case "ID": return By.id(locator);
            case "CLASS": return By.className(locator);
            case "LINKTEXT": return By.linkText(locator);
            case "NAME": return By.name(locator);
            case "PARTIALLINKTEXT": return By.partialLinkText(locator);
            case "TAGNAME": return By.tagName(locator);
            case "CSS": default: return By.cssSelector(locator);
        }
    }
}
