package managers;

import server.Updatable_I;
import user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class UserManager implements Updatable_I, UserManager_I{

    /*Singleton*/
    private static final UserManager Instance = new UserManager();
    public static UserManager_I getInstance(){ return Instance;};
    public UserManager(){}

    //LIST - хранит всех онлайн юзеров
    private final Map<Integer, User> OnlineUsers = new HashMap<>();

    @Override
    //Добавляет юзера в список онлайн юзеров
    public void AddToOnline(User user){

    }

    @Override
    //Возвращает юзера если он онайн иначе кидает exceptions.NoUserException
    public User GetUser(int user_id) throws NoSuchElementException {
        return OnlineUsers.entrySet().stream().filter(e -> e.getKey().equals(user_id)).findFirst().get().getValue();
    }


    public User GetUser(String android_id){
        return null;
    }

    //Вызывается каждый раз когда user.User подключается к серверу -> на основании android_id создает юзера, добавляет в список онлайн
    public void ClientConnected(String android_id){
        //go to database -> create user
        //add to online
    }

    //Вызывается каждый раз когда user отключаетс от сервера -> сохраняет юзера в базу данных, удаляет из списка онлайн
    void ClientDisconnected(Integer user_id){
        //search in online -> remove from online
        //rewrite to database
    }

    //Делает запрос в бд на основании ответа создает юзера
    private User CreateUser(String adroid_id){

        return null;
    }

    @Override
    public void update() {

    }
}

