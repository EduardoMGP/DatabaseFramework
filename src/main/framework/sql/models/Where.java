package main.framework.sql.models;


public class Where {

    private String where = "";

    public String getWhere(){
        return this.where;
    }

    private Where wherethis(String colum, Object value, String andORor, String... operator){
        if(value == null)
            value = new StringBuilder("null");
        else
        if(value instanceof String || value instanceof Character)
            value = new StringBuilder("'"+value.toString() + "'");

        if (where.equals(""))
            if (operator.length != 1)
                where = " where " + colum + " = " + value.toString();
            else
                where = " where " + colum + " " + operator[0] + " " + value.toString();
        else if (operator.length != 1)
            where += " "+andORor+" " + colum + " = " + value.toString();
        else
            where += " "+andORor+" " + colum + " " + operator[0] + " " + value.toString();
        return this;
    }

    public Where where(String colum, Object value, Operators operator) {
        if(operator.equals(Operators.LIKE))
            return wherethis(colum, "%"+value+"%", "and", operator.operator());
        else
            return wherethis(colum, value, "and", operator.operator());
    }

    public Where where(String colum, Object value) {
        return wherethis(colum, value, "and", Operators.EQUALS.operator());
    }

    public Where orWhere(String colum, Object value, Operators operator) {
        if(operator.equals(Operators.LIKE))
            return wherethis(colum, "%"+value+"%", "or", operator.operator());
        else
            return wherethis(colum, value, "or", operator.operator());
    }
}
