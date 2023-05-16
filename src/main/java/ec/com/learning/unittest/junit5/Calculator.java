package ec.com.learning.unittest.junit5;

/**
 *
 * @author Steven Guamán - May 2023
 */
public class Calculator {

    private int result;

    public int add(int number1, int number2) {
        return number1 + number2;
    }

    public int subtract(int number1, int number2) {
        return number1 - number2;
    }

    public int divide(int number1, int number2) {
        return number1 / number2;
    }

    public int divideByZero(int number1, int number2) {
        if (number2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return number1 / number2;
    }

}
