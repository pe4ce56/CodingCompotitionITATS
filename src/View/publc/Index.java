package View.publc;

import javax.swing.*;
import java.awt.*;

public class Index{
    public index() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("E-wallet");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//            JPanel mainPanel = new JPanel(new CardLayout());
//            Page1 page1 = new Page1(mainPanel);
//            Page2 page2 = new Page2(mainPanel);

//            mainPanel.add(page1, Page1.NAME);
//            mainPanel.add(page2, Page2.NAME);


            frame.add(mainPanel);

            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}