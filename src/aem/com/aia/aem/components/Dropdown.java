package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by AADM221 on 30/10/2017.
 */
public class Dropdown extends Field<Dropdown> {
    public Dropdown(Locator parent, String label){
        super(parent);
        this.label = label;
        elems = new ElemDefs();
    }
    private String label;
    private ElemDefs elems;

    private class ElemDefs{
        private Locator base = new Locator("//label[text()='" + label + "']/..//select", PathType.XPATH);
        private Locator option(String value){return new Locator(base.locator() + "/option[text()='"+ value +"']",PathType.XPATH);}
        private Locator options = new Locator(base.locator() + "/option",PathType.XPATH);
    }
    protected Locator getBase(){return elems.base;}

    public Dropdown select(String option){
        elems.option(option).element().click();
        return this;
    }

    public Dropdown selectByIndex(int index){
        elems.options.elements().get(index).click();
        return this;
    }
}
