package DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyConnection_I {

    boolean execute(String sql) throws SQLException;

    int executeUpdate(String sql) throws SQLException;

    ResultSet executeQuery(String sql) throws SQLException;

    ResultSet getResultSet() throws SQLException;

    void release();

}
