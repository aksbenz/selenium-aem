package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by aadm221 on 19/10/2017.
 */
public class RichTextEditor extends Field<RichTextEditor>{
    public RichTextEditor(Locator parent, String label){
        super(parent);
        this.name = label;
        elems = new ElemDefs();
    }
    public RichTextEditor(String label){
        super();
        this.name = label;
        elems = new ElemDefs();
    }
    protected RichTextEditor(){}

    private String name;
    private String value;
    private ElemDefs elems;

    private class ElemDefs{
        private Locator base = new Locator("//label[text()='"+ name +"']/..//div[contains(@class,'coral-RichText-editable')]",PathType.XPATH);
    }
    protected Locator getBase(){
        return elems.base;
    }

    public RichTextEditor set(String value){
        WebElement e = getElement();
        e.clear();
        e.sendKeys(value);
        return this;
    }
}
