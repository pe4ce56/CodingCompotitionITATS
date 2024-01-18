package View.resource.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Image {
    public static JLabel img(){

        try{

            BufferedImage image = ImageIO.read(new File("src/View/publc/img/authPhoto.png"));
            java.awt.Image resizedImage = image.getScaledInstance(200, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(resizedImage);
            return new JLabel(imageIcon);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}