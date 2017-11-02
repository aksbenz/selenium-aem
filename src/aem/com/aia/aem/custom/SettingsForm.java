package com.aia.aem.custom;

import com.aia.aem.components.Field;
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by aadm221 on 20/10/2017.
 */
public class SettingsForm extends Field<SettingsForm> {
    public SettingsForm(Locator parent){
        super(parent);
        elems = new ElemDefs();
    }
    public SettingsForm(){
        super();
        elems = new ElemDefs();
    }

    private ElemDefs elems;
    protected Locator getBase(){
        return elems.base;
    }

    private class ElemDefs {
        private Locator base = new Locator("form.coral-Form.foundation-form",PathType.CSS);
        private Locator header = new Locator(base.locator() + " nav.cq-dialog-header",PathType.CSS);
        private Locator hdrTitle = new Locator(header.locator() + " h2.coral-Heading",PathType.CSS);
        private Locator formActions = new Locator(header.locator() + " div.cq-dialog-actions",PathType.CSS);
        private Locator btnHelp = new Locator(formActions.locator() + " button[title='Help']",PathType.CSS);
        private Locator btnCancel = new Locator(formActions.locator() + " button[title='Cancel']",PathType.CSS);
        private Locator btnDone = new Locator(formActions.locator() + " button[title='Done']",PathType.CSS);
        private Locator btnTglFullScn = new Locator(formActions.locator() + " button[title='Toggle Fullscreen']",PathType.CSS);
        private Locator content = new Locator(base.locator() + " div.cq-dialog-content",PathType.CSS);
    }

    public String getHeading(){
        return wd.d.findElement(elems.hdrTitle.by()).getText();
    }

    public SettingsForm done(){
        wd.d.findElement(elems.btnDone.by()).click();
        return this;
    }
    public SettingsForm cancel(){
        wd.d.findElement(elems.btnCancel.by()).click();
        return this;
    }
    public SettingsForm toggleFullscreen(){
        wd.d.findElement(elems.btnTglFullScn.by()).click();
        return this;
    }
    public SettingsForm help(){
        wd.d.findElement(elems.btnHelp.by()).click();
        return this;
    }
}
