package group18.controllers;

import group18.Main;
import group18.backend.Day;
import group18.backend.Hour;
import group18.models.HourlyModel;
import group18.screens.DailyView;
import group18.screens.DayPanel;
import group18.screens.HourlyPanels;
import group18.screens.HourlyView;
import group18.api.WeatherAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class HourlyController {
    private HourlyView view;
    private HourlyModel model;

    /*
    public HourlyController(HourlyView view) {
        this.view = view;
        initModel();
        view.addHourlyButtonListener(a ->
        {
            Main.app.setViewSettings();
        });
        addHourlyForecast(model.getHourlyList());
//        view.addHourlyForecast(model.getHourList());
    }

    private void initModel(){
        model = new HourlyModel();
        model.loadHourlyForecast();
    }

    public void addHourlyForecast(List<Hour> HourList)
    {
        GridBagLayout layout = new GridBagLayout();
        view.spHourList.setLayout(layout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = 1;
        int y = 0;


        for (Hour hour : HourList)
        {
            HourlyPanels dayPanel = new HourlyPanels();
            constraints.gridy = y++;
            dayPanel.main.setBorder(BorderFactory.createLineBorder(Color.black));
            view.spHourList.add(dayPanel.main, constraints);
            dayPanel.main.addMouseListener(new MouseAdapter()
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
//            dayPanel.lbCallendarIcon.setIcon();
//            dayPanel.lbWeatherIcon.setIcon();
            dayPanel.lbDate.setText(Integer.toString(hour.getHour()));
            dayPanel.lbDegrees.setText("" + (hour.getTemperature()));

            dayPanel.main.setVisible(true);


        }
    }
    */

}
