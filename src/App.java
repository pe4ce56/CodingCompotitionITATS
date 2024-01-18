import Config.Instance;
import Controller.TransactionController;
import Controller.UserController;
import Model.TypeTransaction;
import Model.TypeTransactions.Transfer;
import Model.User;
import Service.UserService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class App {

    public static void main(String[] args) {
        Instance app = Instance.getInstance();

        app.instanceController();
        app.instanceView();

        try {
            UserController userController = (UserController) app.getController("UserController");
            /*
                Testing fitur
             */
            userController.register(new User("damai","damai@gmail.com","damai"));
            userController.register(new User("deo","deo@gmail.com","deo"));

            userController.login();
//            userController.login("damai","damai");

            TransactionController transactionController = (TransactionController) app.getController("TransactionController");
            transactionController.transaction(new Transfer(UserService.getInstance().getUsers().get(1),10000));
            transactionController.transaction(new Transfer(UserService.getInstance().getUsers().get(1),10000));
            /*
               END Testing fitur
             */
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}