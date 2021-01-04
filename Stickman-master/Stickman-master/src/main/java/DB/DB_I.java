package DB;

public interface DB_I {

    MyConnection_I getConnection();

    void releaseConnection(MyConnection_I connection);

}