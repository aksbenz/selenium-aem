package com.aia.vweb.ui;

import com.aia.aem.components.*;
import com.aia.aem.custom.SettingsForm;
import com.aia.aem.custom.SizeField;
import com.aia.aem.components.Tab;

/**
 * Created by aadm221 on 20/10/2017.
 */
public class ImageSettings {
    public SettingsForm form;
    public ImageTab imageTab;
    public AccessibilityTab accessibilityTab;
    public SvgTab svgTab;

    public ImageSettings(){
        form = new SettingsForm();
        imageTab = new ImageTab();
        svgTab = new SvgTab();
        accessibilityTab = new AccessibilityTab();
    }

    public class ImageTab extends Tab{
        public FileUpload imageAsset;
        public TextField title;
        public PathBrowser linkTo;
        public TextArea description;
        public SizeField size;

        public ImageTab(){
            super(form.locator(),"IMAGE");
            title = new TextField(this.locator(),"Title");
            description = new TextArea(this.locator(),"Description");
            size = new SizeField(this.locator(),"Size (px)");
            imageAsset = new FileUpload(this.locator(),"Image asset");
            linkTo = new PathBrowser(this.locator(),"Link to");
        }
    }
    public class AccessibilityTab extends Tab{
        public TextField alternative;
        public Checkbox decorative;

        public AccessibilityTab(){
            super(form.locator(),"ACCESSIBILITY");
            alternative = new TextField(this.locator(),"Alternative Text");
            decorative = new Checkbox(this.locator(),"Image is decorative");
        }
    }

    public class SvgTab extends Tab{
        public FileUpload svgAsset;
        public TextArea svgInline;
        public PathBrowser linkTo;

        public SvgTab(){
            super(form.locator(),"SVG");
            svgAsset = new FileUpload(this.locator(),"File Upload");
        }
    }
}