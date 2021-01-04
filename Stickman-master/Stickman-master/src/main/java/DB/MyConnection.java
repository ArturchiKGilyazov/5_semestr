package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection implements MyConnection_I{

    private final Connection Connection;
    private Statement statement = null;
    MyConnection(Connection connection){
        Connection = connection;
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        if(statement == null) {
            try {
                statement = Connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return statement.execute(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        if(statement == null) {
            try {
                statement = Connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return statement.executeUpdate(sql);
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        if(statement == null) {
            try {
                statement = Connection.createStatement();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return statement.executeQuery(sql);
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        if(statement == null) return null;
        return statement.getResultSet();
    }

    public void release(){
        if(statement==null) return;
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        statement = null;
    }

}
