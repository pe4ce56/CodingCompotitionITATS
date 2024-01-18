package View.resource.component;

import javax.swing.*;
import java.awt.*;

public class Input {
    public static JPanel input(String teksLabel, String type){

        JPanel form = new JPanel( new GridBagLayout() );

        form.setBounds(100,100,500,500);
        JLabel label = new JLabel(teksLabel);

        JComponent input;

        if ("password".equals(type)) {
            input = new JPasswordField("");
        } else {
            input = new JTextField("");
        }

        input.setBounds(0,0, 250, 100);
        form.setLayout( new GridLayout(2, 1) );
        form.add(label);
        form.add(input);

        return form;
    }
}
