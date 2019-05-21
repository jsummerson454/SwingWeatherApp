package group18.screens;

import group18.backend.Day;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class DailyView {
    private JLabel lbLocation;
    private JButton settingsButton;
    private JScrollPane spDayList;
    public JButton backButton;
    private JButton suggestButton;
    public JPanel main;
    public JPanel dayListPanel;

    public void addSettingsButtonListener(ActionListener mal) {
        settingsButton.addActionListener(mal);
    }

    public DailyView() {
        Dimension buttonSize = new Dimension(50, 50);
        settingsButton.setIcon(new ImageIcon("resources/SettingsIconSmaller.png"));
        settingsButton.setMaximumSize(buttonSize);
        settingsButton.setMinimumSize(buttonSize);
        settingsButton.setPreferredSize(buttonSize);
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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setBackground(new Color(-8928782));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        main.add(panel1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel2.setBackground(new Color(-8928782));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        lbLocation = new JLabel();
        lbLocation.setBackground(new Color(-8928782));
        Font lbLocationFont = this.$$$getFont$$$(null, -1, 28, lbLocation.getFont());
        if (lbLocationFont != null) lbLocation.setFont(lbLocationFont);
        lbLocation.setText("Location");
        panel2.add(lbLocation, BorderLayout.CENTER);
        settingsButton = new JButton();
        settingsButton.setBackground(new Color(-8928782));
        settingsButton.setText("");
        panel2.add(settingsButton, BorderLayout.EAST);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        panel3.setBackground(new Color(-3284494));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel3, gbc);
        spDayList = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(spDayList, gbc);
        dayListPanel = new JPanel();
        dayListPanel.setLayout(new GridBagLayout());
        dayListPanel.setBackground(new Color(-3284494));
        spDayList.setViewportView(dayListPanel);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        panel4.setBackground(new Color(-8928782));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel4, gbc);
        backButton = new JButton();
        backButton.setBackground(new Color(-1842305));
        backButton.setText("Back");
        panel4.add(backButton);
        suggestButton = new JButton();
        suggestButton.setBackground(new Color(-1842305));
        suggestButton.setText("Suggest");
        panel4.add(suggestButton);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return main;
    }
}
