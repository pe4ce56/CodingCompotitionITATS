package View;

import Config.Instance;
import Controller.TransactionController;
import Controller.UserController;
import Model.TypeTransactions.TransferBalance;
import Service.UserService;

import javax.swing.*;
import java.awt.*;

public class LoginViewTesting {
    public void index(){
        JFrame frame = new JFrame("ColumnLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button button = new Button("KLIK ME");
        button.addActionListener(e -> {
            try {
                UserController userController = (UserController) Instance.getInstance().getController("UserController");

                if(userController.login("deo","deo")){
                    System.out.println("LOGIN berhasil");

                    TransactionController transactionController = (TransactionController) Instance.getInstance().getController("TransactionController");
                    transactionController.transaction(new TransferBalance(UserService.getInstance().getUsers().get(0),10000));
                    transactionController.transaction(new TransferBalance(UserService.getInstance().getUsers().get(0),10000));

                }else{
                    System.out.println("LOGIN SALAH");
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        frame.getContentPane().add(button);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
