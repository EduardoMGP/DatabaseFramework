package main.framework.sql.models;

public class Join {

    public enum JOIN {

        INNER_JOIN("inner join"),
        LEFT_JOIN("left join"),
        RIGHT_JOIN("right join"),
        JOIN("join");

        private String i;

        JOIN(String i) {
            this.i = i;
        }
    }

    private String join = "";

    public String getJoin(){
        return this.join;
    }

    public Join join(String table, String join, JOIN type) {
        this.join += " " + type.i + " " + table + " on " + join;
        return this;
    }


}

