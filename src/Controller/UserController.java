package Controller;

import Config.Instance;
import Model.User;
import Service.UserService;
import View.LoginViewTesting;
import View.RegisterViewTesting;
import View.ViewFactory;

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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(String username, String password){
        for(User user: userService.getUsers()){
            if(user.getUsername().equals( username) && Objects.equals(user.getPassword(), hash(password))){
                userService.setUserActive(user);
                return true;
            }
        }
        return false;
    }
    public void register(){
    }

    public void register(User newUser) throws Exception {
//        checking unique property
        for(User user: userService.getUsers()) {
            if(user.getEmail().equals(newUser.getEmail())){
                throw new Exception("email has been used.");
            }
            if(user.getUsername().equals(newUser.getUsername())){
                throw new Exception("username has been used.");
            }
        }

        newUser.setPassword(hash(newUser.getPassword()));

        userService.addUser(newUser);
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