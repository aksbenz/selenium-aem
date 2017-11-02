package com.aia.aem.pages;

/**
 * Created by aadm221 on 3/10/2017.
 */
import com.aia.aem.components.Field;
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Editor extends Field<Editor>{
    public Editor(){
        super();
        elems = new ElemDefs();
    }
    private ElemDefs elems;

    private class ElemDefs{
        private Locator base = new Locator("//div[@id='OverlayWrapper']", PathType.XPATH);
        private Locator components = new Locator("//div[contains(@class,'cq-Overlay--component')][not(contains(@class,'cq-Overlay--container'))][contains(@class,'cq-Overlay--placeholder') or contains(@class,'cq-draggable')]",PathType.XPATH);
        private Locator compAttrValue(String attr, String value){
            return new Locator("//div[contains(@class,'cq-Overlay--component')][not(contains(@class,'cq-Overlay--container'))][contains(@class,'cq-Overlay--placeholder') or contains(@class,'cq-draggable')][contains(@"+attr+",'"+value+"')]",PathType.XPATH);
        }
    }
    protected Locator getBase(){
        return elems.base;
    }

    public List<WebElement> allComponents(){
        return children(elems.components);
    }

    public WebElement compHavingAttributeValue(String attribute, String value){
        return child(elems.compAttrValue(attribute,value));
    }
}
