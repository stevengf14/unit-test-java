package ec.com.learning.unittest.junit5;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class TemperatureCalculator {

    public TemperatureCalculator() {
    }

    public float toFahrenheit(float degree) {
        return (degree * 9 / 5) + 32;
    }

    public float toCelcius(float degree) {
        return (degree - 32) * 5 / 9;
    }

}
