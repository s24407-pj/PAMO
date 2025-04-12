package com.example.bmicalc;

/**
 * Klasa pomocnicza zawierająca metody obliczające wskaźnik BMI i określające kategorię wagową.
 */
public class CalculatorUtils {

    /**
     * Oblicza wskaźnik BMI na podstawie wagi (kg) i wzrostu (cm).
     *
     * @param weight waga w kilogramach
     * @param height wzrost w centymetrach
     * @return obliczone BMI
     * @throws IllegalArgumentException jeśli wzrost jest mniejszy lub równy zero
     */
    public static float calculateBMI(float weight, float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Wzrost musi być większy od 0");
        }
        float heightMeters = height / 100; // konwersja centymetrów na metry
        return weight / (heightMeters * heightMeters);
    }

    /**
     * Określa kategorię BMI na podstawie jego wartości.
     *
     * @param bmi obliczone BMI
     * @return kategoria BMI jako napis: "niedowaga", "optimum", "nadwaga" lub "otyłość"
     */
    public static String getBMICategory(float bmi) {
        if (bmi < 18.5) return "niedowaga";
        else if (bmi < 24.9) return "optimum";
        else if (bmi < 29.9) return "nadwaga";
        else return "otyłość";
    }
}