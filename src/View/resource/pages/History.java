package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class History {
    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        JPanel wrapBtn = new JPanel( new GridBagLayout() );

        JButton btnBack = Button.btn("Logout", 233, 233, 233);
        back(btnBack);

        form.add(wrapBtn);
        form.add(btnBack);

        return form;
    }

    private void Request(JButton btn){
        btn.addActionListener((event) -> {
//            new ViewFactory().createView("dashboard");
        });
    }

    private void back(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("dashboard");
        });
    }
}