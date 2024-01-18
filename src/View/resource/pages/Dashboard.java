package View.resource.pages;

import javax.swing.*;
import java.awt.*;

public class Dashboard {
    public JPanel getComponent(){

        JPanel bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(80, 80));
        bluePanel.setBackground(Color.RED);

        return bluePanel;
    }

}


//
//class Page1 extends JPanel {
//    static final String NAME = "PAGE_1";
//
//    Page1(JPanel mainPanel) {
//        setLayout(new BorderLayout());
//
//        add(new JLabel("This is Page 1"), BorderLayout.CENTER);
//
//        JButton goToPage2Button = new JButton("Go to Page 2");
//        goToPage2Button.addActionListener(e -> {
//            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
//            cardLayout.show(mainPanel, Page2.NAME);
//        });
//
//        add(goToPage2Button, BorderLayout.SOUTH);
//    }
//}
//
//class Page2 extends JPanel {
//    static final String NAME = "PAGE_2";
//
//    Page2(JPanel mainPanel) {
//        setLayout(new BorderLayout());
//
//        add(new JLabel("This is Page 2"), BorderLayout.CENTER);
//
//        JButton goToPage1Button = new JButton("Go to Page 1");
//        goToPage1Button.addActionListener(e -> {
//            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
//            cardLayout.show(mainPanel, Page1.NAME);
//        });
//
//        add(goToPage1Button, BorderLayout.SOUTH);
//    }
//}