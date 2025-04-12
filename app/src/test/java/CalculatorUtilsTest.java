import org.junit.Test;
import static org.junit.Assert.*;

import com.example.bmicalc.CalculatorUtils;

/**
 * Klasa testowa sprawdzająca logikę obliczeń w CalculatorUtils.
 */
public class CalculatorUtilsTest {

    /**
     * Testuje metodę calculateBMI.
     */
    @Test
    public void testCalculateBMI() {
        float bmi = CalculatorUtils.calculateBMI(70f, 170f);
        // Przybliżona wartość BMI: 70 / (1.7^2) ≈ 24.22
        assertEquals(24.22, bmi, 0.1);
    }

    /**
     * Testuje przypisanie kategorii dla różnych wartości BMI.
     */
    @Test
    public void testBMICategory() {
        assertEquals("niedowaga", CalculatorUtils.getBMICategory(18.0f));
        assertEquals("optimum", CalculatorUtils.getBMICategory(22.0f));
        assertEquals("nadwaga", CalculatorUtils.getBMICategory(27.0f));
        assertEquals("otyłość", CalculatorUtils.getBMICategory(31.0f));
    }
}