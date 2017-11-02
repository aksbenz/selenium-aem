package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by aadm221 on 20/10/2017.
 */
public class NumberInput extends Field<NumberInput> {
    private String name;
    private ElemDefs elems;
    private class ElemDefs{
        private Locator base = new Locator("input[type='number'][name*='"+ name +"']",PathType.CSS);
    }

    protected Locator getBase(){
        return elems.base;
    }

    /***
     * Prevent from creating NumberInput object with default constructor
     */
    protected NumberInput(){}

    public NumberInput(String name){
        super();
        this.name = name;
        elems = new ElemDefs();
    }

    public NumberInput(Locator parent, String name){
        super(parent);
        this.name = name;
        elems = new ElemDefs();
    }

    public NumberInput(List<Locator> parents, String name){
        super(parents);
        this.name = name;
        elems = new ElemDefs();
    }

    /***
     * Set value
     * @param value Value to set
     * @return This
     */
    public NumberInput value(String value){
        WebElement e = getElement();
        e.clear();
        e.sendKeys(value);
        return this;
    }

    /***
     * Get value
     * @return Value
     */
    public String value(){
        WebElement e = getElement();
        return e.getAttribute("value");
    }
}
