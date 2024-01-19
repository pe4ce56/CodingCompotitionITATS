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
//        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
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
        frame.getContentPane().removeAll(); // Menghapus konten sebelumnya
        frame.add(component, BorderLayout.CENTER);
//        frame.revalidate(); // Me-revalidate frame untuk menampilkan perubahan
        frame.repaint(); // Me-repaint frame untuk menghindari artefak render
        frame.setVisible(true);
    }
}