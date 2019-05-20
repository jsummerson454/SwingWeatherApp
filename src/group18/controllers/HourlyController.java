package group18.controllers;

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
import java.util.List;

public class HourlyController {
    private HourlyView view;
    private HourlyModel model;
    private SettingsModel settingsModel;


    public HourlyController(SettingsModel settingsModel, HourlyView view) {
        this.view = view;
        this.settingsModel = settingsModel;
    }
/*
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
        GridBagLayout layout = new GridBagLayout();
        view.spHourPanel.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        int y = 0;

        for (Hour hour : HourList)
        {
            HourlyPanels hourPanel = new HourlyPanels();
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
            hourPanel.lbDate.setText("Time: " + Integer.toString(hour.getHour()));
            hourPanel.lbDegrees.setText(settingsModel.getInUnits(hour.getTemperature()));
            hourPanel.main.setVisible(true);


        }
    }
*/

}
