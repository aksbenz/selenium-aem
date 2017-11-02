package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by aadm221 on 20/10/2017.
 */
public class TextArea extends Field<TextArea> {
    private String name;
    private ElemDefs elems;
    private class ElemDefs{
        private Locator base = new Locator("//label[text()='"+ name +"']/../textarea[contains(@class,'coral-Textfield--multiline')]",PathType.XPATH);
    }

    protected Locator getBase(){
        return elems.base;
    }

    public TextArea(Locator parent, String label){
        super(parent);
        this.name = label;
        elems = new ElemDefs();
    }

    public TextArea(String label){
        super();
        this.name = label;
        elems = new ElemDefs();
    }
    protected TextArea(){}

    /***
     * Set Value
     * @param value Value to set
     * @return This
     */
    public TextArea value(String value){
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
