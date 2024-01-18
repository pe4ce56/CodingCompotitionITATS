package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class Bpjs {
    private JPanel nik;
    private JPanel bulan;


    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        nik = Input.input("Nik : ", "text");
        bulan = Input.input("Bulan : ", "text");

        JButton btnTagihanBpjs = Button.btn("Tagihan bpjs", 233, 233, 233);
        tagihanBpjs(btnTagihanBpjs);

        JButton btnBack = Button.btn("Logout", 233, 233, 233);
        back(btnBack);

        form.setLayout( new GridLayout(3, 1) );
        form.add(nik);
        form.add(bulan);

        form.add(btnTagihanBpjs);
        form.add(btnBack);

        return form;
    }

    private void tagihanBpjs(JButton btn){
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