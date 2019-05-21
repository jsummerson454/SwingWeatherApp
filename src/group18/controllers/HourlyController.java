package group18.controllers;

import group18.Application;
import group18.Main;
import group18.backend.Day;
import group18.backend.Hour;
import group18.backend.Screen;
import group18.models.HourlyModel;
import group18.models.SettingsModel;
import group18.screens.DailyView;
import group18.screens.DayPanel;
import group18.screens.HourlyPanels;
import group18.screens.HourlyView;
import group18.api.WeatherAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class HourlyController {
    private HourlyView view;
    private HourlyModel model;
    private SettingsModel settingsModel;
    private List<HourlyPanels> hourlyPanels = new ArrayList<>();

    public HourlyController(SettingsModel settingsModel, HourlyView view) {
        this.view = view;
        this.settingsModel = settingsModel;

        initModel();
        view.addSettingsButtonListener(a ->
        {
            Main.app.addAScreen(Screen.hourly);
            Main.app.setViewSettings();
        });

        view.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.backAScreen();
            }
        });
        addHourlyForecast(model.getHourlyList());
    }

    private void initModel(){
        model = new HourlyModel();
        model.loadHourlyForecast();
//        System.out.println("Hi");
    }

    public void addHourlyForecast(List<Hour> HourList)
    {
        hourlyPanels.clear();

        GridBagLayout layout = new GridBagLayout();
        view.spHourPanel.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        int y = 0;

        for (Hour hour : HourList)
        {
            HourlyPanels hourPanel = new HourlyPanels(hour);
            constraints.gridy = y++;
            hourPanel.main.setBorder(BorderFactory.createLineBorder(Color.black));
            view.spHourPanel.add(hourPanel.main, constraints);
            hourPanel.main.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);

//                    TODO: OPEN THE Hourly Screen
                    System.out.println("Opening for day: " + hour.getDayOfMonth());

                }
            });

//            TODO
//            hourPanel.lbCallendarIcon.setIcon();
//            hourPanel.lbWeatherIcon.setIcon();
            ImageIcon imageIcon = Application.getWeatherIcon(hour.getWeatherIconType()); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);
            hourPanel.lbWeatherIcon.setText("");
            hourPanel.lbWeatherIcon.setIcon(imageIcon);
            hourPanel.lbDate.setText("Time: \n" + Integer.toString(hour.getHour()) + ":00");
            hourPanel.lbHumidity.setText("Humidity: \n" + Double.toString(hour.getHumidity()) + "%");
            hourPanel.lbFeelslike.setText("Feels like: \n" + settingsModel.getInUnits(hour.getApparentTemperature()));
            hourPanel.lbDegrees.setText("Temp: \n" + settingsModel.getInUnits(hour.getTemperature()));
            hourPanel.main.setVisible(true);
            hourlyPanels.add(hourPanel);


        }


    }

    public void updateTemperatureLabels()
    {
        hourlyPanels.forEach(hourPanel ->
        {
            hourPanel.lbDegrees.setText("Temp: \n" + settingsModel.getInUnits(hourPanel.getHour().getTemperature()));
            hourPanel.lbFeelslike.setText("Feels like: \n" + settingsModel.getInUnits(hourPanel.getHour().getApparentTemperature()));
        });
    }


}
