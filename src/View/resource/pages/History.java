package View.resource.pages;

import View.resource.component.Button;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class History {
    public JPanel getContainer(){
        JPanel form = new JPanel( new GridBagLayout() );
        form.setBackground( new Color(223, 223, 223));

        JPanel wrapBtn = new JPanel( new GridBagLayout() );

        form.add(wrapBtn);

        return form;
    }

    private void Request(JButton btn){
        btn.addActionListener((event) -> {
//            new ViewFactory().createView("dashboard");
        });
    }
}