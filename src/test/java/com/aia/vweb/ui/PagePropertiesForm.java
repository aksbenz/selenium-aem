package com.aia.vweb.ui;

import com.aia.aem.components.*;
import com.aia.aem.components.Checkbox;
import com.aia.aem.components.TextField;
import com.aia.aem.custom.SettingsForm;
import com.aia.aem.utils.Locator;

/**
 * Created by aadm221 on 19/10/2017.
 */
public class PagePropertiesForm {
    public SettingsForm form;
    public TabPanel tabpanel;
    public enum Tabs{
        BASIC ("BASIC"),
        MOBILE ("MOBILE"),
        ADVANCED ("ADVANCED"),
        THUMBNAIL ("THUMBNAIL"),
        CLOUD_SERVICES("CLOUD SERVICES");
        private final String text;
        Tabs(String text){
            this.text = text;
        }
        public String getText(){
            return this.text;
        }
    };
    public BasicTab basicTab;
    public MobileTab mobileTab;
    public class BasicTab{
        public TextField title;
        public TextField pageTitle;
        public BasicTab(Locator parent){
            title = new TextField(parent,"Title *");
            pageTitle = new TextField(parent,"Page Title");
        }
    }

    public class MobileTab{
        public Checkbox benefitPageCkb;
        public TextField name;
        public TextField styling;
        public TextField shortDescription;
        public RichTextEditor longDescription;
        public TextField discountValue;
        public PathBrowser pdfGuide;

        public MobileTab(Locator parent){
            benefitPageCkb = new Checkbox(parent,"It this a Benefit Page?");
            name = new TextField(parent,"Name");
            styling = new TextField(parent,"Styling");
            shortDescription = new TextField(parent,"Short description");
            discountValue = new TextField(parent,"Discount Value");
            longDescription = new RichTextEditor(parent,"Long Description");
        }
    }
    public PagePropertiesForm(){
        form = new SettingsForm();
        tabpanel = new TabPanel(form.locator());
        basicTab = new BasicTab(tabpanel.locator());
        mobileTab = new MobileTab(tabpanel.locator());
    }
}
