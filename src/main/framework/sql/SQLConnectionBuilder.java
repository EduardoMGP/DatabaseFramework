package main.framework.sql;

import com.sun.istack.internal.NotNull;

import java.util.HashMap;
import java.util.Map;

public class SQLConnectionBuilder {

    protected static Map<String, Connection> connections = new HashMap<>();
    protected static String default_;

    public static void addConnections(@NotNull SQLConnection... connections){
        for(SQLConnection con : connections) {
            if (!SQLConnectionBuilder.connections.containsKey(con.getName())) {
                SQLConnectionBuilder.connections.put(con.getName(), con.getConnection());
                if(default_ == null)
                    default_ = con.getName();
            }
        }
    }

    protected static String getDefaultConnection(){
        return default_;
    }
    protected static Connection getConnection(String name) throws ConnectionException {
        Connection con = connections.get(name);
        if(con == null)
            throw new ConnectionException("A Conexão " + name + " não foi criada");
        else
            return con;
    }

}
