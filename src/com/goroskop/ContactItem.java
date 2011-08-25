package com.goroskop;

import java.util.HashMap;

public class ContactItem extends HashMap<String, Object>{
    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";
    public static final String PHONE = "phone";
    
    public ContactItem(String name, int icon) {
        super();
        super.put(NAME, name);
        super.put(PHONE, icon);
    }   
}
