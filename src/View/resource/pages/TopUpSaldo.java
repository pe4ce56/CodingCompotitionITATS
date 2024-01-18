package View.resource.pages;

import Config.Instance;
import Controller.TransactionController;
import Model.TypeTransactions.Topup;
import View.ViewFactory;
import View.resource.component.Button;
import View.resource.component.FlexBoxLayoutManager;
import View.resource.component.Input;

import javax.swing.*;
import java.awt.*;

public class TopUpSaldo {
    private JPanel jumlah;

    public JPanel getContainer(){
        JPanel form = new JPanel( new FlexBoxLayoutManager(FlexBoxLayoutManager.VERTICAL));
        ((FlexBoxLayoutManager) form.getLayout()).setPadding(new Insets(10,10,10,10));
        ((FlexBoxLayoutManager) form.getLayout()).setGap(10);
        jumlah = Input.input("jumlah : ", "text");
        ((FlexBoxLayoutManager) form.getLayout()).setFillWidth(jumlah, true);
        JPanel wrapButton = new JPanel( new GridBagLayout() );
        wrapButton.setLayout( new GridLayout(1, 2) );

        JButton btnTopUpSaldo = Button.btn("Top up saldo", 233, 233, 233);
        TopUpSaldo(btnTopUpSaldo);

        JButton btnBack = Button.btn("Back", 233, 233, 233);
        BackToDashboard(btnBack);

        wrapButton.add(btnTopUpSaldo);
        wrapButton.add(btnBack);

        form.add(jumlah);
        form.add(wrapButton);
        return form;
    }

    private void BackToDashboard(JButton btnBack) {
        btnBack.addActionListener((event) -> {
            new ViewFactory().createView("dashboard");
        });
    }

    private void TopUpSaldo(JButton btn){
        btn.addActionListener((event) -> {
            long txtjumlah = Long.parseLong(Input.getInputValue(jumlah));
           Topup topup = new Topup(Topup.INDOMART, txtjumlah);

            try {
                TransactionController transactionController = (TransactionController) Instance.getInstance().getController("TransactionController");
                transactionController.transaction(topup);


                JOptionPane.showMessageDialog(null, "Top berhasil dibuat!");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void back(JButton btn){
        btn.addActionListener((event) -> {
            new ViewFactory().createView("dashboard");
        });
    }
}