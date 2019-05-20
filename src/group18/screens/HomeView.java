package group18.screens;


import javax.swing.*;
import java.awt.*;

public class HomeView {
    public JPanel main;

    private JPanel topButtons;
    private JPanel bottomButtons;
    private JPanel mainPanel;

    private JPanel warningsAndPlans;
    private JPanel temperatureAndImage;
    private JPanel imagePanel;

    public JLabel actualTemperature;
    public JLabel feelsLike;

    public JButton weekly;
    public JButton hourly;
    public JButton settings;

    private JLabel titleLabel;
    public JLabel imageIcon;

    private void createUIComponents() {


    }

    public HomeView() {
        Dimension buttonSize = new Dimension(50, 50);
        settings.setIcon(new ImageIcon("resources/SettingsIconSmaller.png"));
        settings.setMaximumSize(buttonSize);
        settings.setMinimumSize(buttonSize);
        settings.setPreferredSize(buttonSize);

        imageIcon.setIcon(new ImageIcon("resources/clear-day.png"));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new HomeView().main);
        frame.setVisible(true);
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
        main.setLayout(new BorderLayout(0, 0));
        bottomButtons = new JPanel();
        bottomButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
        bottomButtons.setBackground(new Color(-8928782));
        main.add(bottomButtons, BorderLayout.SOUTH);
        weekly = new JButton();
        weekly.setBackground(new Color(-1842305));
        weekly.setText("Weekly");
        bottomButtons.add(weekly);
        hourly = new JButton();
        hourly.setBackground(new Color(-1842305));
        hourly.setText("Hourly");
        bottomButtons.add(hourly);
        topButtons = new JPanel();
        topButtons.setLayout(new BorderLayout(0, 0));
        topButtons.setBackground(new Color(-8928782));
        main.add(topButtons, BorderLayout.NORTH);
        titleLabel = new JLabel();
        Font titleLabelFont = this.$$$getFont$$$(null, -1, 28, titleLabel.getFont());
        if (titleLabelFont != null) titleLabel.setFont(titleLabelFont);
        titleLabel.setText("Home");
        topButtons.add(titleLabel, BorderLayout.WEST);
        settings = new JButton();
        settings.setBackground(new Color(-8928782));
        settings.setText("");
        topButtons.add(settings, BorderLayout.EAST);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        main.add(mainPanel, BorderLayout.CENTER);
        warningsAndPlans = new JPanel();
        warningsAndPlans.setLayout(new GridBagLayout());
        mainPanel.add(warningsAndPlans, BorderLayout.SOUTH);
        temperatureAndImage = new JPanel();
        temperatureAndImage.setLayout(new GridBagLayout());
        temperatureAndImage.setBackground(new Color(-4395790));
        mainPanel.add(temperatureAndImage, BorderLayout.CENTER);
        actualTemperature = new JLabel();
        Font actualTemperatureFont = this.$$$getFont$$$(null, -1, 28, actualTemperature.getFont());
        if (actualTemperatureFont != null) actualTemperature.setFont(actualTemperatureFont);
        actualTemperature.setText("T*C");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.25;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        temperatureAndImage.add(actualTemperature, gbc);
        feelsLike = new JLabel();
        Font feelsLikeFont = this.$$$getFont$$$(null, -1, 18, feelsLike.getFont());
        if (feelsLikeFont != null) feelsLike.setFont(feelsLikeFont);
        feelsLike.setText("Feels like T*C");
        feelsLike.setVerticalAlignment(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.25;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        temperatureAndImage.add(feelsLike, gbc);
        imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout(0, 0));
        imagePanel.setBackground(new Color(-4395790));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.weightx = 0.75;
        gbc.weighty = 0.5;
        gbc.fill = GridBagConstraints.BOTH;
        temperatureAndImage.add(imagePanel, gbc);
        imageIcon = new JLabel();
        imageIcon.setText("");
        imagePanel.add(imageIcon, BorderLayout.CENTER);
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
