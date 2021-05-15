package main.framework.sql;

import java.sql.*;

public class Connection {

    private java.sql.Connection con;
    private String USER;
    private String DBNAME;
    private String PASSWORD;
    private String HOST;
    private int PORT;


    protected Connection(String DBNAME, String USER, String PASSWORD, String HOST, int PORT) throws SQLException {
        this.DBNAME = DBNAME;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        this.HOST = HOST;
        this.PORT = PORT;
        getCon();
    }

    private java.sql.Connection getCon() throws SQLException {
        String url = "jdbc:mysql://"+HOST+"/"+DBNAME;
        if (con == null)
            con = DriverManager.getConnection(url, USER, PASSWORD);
        else
        if(con.isClosed())
            con = DriverManager.getConnection(url, USER, PASSWORD);
        else
        if(!con.isValid(3000)) {
            con.close();
            con = DriverManager.getConnection(url, USER, PASSWORD);
        }

        return con;
    }

    protected ResultSet execSelect(String sql) throws SQLException {
        return getCon().createStatement().executeQuery(sql);
    }

    protected Object[] exec(String sql) throws SQLException {
        PreparedStatement pre = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        Object[] returns = new Object[2];
        returns[0] = pre.executeUpdate();
        ResultSet result = pre.getGeneratedKeys();
        if(result.next()){
            returns[1] = result.getObject("GENERATED_KEY");
        }
        pre.close();
        return returns;
    }

    protected void close() throws SQLException {
        getCon().close();
    }
}
