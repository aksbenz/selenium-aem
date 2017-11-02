package com.aia.vweb.ui;

import com.aia.aem.components.Checkbox;
import com.aia.aem.components.Dropdown;
import com.aia.aem.components.PathBrowser;
import com.aia.aem.custom.SettingsForm;

/**
 * Created by AADM221 on 30/10/2017.
 */
public class NavSettings {
    public SettingsForm form;
    public PathBrowser rootPage;
    public Checkbox displayRootOnly;
    public Checkbox showLogoutButton;
    public Dropdown direction;

    public NavSettings(){
        form = new SettingsForm();
        rootPage = new PathBrowser(form.locator(),"Select a Root Page");
        displayRootOnly = new Checkbox(form.locator(),"Display Only the root page?");
        showLogoutButton = new Checkbox(form.locator(),"Should have logout button?");
        direction = new Dropdown(form.locator(),"Nav Direction");
    }
}
