package main.framework.sql;


import java.sql.SQLException;

public class Query {

    protected String lastSql;
    protected int rowaffected = 0;
    protected Object key = null;

    protected Query(String sql, String con) throws SQLException, ConnectionException {
        this.lastSql = sql;
        Object[] return_ = SQLConnectionBuilder.getConnection(con).exec(this.lastSql);
        rowaffected = Integer.parseInt(return_[0].toString());
        key = return_[1];
    }

    /**
     * Return the last query executed in the database
     * @return String
     */
    public String lastquery(){
        return lastSql;
    }

    /**
     * Returns the number of rows in the database that have changed
     * @return int
     */
    public int affectedRows(){
        return this.rowaffected;
    }

    public Object key(){
        return this.key;
    }

}
