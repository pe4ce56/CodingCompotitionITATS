package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class TopUpGame {
    private JPanel id;
    private JPanel diamond;
    private JPanel priceList;


    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        id = Input.input("Id game : ", "text");
        diamond = Input.input("Diamond : ", "text");

        JButton btnTopUpGame = Button.btn("Top up", 233, 233, 233);
        Transfer(btnTopUpGame);

        JButton btnBack = Button.btn("Logout", 233, 233, 233);
        back(btnBack);

        form.setLayout( new GridLayout(3, 1) );
        form.add(id);
        form.add(diamond);

        form.add(btnTopUpGame);
        form.add(btnBack);

        return form;
    }

    private void Transfer(JButton btn){
        btn.addActionListener((event) -> {
//            new ViewFactory().createView("dashboard");

            // nilai password
//            System.out.println( Input.getInputValue(jumlah) );
        });
    }

    private void back(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("dashboard");
        });
    }
}