package View.resource.pages;

import View.resource.component.Button;

import javax.swing.*;
import java.awt.*;

public class Auth {
    public JPanel getContainer(){
        JPanel container = new JPanel( new GridBagLayout() );

        JPanel divLeft = new JPanel( new GridBagLayout() );
        divLeft.setBackground(Color.RED);


        JPanel divRight = new JPanel( new GridBagLayout());
        divRight.setBackground(Color.GRAY);

        container.setLayout( new GridLayout(1, 2) );
        container.add(divLeft);
        container.add(divRight);


        return container;
    }
}