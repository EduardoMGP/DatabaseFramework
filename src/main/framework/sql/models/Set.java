package main.framework.sql.models;


public class Set {

    private String update = "";

    public String getSet(){
        return this.update;
    }

    public Set set(String key, Object value){
        if(value == null)
            value = new StringBuilder("NULL");
        if(value instanceof String || value instanceof Character)
            value = new StringBuilder("'"+value+"'");
        if(update.equals(""))
            update = key + " = " + value;
        else
            update += ", " + key + " = " + value;
        return this;
    }

}
