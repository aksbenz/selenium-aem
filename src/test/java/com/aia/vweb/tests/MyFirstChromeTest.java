package com.aia.vweb.tests;

import com.aia.aem.components.*;
import com.aia.aem.enums.PathType;
import com.aia.aem.pages.Editor;
import com.aia.aem.pages.Login;
import com.aia.aem.pages.Preview;
import com.aia.aem.utils.Locator;
import com.aia.aem.utils.WD;
import com.aia.vweb.ui.ImageSettings;
import com.aia.vweb.ui.NavSettings;
import com.aia.vweb.ui.PagePropertiesForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.JOptionPane;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MyFirstChromeTest {
    private WebDriver d;

    private void startWebDriver(){
        d = new ChromeDriver();
        WD.initialize(d,10);
        d.manage().window().maximize();
        d.navigate().to("http://aaiwkdt021067.aia.biz:4402/editor.html/content/au-aiavitality/en/Test/TestTitle/TestAutomationcomponent.html");
        (new Login()).loginWith("admin","admin");

    }
    @Test
    public void insertComponentTest(){
        startWebDriver();

        Locator addComponent = new Locator("div[data-path*='content/header/grid/row0/*']",PathType.CSS);
        waitFor(addComponent);
        d.findElement(addComponent.by()).click();

        EditableToolbar et = new EditableToolbar();
        et.waitForVisible();
        et.optionInsert();

        InsertComponentDialog icd = new InsertComponentDialog();
        icd.waitForVisible();

        List<String> comps = icd.listComponents();
        icd.selectComponent("AIA COMMONS BOOTSTRAP CONTENT","Image");

        JOptionPane.showMessageDialog(null, comps, "InfoBox: " + "Options", JOptionPane.INFORMATION_MESSAGE);
        d.close();
        d.quit();
    }

    @Test
    public void pagePropertiesTest(){
        startWebDriver();

        NavBar nv = new NavBar();
        nv.waitForTogglePanel();
        nv.selectPageInfoItem("Open Properties");

        PagePropertiesForm pf = new PagePropertiesForm();
        pf.form.waitForVisible(10);
        pf.tabpanel.gotoTab(PagePropertiesForm.Tabs.MOBILE.getText());
        pf.mobileTab.benefitPageCkb.check();
        pf.mobileTab.name.value("This is name");
        pf.mobileTab.discountValue.value("This is discount");
        pf.mobileTab.shortDescription.value("This is short desecription");
        pf.mobileTab.longDescription.set("This is a long description");
        pf.form.done();
        JOptionPane.showMessageDialog(null, "I am done", "InfoBox: " + "Options", JOptionPane.INFORMATION_MESSAGE);
        d.close();
        d.quit();
    }

    @Test
    public void imageSettingsTest(){
        startWebDriver();

        Locator c1 = new Locator("div[data-path*=':content/header/grid/row0/image']", PathType.CSS);
        waitFor(c1);
        c1.element().click();

        EditableToolbar et = new EditableToolbar();
        et.waitForVisible();
        et.optionSettings();
        ImageSettings imgSettings = new ImageSettings();
        imgSettings.form.waitForVisible();
        imgSettings.svgTab.gotoTab();
        imgSettings.imageTab.gotoTab();
        imgSettings.imageTab.imageAsset.upload("C:\\tmp\\base.gif");
        imgSettings.imageTab.title.value("This is image title");
        imgSettings.imageTab.size.width.value("100");
        imgSettings.imageTab.size.height.value("100");
        imgSettings.form.done();

        JOptionPane.showMessageDialog(null, "I am done", "InfoBox: " + "Options", JOptionPane.INFORMATION_MESSAGE);
        d.close();
        d.quit();
    }

    @Test
    public void editorTest(){
        startWebDriver();

        Editor editor = new Editor();
        editor.waitForVisible();
        List<String> dataText = editor.allComponents().stream().map(e -> e.getAttribute("data-path")).collect(Collectors.toList());
        String compText = editor.compHavingAttributeValue("data-path","personal_details").getText();

        JOptionPane.showMessageDialog(null, dataText, "InfoBox: " + "Options", JOptionPane.INFORMATION_MESSAGE);
        d.close();
        d.quit();
    }

    @Test
    public void previewTest(){
        startWebDriver();

        NavBar nv = new NavBar();
        nv.waitForTogglePanel();
        nv.previewMode();

        Preview p = new Preview();
        List<String> dataText = p.mainSubSections().stream().map(e -> e.getText()).collect(Collectors.toList());

        JOptionPane.showMessageDialog(null, dataText, "InfoBox: " + "Options", JOptionPane.INFORMATION_MESSAGE);
        d.close();
        d.quit();
    }

    @Test
    public void navSettingsTest(){
        startWebDriver();

        Locator c2 = new Locator("div[data-path*='content/header/grid/row0/nav']",PathType.CSS);
        waitFor(c2);
        c2.element().click();

        EditableToolbar et = new EditableToolbar();
        et.optionSettings();

        NavSettings nv = new NavSettings();
        nv.form.waitForVisible();
        nv.direction.select("Vertical");
        nv.displayRootOnly.check();

        JOptionPane.showMessageDialog(null, "I am done", "InfoBox: " + "Options", JOptionPane.INFORMATION_MESSAGE);
        d.close();
        d.quit();
    }

    public void waitFor(Locator locator){
        (new WebDriverWait(d,10)).until(ExpectedConditions.visibilityOfElementLocated(locator.by()));
    }
}
