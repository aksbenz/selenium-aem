package com.aia.aem.pages;

import com.aia.aem.components.Field;
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by aadm221 on 23/10/2017.
 */
public class Preview extends Field<Preview>{

    private ElemDefs elems = new ElemDefs();
    public Preview(){super();}

    private class ElemDefs{
        private String frame = "ContentFrame";
        private Locator base = new Locator("//body", PathType.XPATH);
        private Locator mainSection = new Locator(base.locator() + "//section[@class='main']",PathType.XPATH);
        private Locator mainSubSections = new Locator(mainSection.locator() + "/div[contains(@class,'section')]",PathType.XPATH);
        private Locator headerSection = new Locator(base.locator() + "//section[@class='header']",PathType.XPATH);
        private Locator footerSection = new Locator(base.locator() + "//footer",PathType.XPATH);
    }

    protected Locator getBase(){
        return elems.base;
    }

    @Override
    protected WebElement getElement(){
        wd.d.switchTo().frame(elems.frame);
        return wd.d.findElement(elems.base.by());
    }

    public void defaultFrame(){
        wd.d.switchTo().defaultContent();
    }

    public WebElement body(){
        return getElement();
    }

    public WebElement mainSection(){
        return getElement().findElement(elems.mainSection.by());
    }
    public WebElement footer(){
        return getElement().findElement(elems.footerSection.by());
    }
    public List<WebElement> mainSubSections(){
        return getElement().findElements(elems.mainSubSections.by());
    }
}
