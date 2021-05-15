package main.framework.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectResult {

    protected String lastSql;
    protected String con;
    protected SelectResult(String sql, String con){
        this.lastSql = sql;
        this.con = con;
    }

    /**
     * Return the last query executed in the database
     * @return String
     */
    public String getLastQuery(){
        return lastSql;
    }

    /**
     * Returns a search in the database in the form of a List
     * @return List<Map<String, Object>>
     * @throws SQLException
     */
    public List<Map<String, Object>> map() throws SQLException, ConnectionException {
        ResultSet r = SQLConnectionBuilder.getConnection(con).execSelect(getLastQuery());
        Map<String, Object> colums;
        List<Map<String, Object>> results = new ArrayList<>();
        ResultSetMetaData meta;
        while (r.next()){
            meta = r.getMetaData();
            colums = new HashMap<>();
            for (int i = 1; i <= meta.getColumnCount(); i++)
                colums.put(meta.getColumnName(i), r.getObject(i));
            results.add(colums);
        }
        r.close();
        return results;
    }

    /**
     * Returns a database search in the standard java ResultSet format
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet result() throws SQLException, ConnectionException {
        return SQLConnectionBuilder.getConnection(con).execSelect(getLastQuery());
    }

    /*public int numRows() throws SQLException {
        ResultSet r = SQLBuilder.con.execSelect(getQuery());
        int i = 0;
        while(r.next())
            i++;
        return i;
    }*/

}
