package com.aia.vweb.ui;

import com.aia.aem.components.RichTextEditor;
import com.aia.aem.components.Tab;
import com.aia.aem.components.TabPanel;
import com.aia.aem.components.TextArea;
import com.aia.aem.custom.SettingsForm;

/**
 * Created by AADM221 on 30/10/2017.
 */
public class TextSettings {
    public SettingsForm form;
    public TabPanel tabs;
    public TextTab textTab;
    public class TextTab extends Tab{
        public RichTextEditor text;
        public TextTab(){
            super(form.locator(),"Text");
            text = new RichTextEditor(this.locator(),"Text");
        }
    }

    public TextSettings(){
        form = new SettingsForm();
        textTab = new TextTab();
    }
}
