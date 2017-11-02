package com.aia.aem.components;

/**
 * Created by aadm221 on 3/10/2017.
 */
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBar extends Field<NavBar>{
    public NavBar(){ super();}
    private ElemDefs elems = new ElemDefs();

    private class ElemDefs {
        private Locator base = new Locator("div.editor-GlobalBar nav.coral-GlobalBar-main", PathType.CSS);
        private Locator title =  new Locator(base.locator() + " div.editor-GlobalBar-pageTitle", PathType.CSS);
        private Locator btnPreview = new Locator(base.locator() + " button.editor-GlobalBar-previewTrigger", PathType.CSS);
        private Locator btnEdit = new Locator(base.locator() + " button[data-layer='Edit']", PathType.CSS);
        private Locator btnTogglePanel = new Locator(base.locator() + " button[title='Toggle Side Panel']", PathType.CSS);
        private Locator btnPageInfo = new Locator(base.locator() + " a#pageinfo-trigger", PathType.CSS);
        private Locator pageInfoPop = new Locator(base.locator() + " div#pageinfo-popover", PathType.CSS);
        private Locator pageInfoItems = new Locator(pageInfoPop.locator() + " button", PathType.CSS);
        private Locator pageInfoItem(String name){return new Locator(pageInfoPop.locator() + " button[title='"+ name +"']", PathType.CSS);}
    }
    protected Locator getBase(){return elems.base;}

    public NavBar waitForTogglePanel(){
        return waitFor(elems.btnTogglePanel);
    }

    /***
     * Goto Preview Mode <br/>
     * TODO: Check if already in Preview mode
     * @return This
     */
    public NavBar previewMode(){
        wd.d.findElement(elems.btnPreview.by()).click();
        return this;
    }

    /***
     * Goto Edit Mode <br/>
     * TODO: Check if already in Edit mode
     * @return This
     */
    public NavBar editMode() {
        wd.d.findElement(elems.btnEdit.by()).click();
        return this;
    }

    /***
     * Select Page Info item <br/>
     * Opens Page Info Menu if not already open
     * @param item Name of item to select
     * @return This
     */
    public NavBar selectPageInfoItem(String item){
        openPageInfoMenu();
        waitFor(elems.pageInfoItem(item));
        wd.d.findElement(elems.pageInfoItem(item).by()).click();
        return this;
    }

    /***
     * Open the Page Info Menu <br/>
     * Checks if menu already open
     * @return This
     */
    public NavBar openPageInfoMenu() {
        try {
            if (!wd.d.findElement(elems.pageInfoPop.by()).isDisplayed())
                wd.d.findElement(elems.btnPageInfo.by()).click();
        }catch (Exception e){
            wd.d.findElement(elems.btnPageInfo.by()).click();
        }
        waitFor(elems.pageInfoPop,10);
        return this;
    }
}
