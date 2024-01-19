package View;

import javax.swing.*;
import java.awt.*;

public class RegisterViewTesting {

    public void index(){
        JFrame frame = new JFrame("ColumnLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button button = new Button("Register");
        button.addActionListener(e -> {
            try {


            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        frame.getContentPane().add(button);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
