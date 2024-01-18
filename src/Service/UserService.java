package Service;

import Model.User;

import java.util.ArrayList;

public class UserService {
    private static UserService servicce;
    private ArrayList<User> users;
    private User userActive;

    public UserService() {
        users = new ArrayList<>();
    }
    public static UserService getInstance() {
        if(servicce==null){
            servicce = new UserService();
        }
        return servicce;
    }

    public User getUserActive() {
        return userActive;
    }
    public void setUserActive(User userActive) {
        this.userActive = userActive;
    }
    public void addUser(User user){
        users.add(user);
    }
    public ArrayList<User> getUsers() {
        return users;
    }


}
