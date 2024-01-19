package View.resource.pages;

import Service.UserService;
import View.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class Dashboard {
    public JPanel getContainer(){

//        JPanel bluePanel = new JPanel();
//        bluePanel.setPreferredSize(new Dimension(80, 80));
//        bluePanel.setBackground(Color.RED);

        JPanel container = new JPanel( new GridBagLayout() );

        container.setLayout( new GridLayout(3, 1) );

        JLabel username = new JLabel("Username : " + UserService.getInstance().getUserActive().getUsername());
        JLabel saldo = new JLabel("Saldo : " + UserService.getInstance().getUserActive().getBalance());

        JPanel wrapPilihan = new JPanel( new GridBagLayout() );

        // set margin
//        divLeft.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnTransfer = new JButton("Transfer");
        JButton btnBeliPulsa = new JButton("Beli pulsa");
        JButton btnTopUpSaldo = new JButton("Top up saldo");

        wrapPilihan.setLayout( new GridLayout(1, 3) );
        wrapPilihan.add(btnTransfer);
        wrapPilihan.add(btnBeliPulsa);
        wrapPilihan.add(btnTopUpSaldo);

        container.add(username);
        container.add(saldo);
        container.add(wrapPilihan);

        return container;
    }

    private void moveToRegister(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("register");
        });
    }
}



// username
// transfer -> milih user
// pulsa -> form nomer karo jumlah
// top up saldo