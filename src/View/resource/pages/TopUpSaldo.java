package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class TopUpSaldo {
    private JPanel jumlah;


    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        jumlah = Input.input("jumlah : ", "text");

        JButton btnTopUpSaldo = Button.btn("Top up saldo", 233, 233, 233);
        TopUpSaldo(btnTopUpSaldo);

        JButton btnBack = Button.btn("Logout", 233, 233, 233);
        back(btnBack);

        form.setLayout( new GridLayout(3, 1) );
        form.add(jumlah);

        form.add(btnTopUpSaldo);
        form.add(btnBack);

        return form;
    }

    private void TopUpSaldo(JButton btn){
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