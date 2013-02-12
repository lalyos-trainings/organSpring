package com.acme.organbay;

import java.beans.PropertyEditorSupport;

public class AddressEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] addressParts = text.split(",");
        Address address = new Address(addressParts[2], addressParts[1], addressParts[0], "HUN"); 
        setValue(address);
    }


}
