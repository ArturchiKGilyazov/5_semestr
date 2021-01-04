package DB;

import user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class USER_DB implements USER_DB_I{

    @Override
    public synchronized User GetUser(String android_id) throws SQLException {
        MyConnection_I Connection = DB.getInstance().getConnection();
        String qr = "SELECT * FROM users WHERE android_id like '" + android_id + "';";
        ResultSet result = Connection.executeQuery(qr);
        if(!result.next()){
            DB.getInstance().releaseConnection(Connection);
            CreateUser(android_id);
            return GetUser(android_id);
        } else {
            User user = new User(result.getInt("id"), result.getString("name"));
            user.setMoney(result.getInt("money"));
            user.setTrophies(result.getInt("trophies"));
            user.setCount_win(result.getInt("count_win"));
            user.setCount_loss(result.getInt("count_loss"));
            DB.getInstance().releaseConnection(Connection);
            return user;
        }
    }

    @Override
    public synchronized void SaveUser(User user) throws SQLException {
        MyConnection_I Connection = DB.getInstance().getConnection();
        String qr = "SELECT * FROM user WHERE user_id==" + user.getId() + ";";
        ResultSet result = Connection.executeQuery(qr);
        result.updateInt("money", user.getMoney());
        result.updateInt("trophies", user.getTrophies());
        result.updateInt("count_win", user.getCount_win());
        result.updateInt("count_loss", user.getCount_loss());
        result.updateRow();
        DB.getInstance().releaseConnection(Connection);
    }

    private synchronized boolean CreateUser(String android_id) throws SQLException {
        MyConnection_I Connection = DB.getInstance().getConnection();
        String qr = "INSERT INTO USERS (android_id) VALUES ('" + android_id + "');";
        DB.getInstance().releaseConnection(Connection);
        return Connection.execute(qr);
    }
}
