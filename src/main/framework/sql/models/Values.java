package main.framework.sql.models;

import com.sun.istack.internal.NotNull;

public class Values {

    private String tables = "";
    private String values = "";

    public String getValue(){
        return "(" + this.tables + ") values (" + values + ")";
    }

    public Values value(@NotNull String key, Object value){
        if(value == null)
            value = new StringBuilder("null");
        if(value instanceof String)
            value = new StringBuilder("'"+value.toString()+"'");
        if(tables.equals("")) {
            tables = key;
            values = value.toString();
        } else {
            tables += ", " + key;
            values += ", " + value.toString();
        }

        return this;
    }

}
