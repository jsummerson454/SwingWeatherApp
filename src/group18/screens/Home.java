package group18.screens;


import javax.swing.*;
import java.awt.*;

public class Home {
    public JPanel homePanel;

    private JPanel topButtons;
    private JPanel bottomButtons;
    private JPanel mainPanel;

    private JPanel warningsAndPlans;
    private JPanel temperatureAndImage;
    private JPanel image;

    private JLabel actualTemperature;
    private JLabel feelsLike;

    private JPanel weather;

    private JButton weekly;
    private JButton hourly;
    private JButton settings;
    private JLabel titleLabel;

    private void createUIComponents() {


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new Home().homePanel);
        frame.setVisible(true);
    }

}
