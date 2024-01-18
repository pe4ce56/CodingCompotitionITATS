package View.resource.layout;

import javax.swing.*;
import java.awt.*;

public abstract class MainFrame extends JFrame {
    public MainFrame(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double percentage = 0.95;
        int widthInPixels = (int) (screenSize.getWidth() * percentage);
        int heightInPixels = (int) (screenSize.getHeight() * percentage);
    }
}