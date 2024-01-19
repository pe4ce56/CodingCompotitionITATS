package View.resource.pages;

import Config.Instance;
import Controller.UserController;
import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Image;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class Login{

    private JPanel username;
    private JPanel password;

    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        username = Input.input("Username : ", "username");
        password = Input.input("Password : ", "password");

        JButton btnMoveToRegister = Button.btn("belum punya akun?", 233, 233, 233);
        moveToRegister( btnMoveToRegister );

        JButton btnLogin = Button.btn("Login", 233, 233, 233);
        login(btnLogin);

        form.setLayout( new GridLayout(3, 1) );
        form.add(username);
        form.add(password);

        JPanel wrapBtn = new JPanel( new GridBagLayout() );

        wrapBtn.add(btnMoveToRegister);
        wrapBtn.add(btnLogin);

        form.add(wrapBtn);

//        jPanel.add( btn, Utils.getGbc() );


        return form;
    }

    private void moveToRegister(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("register");
        });
    }

    private void login(JButton btn){
        btn.addActionListener((event) -> {
            try {

                String usernameTxt = Input.getInputValue(username);
                String passwordTxt = Input.getInputValue(password);

                if(((UserController)Instance.getInstance().getController("UserController")).login(usernameTxt,passwordTxt))
                    new ViewFactory().createView("dashboard");
                else
                    JOptionPane.showMessageDialog(null, "Wrong username/password!");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}