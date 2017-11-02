package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aadm221 on 11/10/2017.
 */
public class InsertComponentDialog extends Field<InsertComponentDialog>{
    public InsertComponentDialog(){
        super();
    }
    private ElemDefs elems = new ElemDefs();

    private class ElemDefs{
        private Locator base = new Locator("div.InsertComponentDialog[role='dialog']", PathType.CSS);
        private Locator header = new Locator(base.locator() + " div.coral-Modal-header", PathType.CSS);
        private Locator content = new Locator(base.locator() + " div.coral-Modal-body[role='document']", PathType.CSS);
        private Locator categories = new Locator(base.locator() + " li.coral-SelectList-item>span", PathType.CSS);
        private Locator buttons = new Locator(content.locator() + " button", PathType.CSS);
        private Locator compLink(String name){return new Locator("//button[text()='"+ name +"']", PathType.XPATH);}
    }
    protected Locator getBase(){
        return elems.base;
    }

    /**
     * Select a component
     * @param categoryName Blank or null to Skip Category
     * @param componentName Mandatory. If Category not provided will select first component with this name
     * @return
     */
    public InsertComponentDialog selectComponent(String categoryName, String componentName){
        WebElement compLink;
        if (categoryName != null && !categoryName.isEmpty()){
            WebElement category = childByText(elems.categories,categoryName).findElement(By.xpath("./.."));
            compLink = category.findElement(elems.compLink(componentName).by());
        }
        else
            compLink = child(elems.content,elems.compLink(componentName));

        compLink.click();

        return this;
    }

    /***
     * List of all component names shown
     * @return List of component names
     */
    public List<String> listComponents(){
        List<WebElement> components = wd.d.findElements(elems.buttons.by());
        List<String> names = components.stream().map(c -> {return c.getText();}).collect(Collectors.toList());
        return names;
    }
}
