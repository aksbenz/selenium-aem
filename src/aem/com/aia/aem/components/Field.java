package com.aia.aem.components;

import com.aia.aem.utils.Locator;
import com.aia.aem.utils.WD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by aadm221 on 20/10/2017.
 */
public abstract class Field<T> {
    protected WD wd;
    protected List<Locator> parent;

    protected abstract Locator getBase();

    /***
     * Constructor for a Field having a chain of parents
     * @param parent List of parent Locators in order. Top most parent is index 0.
     */
    public Field(List<Locator> parent){
        wd = WD.get();
        this.parent = parent;
    }

    /***
     * Constructor for a Field with only 1 parent
     * @param parent Parent Locator
     */
    public Field(Locator parent){
        wd = WD.get();
        this.parent = Collections.singletonList(parent);
    }

    /***
     * Constructor for a Field with no parent
     */
    public Field(){
        wd = WD.get();
        this.parent = new ArrayList<>();
    }

    protected WebElement getElement(){
        WebElement e;
        Locator base = getBase();

        if (base == null)
            throw new RuntimeException("base path of this Field is not set. Please return proper value in getBase");

        if (parent != null && !parent.isEmpty()){
            WebElement p = wd.d.findElement(parent.get(0).by());
            for (int i=1; i < parent.size();i++) {
                p = p.findElement(parent.get(i).by());
            }
            e = p.findElement(base.by());
        }
        else
            e = wd.d.findElement(base.by());

        return e;
    }

    /***
     * Wait for Field to be visible in provided seconds.
     * Checks complete parent heirarchy for visibility
     * @param seconds Seoonds to wait
     * @return This
     */
    public T waitForVisible(int seconds){
        wd.wait.until((WebDriver dr) -> getElement());
        return (T)this;
    }

    /***
     * Wait for Field to be visible with Timeout set while initializing
     * Checks complete parent heirarchy for visibility
     * @return This
     */
    public T waitForVisible(){return waitForVisible(10);}

    /***
     * Wait for field to be NOT visible within Timeout seconds
     * Checks complete parent heirarchy for non-visibility
     * @param seconds Seconds to wait
     * @return This
     */
    public T waitForNotVisible(int seconds){
        Locator base = getBase();
        wd.wait.until(ExpectedConditions.invisibilityOfElementLocated(getBase().by()));
        wd.wait.until((WebDriver dr)->{
            try {
                if (parent != null && !parent.isEmpty()) {
                    WebElement p = wd.d.findElement(parent.get(0).by());
                    for (int i = 1; i < parent.size(); i++) {
                        p = p.findElement(parent.get(i).by());
                    }
                    return !p.findElement(base.by()).isDisplayed();
                } else
                    return !wd.d.findElement(base.by()).isDisplayed();
            } catch(Exception e){return true;}
        });
        return (T)this;
    }

    /***
     * Wait for field to be NOT visible within Timeout set in initialization
     * Checks complete parent heirarchy for non-visibility
     * @return This
     */
    public T waitForNotVisible(){return waitForNotVisible(10);}

    protected T waitFor(Locator l, int seconds){
        wd.wait.until(ExpectedConditions.visibilityOfElementLocated(l.by()));
        return (T)this;
    }

    /***
     * Waits for Locator with Timeout set while initializing or default
     * @param l Locator
     * @return This
     */
    protected T waitFor(Locator l){return waitFor(l,10);}

    /***
     * Get the WebElement object for this field
     * @return WebElement
     */
    public WebElement element(){
        return getElement();
    }

    /***
     * Get single Child element of this Field, found by childPath Locator
     * @param childPath: Locator of child element with respect to path of parent
     * @return WebElement
     */
    public WebElement child(Locator childPath){
        return getElement().findElement(childPath.by());
    }

    /***
     * Gets single child element for the provided Parent Locator
     * @param parentPath Absolute Locator for Parent Element, irrespective of current fields locator
     * @param childPath Locator of child element with respect to Parent Locator provided
     * @return WebElement
     */
    public WebElement child(Locator parentPath,Locator childPath){
        return wd.d.findElement(parentPath.by()).findElement(childPath.by());
    }

    /***
     * All child elements of this Field, found by childPath Locator
     * @param childPath Child Locator
     * @return WebElement
     */
    public List<WebElement> children(Locator childPath){
        return getElement().findElements(childPath.by());
    }

    /***
     * Get single child element of this Field, located by childrenPath and filtered by text
     * @param childrenPath Locator for multiple child elements
     * @param text Exact Text Content to filter child elements. Selects First match.
     * @return WebElement. Throws No Such Element Exception
     */
    public WebElement childByText(Locator childrenPath, String text){
        return children(childrenPath).stream().filter(c -> c.getText().equals(text)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /***
     * Get single child element for the provided Parent WebElement, located by childrenPath and filtered by text
     * @param parent Absolute Locator for Parent Element, irrespective of current fields locator
     * @param childrenPath Locator for multiple child elements
     * @param text Exact Text Content to filter child elements. Selects First match.
     * @return WebElement. Throws No Such Element Exception
     */
    public WebElement childByText(WebElement parent, Locator childrenPath, String text){
        return parent.findElements(childrenPath.by()).stream().filter(c -> c.getText().equals(text)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /***
     * Get single child element for the provided Parent Locator, located by childrenPath and filtered by text
     * @param parent Absolute Locator for Parent Element, irrespective of current fields locator
     * @param childrenPath Locator for multiple child elements
     * @param text Exact Text Content to filter child elements. Selects First match.
     * @return WebElement. Throws No Such Element Exception
     */
    public WebElement childByText(Locator parent, Locator childrenPath, String text){
        return wd.d.findElement(parent.by()).findElements(childrenPath.by()).stream().filter(c -> c.getText().equals(text)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /***
     * Get the Parent WebElement located by Parent Locator, if parent locator not present, then immediate parent node of this field
     * @return WebElement
     */
    public WebElement parent(){
        if (parent != null && !parent.isEmpty()) {
            WebElement p = wd.d.findElement(parent.get(0).by());
            for (int i = 1; i < parent.size(); i++) {
                p = p.findElement(parent.get(i).by());
            }
            return p;
        }
        else
            return wd.d.findElement(getBase().by()).findElement(By.xpath("./.."));
    }

    public List<Locator> parentLocators(){
        return parent;
    }

    /***
     * Get the Locator for this Field
     * @return Fields Locator
     */
    public Locator path(){
        return getBase();
    }

    /***
     * Get the Locator for this Field
     * @return Fields Locator
     */
    public Locator locator(){
        return getBase();
    }
}
