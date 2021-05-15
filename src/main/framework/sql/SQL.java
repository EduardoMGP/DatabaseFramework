package main.framework.sql;

import com.sun.istack.internal.NotNull;
import main.framework.sql.models.*;

import java.sql.SQLException;

public class SQL {

    private String connection_name = null;
    public SQL(String connection_name){
        this.connection_name = connection_name;
    }

    public SQL(){
        this.connection_name = SQLConnectionBuilder.getDefaultConnection();
    }

    public SelectResult select(Columns columns, @NotNull String tablename, @NotNull Join join, @NotNull Where where) throws ConnectionException {
        String sql = "select " + columns.getColums() + " from " + tablename + join.getJoin() + where.getWhere();
        return new SelectResult(sql, connection_name);
    }

    public SelectResult select(Columns columns, @NotNull String tablename, @NotNull Where where) throws ConnectionException {
        String sql = "select " + columns.getColums() + " from " + tablename +  where.getWhere();
        return new SelectResult(sql, connection_name);
    }

    public SelectResult select(Columns columns, @NotNull String tablename) throws ConnectionException {
        String sql = "select " + columns.getColums() + " from " + tablename;
        return new SelectResult(sql, connection_name);
    }

    public SelectResult select(@NotNull String tablename, @NotNull Where where) throws ConnectionException {
        String sql = "select * from " + tablename + where.getWhere();
        return new SelectResult(sql, connection_name);
    }

    public SelectResult select(@NotNull String tablename, @NotNull Join join, @NotNull Where where) throws ConnectionException {
        String sql = "select * from " + tablename + join.getJoin() + where.getWhere();
        return new SelectResult(sql, connection_name);
    }

    public SelectResult select(@NotNull String tablename, @NotNull Join join) throws ConnectionException {
        String sql = "select * from " + tablename + join.getJoin();
        return new SelectResult(sql, connection_name);
    }

    public SelectResult select(@NotNull String tablename) throws ConnectionException {
        String sql = "select * from " + tablename;
        return new SelectResult(sql, connection_name);
    }

    /**
     * Recommended to perform a search by passing a manual query
     * @param query Query containing the main.framework.sql statement
     * @return SelectResult
     * @throws ConnectionException
     */
    public SelectResult select_query(@NotNull String query) throws ConnectionException {
        return new SelectResult(query, connection_name);
    }


    // INSERT
    public Query insert(@NotNull String tablename, @NotNull Values values) throws ConnectionException, SQLException {
        String sql = "insert into " + tablename + " " + values.getValue();
        return new Query(sql, connection_name);
    }


    // DELETE
    public Query delete(@NotNull String tablename, @NotNull Where where) throws ConnectionException, SQLException {
        String sql = "delete from " + tablename + where.getWhere();
        return new Query(sql, connection_name);
    }

    public Query delete(@NotNull String tablename, @NotNull Join join, @NotNull Where where) throws ConnectionException, SQLException {
        String sql = "delete from " + tablename + join.getJoin() + where.getWhere();
        return new Query(sql, connection_name);
    }

    public Query delete(@NotNull String tablename) throws ConnectionException, SQLException {
        String sql = "delete from " + tablename;
        return new Query(sql, connection_name);
    }

    public Query delete(@NotNull String tablename, @NotNull Join join) throws ConnectionException, SQLException {
        String sql = "delete from " + tablename + join.getJoin();
        return new Query(sql, connection_name);
    }


    //UPDATE
    public Query update(@NotNull String tablename, @NotNull Set set, @NotNull Where where) throws ConnectionException, SQLException {
        String sql = "update " + tablename + " set " + set.getSet() + where.getWhere();
        return new Query(sql, connection_name);
    }

    public Query update(@NotNull String tablename, @NotNull Set set) throws ConnectionException, SQLException {
        String sql = "update " + tablename + " set " + set.getSet();
        return new Query(sql, connection_name);
    }

    public Query update(@NotNull String tablename, @NotNull Set set, @NotNull Join join) throws ConnectionException, SQLException {
        String sql = "update " + tablename + " set " + set.getSet() + join.getJoin();
        return new Query(sql, connection_name);
    }

    public Query update(@NotNull String tablename, @NotNull Set set, @NotNull Join join, @NotNull Where where) throws ConnectionException, SQLException {
        String sql = "update " + tablename + " " + set.getSet() + join.getJoin() + where.getWhere();
        return new Query(sql, connection_name);
    }

    /**
     * Recomendado para realizar alteracoes no banco de dados que não terão retorno passando uma consulta manual
     * @param query Query containing the main.framework.sql statement
     * @return Query
     * @throws ConnectionException
     * @throws SQLException
     */
    public Query query(@NotNull String query) throws ConnectionException, SQLException {
        return new Query(query, connection_name);
    }

}
