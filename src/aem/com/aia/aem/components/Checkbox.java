package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebElement;

/**
 * Created by aadm221 on 19/10/2017.
 */
public class Checkbox extends Field<Checkbox>{
    private String label;
    private ElemDefs elems;

    private class ElemDefs{
        private Locator base = new Locator("//span[text()='" + label + "']/../input[@type='checkbox']",PathType.XPATH);
    }
    public Checkbox(Locator parent, String label){
        super(parent);
        this.label = label;
        elems = new ElemDefs();
    }
    protected Locator getBase(){
        return elems.base;
    }
    protected PathType getBaseType(){
        return PathType.XPATH;
    }
    public WebElement element(){
        return getElement();
    }

    public Checkbox check(){
        WebElement e = getElement();
        if (!e.isSelected())
            e.click();
        return this;
    }
    public Checkbox uncheck(){
        WebElement e = getElement();
        if (e.isSelected())
            e.click();
        return this;
    }
    public Checkbox toggle(){
        getElement().click();
        return this;
    }
}
