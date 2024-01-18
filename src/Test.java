import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Nested Panels Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Mendapatkan ukuran layar
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // Menghitung ukuran frame
            int widthInPixels = (int) (screenSize.getWidth() * 0.5);
            int heightInPixels = 100;

            // Membuat dua JPanel utama
            JPanel panel1 = createNestedPanel("Panel 1");
            JPanel panel2 = createNestedPanel("Panel 2");

            // Mengatur warna latar belakang untuk membedakan
            panel1.setBackground(Color.BLUE);
            panel2.setBackground(Color.GREEN);

            // Menambahkan dua JPanel utama ke dalam frame
            frame.setLayout(new GridLayout(1, 2)); // 1 baris, 2 kolom
            frame.add(panel1);
            frame.add(panel2);

            // Pengaturan frame dengan ukuran dalam piksel
            frame.setSize(widthInPixels, heightInPixels);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    // Fungsi untuk membuat panel bersarang yang berada di tengah
    private static JPanel createNestedPanel(String label) {
        JPanel nestedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel nestedLabel = new JLabel(label);
        nestedPanel.add(nestedLabel);
        return nestedPanel;
    }
}
