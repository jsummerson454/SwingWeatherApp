package group18.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeView {
    private JButton testGotoDailyButton;
    public JPanel main;

    public void addDailyButtonListener(ActionListener mal) {
        testGotoDailyButton.addActionListener(mal);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        main = new JPanel();
        main.setLayout(new GridBagLayout());
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        main.add(spacer2, gbc);
        testGotoDailyButton = new JButton();
        testGotoDailyButton.setBackground(new Color(-13056754));
        testGotoDailyButton.setForeground(new Color(-4500416));
        testGotoDailyButton.setText("test - goto daily");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main.add(testGotoDailyButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Some stuff");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        main.add(label1, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }
}
