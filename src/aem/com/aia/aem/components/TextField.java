package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by aadm221 on 9/10/2017.
 */
public class TextField extends Field<TextField>{
    public TextField(List<Locator> parent, String label){
        super(parent);
        this.name = label;
        elems = new ElemDefs();
    }
    public TextField(Locator parent, String label){
        super(parent);
        this.name = label;
        elems = new ElemDefs();
    }

    private String name;
    private ElemDefs elems;

    protected Locator getBase(){return elems.base;}
    private class ElemDefs{
        private Locator base = new Locator("//label[text()='"+ name +"']/../input[contains(@class,'coral-Textfield')]",PathType.XPATH);
    }

    /***
     * Set Value
     * @param value Value to set
     * @return This
     */
    public TextField value(String value){
        WebElement e = getElement();
        e.clear();
        e.sendKeys(value);
        return this;
    }

    /***
     * Gets the current value of input
     * @return Value
     */
    public String value(){
        return getElement().getAttribute("value");
    }
}
