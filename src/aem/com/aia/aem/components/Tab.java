package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AADM221 on 30/10/2017.
 */

/***
 * Extend this class to create your custom tab class.<br/>
 * Define all fields within your custom class.<br/>
 * In the constructor call super with Form parent.<br/>
 * And initialize all fields
 *<p/>
 * Example:<br/>
 * public class ImageTab extends Tab{<br/>
 *     public FileUpload imageAsset;<br/>
 *     public TextField title;<br/>
 *     public ImageTab(){<br/>
 *         super(form.locator(),"IMAGE");<br/>
 *         title = new TextField(this.locator(),"Title");<br/>
 *         imageAsset = new FileUpload(this.locator(),"Image asset");<br/>
 *     }<br/>
 * }
 */
public class Tab extends Field<Tab> {
    private ElemDefs elems;
    private String label;
    private TabPanel parentTabPanel;

    public Tab(Locator parent, String label){
        super(new ArrayList<Locator>(Arrays.asList(parent,(new TabPanel(parent).locator()))));
        this.parentTabPanel = new TabPanel(parent);
        this.label = label;
        elems = new ElemDefs();
    }

    protected Tab(){}

    private class ElemDefs{
        private Locator base = new Locator("div.coral-TabPanel-content section.coral-TabPanel-pane.is-active", PathType.CSS);
        private Locator link = new Locator("//div[contains(@class,'coral-TabPanel')]//nav[contains(@class,'coral-TabPanel-navigation')]//a[text()='"+ label +"']",PathType.XPATH);
    }

    protected Locator getBase(){return elems.base;}

    public Tab gotoTab(){
        parentTabPanel.gotoTab(label);
        waitForVisible();
        return this;
    }
}
