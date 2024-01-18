package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Image;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class Register{
    private JPanel username;
    private JPanel password;
    private JPanel email;

    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        username = Input.input("Username : ", "text");
        password = Input.input("Password : ", "password");
        email = Input.input("Email : ", "text");

        JButton btnMoveToLogin = Button.btn("sudah punya akun?", 233, 233, 233);
        moveToLogin( btnMoveToLogin );

        JButton btnRegister = Button.btn("Register", 233, 233, 233);

//        JLabel fotoProfilLabel = Image.img();



        form.setLayout( new GridLayout(3, 1) );
        form.add(username);
        form.add(password);
        form.add(email);

        JPanel wrapBtn = new JPanel( new GridBagLayout() );
        wrapBtn.add(btnMoveToLogin);
        wrapBtn.add(btnRegister);

        form.add(wrapBtn);




//        jPanel.add( btn, Utils.getGbc() );


        return form;
    }

    private void register(JButton btn){
        btn.addActionListener((event) -> {
            // nilai username
            Input.getInputValue(username);

            // nilai password
            Input.getInputValue(password);

            // nilai email
            Input.getInputValue(email);
        });
    }

    private void moveToLogin(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("login");
        });
    }

}