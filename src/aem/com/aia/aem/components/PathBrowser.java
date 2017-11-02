package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebElement;

/**
 * Created by aadm221 on 19/10/2017.
 */
public class PathBrowser extends Field<PathBrowser> {
    public PathBrowser(Locator parent, String label){
        super(parent);
        this.label = label;
        elems = new ElemDefs();
    }
    public PathBrowser(String label){
        super();
        this.label = label;
        elems = new ElemDefs();
    }
    protected PathBrowser(){}

    private String label;
    private ElemDefs elems;
    private class ElemDefs{
        private Locator base = new Locator("//label[text()='"+ label +"']/..//input[contains(@class,'js-coral-pathbrowser-input')]",PathType.XPATH);
    }
    protected Locator getBase(){
        return elems.base;
    }

    public PathBrowser set(String value){
        WebElement e = getElement();
        e.clear();
        e.sendKeys(value);
        return this;
    }
}
