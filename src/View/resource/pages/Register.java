package View.resource.pages;

import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.Image;

import javax.swing.*;
import java.awt.*;

public class Register{
    public JPanel getContainer(){
        JPanel jPanel = new JPanel( new GridBagLayout() );

//        JPanel jPanel = new JPanel( new GridBagLayout() );
        jPanel.setBackground( new Color(223, 223, 223));

//        JButton btn = Button.btn();
//        d(btn);

        JLabel fotoProfilLabel = Image.img();

        jPanel.add(fotoProfilLabel);

//        jPanel.add( btn, Utils.getGbc() );


        return jPanel;
    }

    private void d(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("dashboard");
        });
    }

}




//package View.component.pages;
//
//import javax.swing.*;
//import java.awt.*;
//
//public class Register extends JFrame {
//
//    public Register() {
//        // Membuat ukuran frame
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        double percentage = 0.95;
//        int widthInPixels = (int) (screenSize.getWidth() * percentage);
//        int heightInPixels = (int) (screenSize.getHeight() * percentage);
//
//        // Membuat label untuk menampilkan informasi
////        JLabel label = new JLabel("Lebar layar: " + screenSize.getWidth() + " pixel, Tinggi layar: " + screenSize.getHeight() + " pixel");
//
//        // Membuat panel untuk dua div
//        JPanel mainPanel = new JPanel(new GridLayout(1, 2)); // 1 baris, 2 kolom
//
//        // Membuat dua div atau panel
//        JPanel panel1 = createCenteredButtonPanel("Button 1");
//        JPanel panel2 = createCenteredButtonPanel("Button 2");
//
//        // Mengatur warna latar belakang untuk membedakan
//        panel1.setBackground(Color.BLUE);
//        panel2.setBackground(Color.GREEN);
//
//        // Menambahkan dua div ke dalam panel utama
//        mainPanel.add(panel1);
//        mainPanel.add(panel2);
//
//        // Menambahkan label dan panel utama ke dalam frame
//        setLayout(new BorderLayout());
////        add(label, BorderLayout.NORTH);
//        add(mainPanel, BorderLayout.CENTER);
//
//        // Pengaturan frame dengan ukuran dalam piksel
//        setSize(widthInPixels, heightInPixels);
//        setTitle("Informasi Layar");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    private JPanel createCenteredButtonPanel(String buttonText) {
//        JPanel panel = new JPanel(new GridBagLayout());
//        JButton button = new JButton(buttonText);
//
//        // Mengatur GridBagConstraints agar tombol berada di tengah
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.anchor = GridBagConstraints.CENTER;
//
//        panel.add(button, gbc);
//        return panel;
//    }
//
//    public static void main(String[] args) {
//        // Membuat objek frame
//        new Register();
//    }
//}