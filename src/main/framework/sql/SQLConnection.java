package main.framework.sql;

import java.sql.SQLException;

public class SQLConnection {

    private String name;
    private Connection con;

    public SQLConnection(String name, String DBNAME, String IP, int PORT, String USER, String PASSWORD) throws SQLException {
        this.con = new Connection(DBNAME, USER, PASSWORD, IP, PORT);
        this.name = name;
    }

    protected String getName(){
        return this.name;
    }
    protected Connection getConnection(){
        return this.con;
    }
}
