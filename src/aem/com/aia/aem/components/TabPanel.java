package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by aadm221 on 13/10/2017.
 */
public class TabPanel extends Field<TabPanel>{

    public TabPanel(Locator parent){
        super(parent);
        elems = new ElemDefs();
    }

    public TabPanel(){
        super();
        elems = new ElemDefs();
    }

    protected Locator getBase(){return elems.base;}
    private ElemDefs elems;
    private class ElemDefs{
        private Locator base = new Locator("div.coral-TabPanel", PathType.CSS);
        private Locator tabBar = new Locator(base.locator() + " nav[role='tablist']",PathType.CSS);
        private Locator tabLinks = new Locator(tabBar.locator() + " a[role='tab']",PathType.CSS);
        private Locator tabContent = new Locator(base.locator() + " div.coral-TabPanel-content",PathType.CSS);
        private Locator activeTabContent = new Locator(tabContent.locator() + " section.coral-TabPanel-pane.is-active[role='tabpanel']",PathType.CSS);
        private Locator activeTab = new Locator(tabBar.locator() + " a.is-active[role='tab']",PathType.CSS);
    }

    public TabPanel gotoTab(String tabName){
        List<WebElement> tabs = wd.d.findElements(elems.tabLinks.by());
        WebElement tab = childByText(elems.tabLinks,tabName);
//        WebElement tab = tabs.stream().filter(t -> t.getText().equals(tabName)).findFirst().orElseThrow(NoSuchElementException::new);
        tab.click();
        return this;
    }
    public Locator activeTab(){
        return elems.activeTabContent;
    }
    public String activeTabName(){
        return wd.d.findElement(elems.activeTab.by()).getText();
    }
}
