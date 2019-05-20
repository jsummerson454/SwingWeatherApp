package group18.controllers;

import group18.Application;
import group18.Main;
import group18.api.WeatherAPI;
import group18.backend.Day;
import group18.backend.Screen;
import group18.models.DailyModel;
import group18.models.SettingsModel;
import group18.screens.DailyView;
import group18.screens.DayPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DailyController {
    private DailyView view;
    private DailyModel model;
    private SettingsModel settingsModel;

    public DailyController(SettingsModel settingsModel, DailyView view) {
        this.view = view;
        this.settingsModel = settingsModel;

        initModel();
        view.addSettingsButtonListener(a ->
        {
            Main.app.addAScreen(Screen.daily);
            Main.app.setViewSettings();
        });

        view.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.app.backAScreen();
            }
        });

        addDailyForecast(model.getDayList());

    }


    private void initModel()
    {
        model = new DailyModel();
        model.loadDailyForecast();
    }

    public void addDailyForecast(List<Day> dayList)
    {
        GridBagLayout layout = new GridBagLayout();
        view.dayListPanel.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        int y = 0;


        for (Day day : dayList)
        {
            DayPanel dayPanel = new DayPanel();
            constraints.gridy = y++;
            dayPanel.main.setBorder(BorderFactory.createLineBorder(Color.black));
            view.dayListPanel.add(dayPanel.main, constraints);
            dayPanel.main.addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);

//                    TODO: OPEN THE Hourly Screen
                    System.out.println("Opening for day: " + day.getDayOfMonth());

                }
            });

//            TODO
            ImageIcon imageIcon = Application.getWeatherIcon(day.getWeatherIconType()); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);
            dayPanel.lbWeatherIcon.setText("");
            dayPanel.lbWeatherIcon.setIcon(imageIcon);


//            dayPanel.lbWeatherIcon.setIcon();
            dayPanel.lbDate.setText(day.getDayOfMonth() + " " + day.getDayOfWeek());
            dayPanel.lbDegrees.setText(settingsModel.getInUnits((day.getMaxTemperature() + day.getMinTemperature()) / 2.0));

            dayPanel.main.setVisible(true);


        }
    }

}
