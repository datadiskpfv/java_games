package uk.co.datadisk.temperatureconverter;

import uk.co.datadisk.mywindow.MyWindow;

/**
 * Created by vallep on 12/07/2017.
 *
 */
public class TemperatureConverter extends MyWindow {
    public TemperatureConverter() {
        double f = promptForDouble("Enter degrees Fahrenheit.");
        print( (f - 32) * 5 / 9 + " degrees Celsius");

        double c = promptForDouble("Enter degrees Celsius");
        print( "Fahreheit " + (1.8 * c + 32) );
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}