package group18.screens;

import javax.swing.*;
import java.awt.*;

public class Notification {
    public JPanel main;
    public JLabel tempLabel;
    public JLabel suggestionLabel;

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
        main.setBackground(new Color(-1));
        tempLabel = new JLabel();
        tempLabel.setBackground(new Color(-1));
        tempLabel.setText("It's cold!");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        main.add(tempLabel, gbc);
        suggestionLabel = new JLabel();
        suggestionLabel.setText("Consider bringing a coat");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        main.add(suggestionLabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }
}
