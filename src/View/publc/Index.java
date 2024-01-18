package View.publc;

import View.resource.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Index {
    private static Index instance;
    private JFrame frame;

    private Index() {
        frame = new JFrame("E-wallet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        HashMap<String, Integer> size = Utils.getSizeOfScreen(0.40);

        frame.setSize( size.get("width"), size.get("height") );
        frame.setLocationRelativeTo(null);
    }

    public static synchronized Index getInstance() {
        if (instance == null) {
            instance = new Index();
        }
        return instance;
    }

    public void setContainer(JPanel component) {
        frame.getContentPane().removeAll();
        frame.add(component, BorderLayout.CENTER);
//        frame.revalidate();
//        frame.repaint();
        frame.setVisible(true);
    }
}