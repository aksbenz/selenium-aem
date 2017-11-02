package com.aia.aem.components;

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;

/**
 * Created by aadm221 on 20/10/2017.
 */
public class FileUpload extends Field<FileUpload>{
    public FileUpload(Locator parent, String label){
        super(parent);
        this.label = label;
        elems = new ElemDefs();
    }
    private String label;
    private ElemDefs elems;

    private class ElemDefs{
        private Locator base = new Locator("//label[@class='coral-Form-fieldlabel'][text()='"+ label +"']/..//a/input", PathType.XPATH);
    }
    protected Locator getBase(){
        return elems.base;
    }

    /***
     * Upload a file from system
     * @param filePath Absolute File Path on current system. Use double \\ for windows
     * @return This
     */
    public FileUpload upload(String filePath){
        getElement().sendKeys(filePath);
        return this;
    }
}