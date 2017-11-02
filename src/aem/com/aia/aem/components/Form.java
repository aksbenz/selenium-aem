package com.aia.aem.components;

/**
 * Created by aadm221 on 3/10/2017.
 */

import com.aia.aem.enums.PathType;
import com.aia.aem.utils.Locator;

public class Form extends Field<Form> {
    public Form(Locator parent){
        super(parent);
    }
    private ElementDefinitions elems = new ElementDefinitions();

    private class ElementDefinitions {
        private Locator base = new Locator("coral-Form-field",PathType.CSS);
    }

    protected Locator getBase(){
        return elems.base;
    }
}
