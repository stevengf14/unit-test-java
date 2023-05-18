package ec.com.learning.unittest.junit5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class TemperatureCalculatorTest {

    private TemperatureCalculator temperatureCalculator;

    @BeforeEach
    public void setUp() {
        temperatureCalculator = new TemperatureCalculator();
    }

    @AfterEach
    public void tearDown() {
        temperatureCalculator = null;
    }

    @Test
    public void toFahrenheit_Test() {
        assertEquals(98.6, temperatureCalculator.toFahrenheit(37), 0.01);
    }

    @Test
    public void toCelcius_Test() {
        assertEquals(65.56 , temperatureCalculator.toCelcius(150), 0.01);
    }

}
