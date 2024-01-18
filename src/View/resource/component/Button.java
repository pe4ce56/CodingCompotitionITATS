package View.resource.component;

import javax.swing.*;
import java.awt.*;

public class Button {
    public static JButton btn(String teks, int r, int g, int  b){

        JButton btn = new JButton(teks);

        btn.setBackground( new Color(r, g, b) );

        return btn;
    }
}