package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class Transfer {
    private JPanel username;
    private JPanel jumlah;


    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        username = Input.input("Username penerima : ", "text");
        jumlah = Input.input("Jumlah uang : ", "text");

        JButton btnTransfer = Button.btn("Transfer", 233, 233, 233);
        Transfer(btnTransfer);

        JButton btnBack = Button.btn("Logout", 233, 233, 233);
        back(btnBack);

        form.setLayout( new GridLayout(3, 1) );
        form.add(username);
        form.add(jumlah);

        form.add(btnTransfer);
        form.add(btnBack);

        return form;
    }

    private void Transfer(JButton btn){
        btn.addActionListener((event) -> {
//            new ViewFactory().createView("dashboard");

            // nilai password
            System.out.println( Input.getInputValue(jumlah) );
        });
    }

    private void back(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("dashboard");
        });
    }
}