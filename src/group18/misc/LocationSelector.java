package group18.misc;

import javax.swing.*;
import java.awt.*;

public class LocationSelector {
    public JPanel main;
    public JButton enterButton;
    public JTextField countryField;
    public JTextField cityField;
    public JButton backButton;
    private JLabel countryLabel;
    private JLabel cityLabel;

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
        main.setBackground(new Color(-1381654));
        enterButton = new JButton();
        enterButton.setBackground(new Color(-7171438));
        enterButton.setForeground(new Color(-1));
        enterButton.setText("Enter");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main.add(enterButton, gbc);
        countryField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main.add(countryField, gbc);
        cityField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main.add(cityField, gbc);
        backButton = new JButton();
        backButton.setBackground(new Color(-7171438));
        backButton.setForeground(new Color(-1));
        backButton.setText("Back");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        gbc.weighty = 0.25;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        main.add(backButton, gbc);
        countryLabel = new JLabel();
        countryLabel.setText("Country");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        main.add(countryLabel, gbc);
        cityLabel = new JLabel();
        cityLabel.setText("City");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0.25;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        main.add(cityLabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }
}
