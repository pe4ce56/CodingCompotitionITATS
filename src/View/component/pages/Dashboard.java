//package View.component.pages;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Dashboard {
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Simple Swing SPA");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//            JPanel mainPanel = new JPanel(new CardLayout());
//            Page1 page1 = new Page1(mainPanel);
//            Page2 page2 = new Page2(mainPanel);
//
//            mainPanel.add(page1, Page1.NAME);
//            mainPanel.add(page2, Page2.NAME);
//
//            frame.add(mainPanel);
//
//            frame.setSize(300, 200);
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//        });
//    }
//}
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