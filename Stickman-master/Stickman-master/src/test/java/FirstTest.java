import static org.junit.jupiter.api.Assertions.assertEquals;

import DB.USER_DB;
import DB.USER_DB_I;
import org.junit.jupiter.api.Test;
import user.User;

import java.sql.SQLException;

public class FirstTest {


    USER_DB_I db = new USER_DB();
    @Test
    void test(){
        try {
            User user  = db.GetUser("test");
            System.out.println(user.getName());
            System.out.println(user.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
