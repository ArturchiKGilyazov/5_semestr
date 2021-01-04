package lobby;

import user.User;

public interface Room_I {

    int getDamage();

     void setDamage(int damage);

     int getGravity();

     void setGravity(int gravity);

     int getSpeed();

     void setSpeed(int speed);

     int getBounce();

     void setBounce(int bounce);

     User getAdmin();

     void setAdmin(User admin);

     ROOM_STATUS getStatus();

     void setStatus(ROOM_STATUS status);

     int getId();

     void AddUser(User user);

     void RemoveUser(User user);

}
