package main.framework.sql.models;

public enum Operators {
    LIKE("like"),
    EQUALS("="),
    IS("is"),
    IS_NOT("is not"),
    IS_MORE_THAN(">"),
    IS_LESS_THAN("<");

    private String operator;
    Operators(String o){
        operator = o;
    }
    public String operator(){
        return operator;
    }
}
