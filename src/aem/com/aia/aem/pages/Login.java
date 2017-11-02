package com.aia.aem.pages;

/**
 * Created by aadm221 on 3/10/2017.
 */
import com.aia.aem.components.Field;
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.By;

public class Login extends Field<Login> {
    public Login(){super();}
    private ElemDefs elems = new ElemDefs();
    private class ElemDefs {
        private Locator base = new Locator("body", PathType.CSS);
        private Locator username = new Locator("username", PathType.ID);
        private Locator password = new Locator("password",PathType.ID);
        private Locator submitButton = new Locator("submit-button",PathType.ID);
    }
    protected Locator getBase(){return elems.base;}

    public void loginWith(String username, String password){
        wd.d.findElement(elems.username.by()).sendKeys(username);
        wd.d.findElement(elems.password.by()).sendKeys(password);
        wd.d.findElement(elems.submitButton.by()).click();
    }
}
