package com.aia.aem.custom;

import com.aia.aem.components.Field;
import com.aia.aem.components.Form;
import com.aia.aem.components.NumberInput;
import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aadm221 on 20/10/2017.
 */
public class SizeField extends Field<SizeField> {
    public NumberInput width;
    public NumberInput height;

    private String label;
    private ElemDefs elems;
    private class ElemDefs{
        private Locator base = new Locator("//label[text()='"+ label +"']/../div[contains(@class,'coral-Form-field')]",PathType.XPATH);
    }

    protected Locator getBase(){ return elems.base; }

    public SizeField(Locator parent, String label){
        super(parent);
        this.label = label;
        elems = new ElemDefs();
        width = new NumberInput(new ArrayList<Locator>(Arrays.asList(parent,elems.base)),"width");
        height = new NumberInput(new ArrayList<Locator>(Arrays.asList(parent,elems.base)),"height");
    }
    protected SizeField(){}
}
