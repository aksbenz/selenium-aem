package com.aia.aem.components;

/**
 * Created by aadm221 on 3/10/2017.
 */
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditableToolbar extends Field<EditableToolbar>{
    public EditableToolbar(){super();}
    private ElementDefinitions elems = new ElementDefinitions();
    private class ElementDefinitions{
        private Locator base = new Locator("div#EditableToolbar", PathType.CSS);
        private Locator buttons = new Locator(base.locator() + ">button", PathType.CSS);
        private String buttonsAttribute = "title";
        private Locator settings = new Locator(base.locator() + " button[title='Configure']", PathType.CSS);
        private Locator copy = new Locator(base.locator() + " button[title='Copy']", PathType.CSS);
        private Locator cut = new Locator(base.locator() + " button[title='Cut']", PathType.CSS);
        private Locator delete = new Locator(base.locator() + " button[title='Delete']", PathType.CSS);
        private Locator insert = new Locator(base.locator() + " button[title='Insert component']", PathType.CSS);
        private Locator paste = new Locator(base.locator() + " button[title='Paste']", PathType.CSS);
        private Locator group = new Locator(base.locator() + " button[title='Group']", PathType.CSS);
        private Locator parent = new Locator(base.locator() + " button[title='Parent']", PathType.CSS);
    }

    protected Locator getBase(){return elems.base;}

    public List<String> getListOfOptions() {
        List<WebElement> options = wd.d.findElements(elems.buttons.by());
        List<String> optionNames = options.stream().map(opt -> opt.getAttribute(elems.buttonsAttribute)).collect(Collectors.toList());
        return optionNames;
    }

    public EditableToolbar optionSettings(){
        wd.d.findElement(elems.settings.by()).click();
        return this;
    }
    public EditableToolbar optionCopy(){
        wd.d.findElement(elems.copy.by()).click();
        return this;
    }
    public EditableToolbar optionDelete(){
        wd.d.findElement(elems.delete.by()).click();
        return this;
    }
    public EditableToolbar optionInsert(){
        wd.d.findElement(elems.insert.by()).click();
        return this;
    }
    public EditableToolbar optionPaste(){
        wd.d.findElement(elems.paste.by()).click();
        return this;
    }
    public EditableToolbar optionGroup(){
        wd.d.findElement(elems.group.by()).click();
        return this;
    }
    public EditableToolbar optionParent(){
        wd.d.findElement(elems.parent.by()).click();
        return this;
    }
}
