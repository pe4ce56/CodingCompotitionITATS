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

        wrapPilihan.setLayout( new GridLayout(1, 5) );
        // set margin
//        divLeft.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton btnTransfer = new JButton("Transfer");
        moveToTransfer(btnTransfer);

        JButton btnBeliPulsa = new JButton("Beli pulsa");
        moveToBeliPulsa(btnTransfer);
        JButton btnTopUpSaldo = new JButton("Top up saldo");
        moveToTopUpSaldo(btnTopUpSaldo);
        JButton btnHistory = new JButton("History");
        JButton btnLogout = new JButton("Logout");

        wrapPilihan.add(btnTransfer);
        wrapPilihan.add(btnBeliPulsa);
        wrapPilihan.add(btnTopUpSaldo);
        wrapPilihan.add(btnHistory);
        wrapPilihan.add(btnLogout);

        container.add(username);
        container.add(saldo);
        container.add(wrapPilihan);
        container.add(btnLogout);

        return container;
    }

    private void moveToTransfer(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("transfer");
        });
    }

    private void moveToBeliPulsa(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("beliPulsa");
        });
    }

    private void moveToTopUpSaldo(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("topUpSaldo");
        });
    }

    private void logout(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("login");
        });
    }
}