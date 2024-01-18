package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class TokenListrik {
    private JPanel nomerToken;
    private JPanel namaPemilik;
    private JPanel nomorMeter;

    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        nomerToken = Input.input("jumlah : ", "text");
        namaPemilik = Input.input("Nama pemilik : ", "text");
        nomorMeter = Input.input("Nomor meter : ", "text");

        JButton btnTopUpSaldo = Button.btn("Beli token", 233, 233, 233);
        TopUpSaldo(btnTopUpSaldo);

        JButton btnBack = Button.btn("Logout", 233, 233, 233);
        back(btnBack);

        form.setLayout( new GridLayout(4, 1) );
        form.add(nomerToken);
        form.add(namaPemilik);
        form.add(nomorMeter);

        form.add(btnTopUpSaldo);
        form.add(btnBack);

        return form;
    }

    private void TopUpSaldo(JButton btn){
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