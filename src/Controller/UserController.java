package Controller;

import Config.Instance;
import Model.User;
import Service.UserService;
import View.LoginViewTesting;
import View.RegisterViewTesting;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class UserController {

    private UserService userService;

    public UserController(){
        userService = UserService.getInstance();
    }

    public void login(){
        try {
            LoginViewTesting registerViewTesting = (LoginViewTesting) Instance.getInstance().getView("LoginViewTesting");

            registerViewTesting.index();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String username, String password){
        for(User user: userService.getUsers()){
            if(user.getUsername().equals( username) && Objects.equals(hash(password), hash(password))){
                userService.setUserActive(user);
                return true;
            }
        }
        return false;
    }
    public void register(){

    }

    public boolean register(User user){
        user.setPassword(hash(user.getPassword()));
        userService.addUser(user);
        return true;
    }

    private String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            StringBuilder result = new StringBuilder();
            for (byte b : digest) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
