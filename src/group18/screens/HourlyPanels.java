package group18.screens;

import javax.swing.*;
import java.awt.*;

public class HourlyPanels {
    private JLabel lbDate;
    private JLabel lbDegrees;
    private JLabel lbWeatherIcon;
    private JLabel lbCallendarIcon;
    private JButton addEventButton;

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
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(spacer1, gbc);
        addEventButton = new JButton();
        addEventButton.setAlignmentY(0.8f);
        addEventButton.setMaximumSize(new Dimension(100, 100));
        addEventButton.setMinimumSize(new Dimension(100, 100));
        addEventButton.setPreferredSize(new Dimension(30, 30));
        addEventButton.setRequestFocusEnabled(false);
        addEventButton.setRolloverEnabled(false);
        addEventButton.setSelected(false);
        addEventButton.setText("+ Add Event");
        addEventButton.setVerifyInputWhenFocusTarget(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(addEventButton, gbc);
        lbDegrees = new JLabel();
        lbDegrees.setPreferredSize(new Dimension(50, 32));
        lbDegrees.setText("Degrees");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel1.add(lbDegrees, gbc);
        lbDate = new JLabel();
        lbDate.setPreferredSize(new Dimension(29, 40));
        lbDate.setText("Time");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel1.add(lbDate, gbc);
        lbWeatherIcon = new JLabel();
        lbWeatherIcon.setMinimumSize(new Dimension(60, 16));
        lbWeatherIcon.setPreferredSize(new Dimension(70, 16));
        lbWeatherIcon.setText("Feels like");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);
        panel1.add(lbWeatherIcon, gbc);
        lbCallendarIcon = new JLabel();
        lbCallendarIcon.setPreferredSize(new Dimension(140, 16));
        lbCallendarIcon.setText("WeatherIcon");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 0, 5, 10);
        panel1.add(lbCallendarIcon, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Humidity");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label1, gbc);
    }
}
