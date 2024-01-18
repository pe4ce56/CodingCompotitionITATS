package View.resource.pages;

import javax.swing.*;
import java.awt.*;

public class Dashboard {
    public JPanel getContainer(){

        JPanel bluePanel = new JPanel();
        bluePanel.setPreferredSize(new Dimension(80, 80));
        bluePanel.setBackground(Color.RED);

        return bluePanel;
    }

}