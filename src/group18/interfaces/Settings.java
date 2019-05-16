package group18.interfaces;

import group18.backend.Location;

public interface Settings
{

    void changeUnitsToFahrenheit();
    void changeUnitsToCelsius();
    void turnNotificationsOn();
    void turnNotificationsOff();
    void selectColdDegreeThreshold(int degrees);
    void selectHotDegreeThreshold(int degrees);
    void setLocation(Location location);

    void backToPreviousScreen();
}
