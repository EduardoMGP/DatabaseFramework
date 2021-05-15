package main;

import main.framework.sql.ConnectionException;
import main.framework.sql.SQL;
import main.framework.sql.SQLConnection;
import main.framework.sql.SQLConnectionBuilder;
import main.framework.sql.models.Values;
import main.framework.sql.models.Where;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {

    private static SQL database;
    private static SQL database_aux;
    public static void main(String[] args) throws SQLException, ConnectionException {

        SQLConnectionBuilder.addConnections(
                new SQLConnection("default", "test", "localhost", 3306, "root", "")
                //new SQLConnection("aux", "test_2", "localhost", 3306, "root", "")
        );

        database = new SQL();
        //database_aux = new SQL("aux");

        database.query("create table if not exists user ( " +
                " email varchar(150) not null primary key, " +
                " nome varchar(20) not null, " +
                " idade int default 0 )");

        database.insert("user",
                new Values()
                        .value("nome", "Carlos")
                        .value("email", "carlos.eduardovieiraoliveira12@gmail.com")
                        .value("idade", 21)
        );

        List<Map<String, Object>> result = database.select("user", new Where().where("nome", "Carlos")).map();
        if(result.size() > 0)
            for (Map<String, Object> r : result){
                System.out.println("");
                System.out.println(" Nome > " + r.get("nome"));
                System.out.println(" Idade > " + r.get("idade"));
                System.out.println(" Email > " + r.get("email"));
                System.out.println("");
            }
        database.delete("user", new Where().where("email", "carlos.eduardovieiraoliveira12@gmail.com"));

    }

}
