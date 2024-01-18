package View.publc;

import javax.swing.*;
import java.awt.*;

public class Index {
    private static Index instance;
    private JFrame frame;

    private Index() {
        frame = new JFrame("E-wallet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
    }

    public static synchronized Index getInstance() {
        if (instance == null) {
            instance = new Index();
        }
        return instance;
    }

    public void setComponent(JPanel component) {
        frame.getContentPane().removeAll(); // Menghapus konten sebelumnya
        frame.add(component, BorderLayout.CENTER);
        frame.revalidate(); // Me-revalidate frame untuk menampilkan perubahan
        frame.repaint(); // Me-repaint frame untuk menghindari artefak render
        frame.setVisible(true);
    }
}
