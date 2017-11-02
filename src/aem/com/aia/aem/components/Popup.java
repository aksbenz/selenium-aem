package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aadm221 on 22/10/2017.
 */
public class Popup extends Field<Popup> {
    public Popup(String title){
        super();
        this.title = title;
        elems = new ElemDefs();
    }
    protected Popup(){}
    private String title;
    private ElemDefs elems;
    private class ElemDefs{
        private Locator base = new Locator("//div[contains(@class,'coral-Modal')]//h2[contains(@class,'coral-Modal-title')][text()='"+ title +"']/ancestor::div[contains(@class,'coral-Modal')]", PathType.XPATH);
        private Locator btnCancel = new Locator(base.locator() + "//button[text()='Cancel']",PathType.XPATH);
        private Locator btnAny(String label){return new Locator(base.locator() + "//button[text()='"+ label +"']",PathType.XPATH);}
        private Locator buttons = new Locator(base.locator() + "//div[contains(@class,'coral-Modal-footer')]/button",PathType.XPATH);
        private Locator body = new Locator(base.locator() + "div[contains(@class,'coral-Modal-body')]",PathType.XPATH);
    }
    protected Locator getBase(){
        return elems.base;
    }

    public String getTitle(){return title;}

    public String text(){return child(elems.body).getText();}

    public Popup cancel(){
        child(elems.btnCancel).click();
        return this;
    }

    public Popup click(String buttonLabel){
        child(elems.btnAny(buttonLabel)).click();
        return this;
    }

    public List<String> allButtonsLabels(){
        return children(elems.buttons).stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public List<WebElement> allButtons(){
        return children(elems.buttons);
    }

    public Boolean hasButton(String label){
        return child(elems.btnAny(label)).isDisplayed();
    }
}
