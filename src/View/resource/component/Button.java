package View.resource.component;

import javax.swing.*;
import java.awt.*;

public class Button {
    public static JButton btn(){

        JButton redButton = new JButton("Click Me");
        redButton.setPreferredSize(new Dimension(80, 80));
        redButton.setBackground(Color.ORANGE);

        return redButton;
    }
}