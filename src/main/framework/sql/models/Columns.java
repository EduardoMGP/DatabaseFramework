package main.framework.sql.models;

public class Columns {

    private String columns = "";

    public String getColums(){
        return this.columns;
    }

    /**
     *
     * @param columnname Name of column
     * @return Columns
     */
    public Columns column(String columnname){
        if(columns.equals(""))
            columns = columnname;
        else
            columns += ", " + columnname;
        return this;
    }
}
