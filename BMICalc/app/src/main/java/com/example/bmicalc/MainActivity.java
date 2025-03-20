package com.example.bmicalc;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Główna aktywność aplikacji do obliczania wskaźnika BMI.
 */
public class MainActivity extends AppCompatActivity {

    EditText etWeight, etHeight;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja pól tekstowych i przycisku
        etWeight = findViewById(R.id.etWeight);
        etHeight = findViewById(R.id.etHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        // Ustawienie listenera dla przycisku obliczania BMI
        btnCalculate.setOnClickListener(v -> calculateBMI());
    }

    /**
     * Metoda obliczająca wskaźnik BMI na podstawie wprowadzonych danych.
     * Sprawdza poprawność danych wejściowych i wyświetla wynik lub komunikaty o błędach.
     */
    private void calculateBMI() {
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();

        // Sprawdzenie, czy pola wagi i wzrostu są puste
        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            tvResult.setText(R.string.empty_fields); // Wyświetlenie komunikatu o pustych polach
            return;
        }

        try {
            // Konwersja wprowadzonych danych na liczby zmiennoprzecinkowe
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // Przeliczenie wzrostu na metry

            // Sprawdzenie, czy waga i wzrost są większe od zera
            if (weight <= 0 || height <= 0) {
                tvResult.setText(R.string.invalid_input); // Wyświetlenie komunikatu o nieprawidłowych wartościach
                return;
            }

            // Obliczenie wskaźnika BMI
            float bmi = weight / (height * height);
            String bmiCategory = getBMICategory(bmi);

            // Wyświetlenie wyniku BMI i kategorii
            tvResult.setText(getString(R.string.bmi_result, bmi, bmiCategory));

        } catch (NumberFormatException e) {
            // Wyświetlenie komunikatu o nieprawidłowym formacie danych
            tvResult.setText(R.string.invalid_input);
        }
    }

    /**
     * Metoda określająca kategorię wagową na podstawie wskaźnika BMI.
     *
     * @param bmi Wskaźnik BMI obliczony w metodzie calculateBMI.
     * @return Kategoria wagowa jako ciąg znaków:
     *         - "niedowaga" dla BMI < 18.5,
     *         - "optimum" dla BMI 18.5–24.9,
     *         - "nadwaga" dla BMI 25–29.9,
     *         - "otyłość" dla BMI >= 30.
     */
    private String getBMICategory(float bmi) {
        if (bmi < 18.5) return "niedowaga";
        else if (bmi < 24.9) return "optimum";
        else if (bmi < 29.9) return "nadwaga";
        else return "otyłość";
    }
}