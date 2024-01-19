package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class BeliPulsa {
    private JPanel nomer;
    private JPanel jumlah;

    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        nomer = Input.input("Nomer handphone : ", "text");
        jumlah = Input.input("jumlah pulsa : ", "text");

        JButton btnBeliPulsa = Button.btn("BeliPulsa", 233, 233, 233);
        BeliPulsa(btnBeliPulsa);

        form.setLayout( new GridLayout(3, 1) );
        form.add(nomer);
        form.add(jumlah);

        JPanel wrapBtn = new JPanel( new GridBagLayout() );

        form.add(wrapBtn);

        return form;
    }

    private void BeliPulsa(JButton btn){
        btn.addActionListener((event) -> {
//            new ViewFactory().createView("dashboard");

            // nilai username
            System.out.println( Input.getInputValue(nomer) );

            // nilai password
            System.out.println( Input.getInputValue(jumlah) );
        });
    }
}