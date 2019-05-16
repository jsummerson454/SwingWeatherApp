package group18.interfaces;

import group18.backend.Day;

public interface Weekly
{

    void openSettings();
    void reloadData();
    void openHourlyForDay(Day day);

    void suggestDay();
    void backToPreviousScreen();
}
