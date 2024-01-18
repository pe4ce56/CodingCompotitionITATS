import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ComboBox Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            JComboBox<String> comboBox = createComboBox();

            JButton showSelectedButton = new JButton("Show Selected");
            showSelectedButton.addActionListener(e -> {
                String selectedValue = (String) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Selected Item: " + selectedValue);
            });

            panel.add(comboBox);
            panel.add(showSelectedButton);

            frame.getContentPane().add(panel);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JComboBox<String> createComboBox() {
        String[] items = {"Option 1", "Option 2", "Option 3", "Option 4"};
        return new JComboBox<>(items);
    }
}
