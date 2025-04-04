package com.example.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Fragment obsługujący kalkulator BMI.
 * Umożliwia wprowadzenie danych dotyczących wagi i wzrostu,
 * a następnie obliczenie wskaźnika BMI i wyświetlenie interpretacji wyniku.
 */
public class BMICalcFragment extends Fragment {

    private EditText etWeight, etHeight;
    private Button btnCalculateBMI;
    private TextView tvBMIResult;

    /**
     * Konstruktor bezargumentowy wymagany dla fragmentów.
     */
    public BMICalcFragment() {
        // Wymagany konstruktor bezargumentowy
    }

    /**
     * Metoda wywoływana przy tworzeniu widoku fragmentu.
     *
     * @param inflater           LayoutInflater do "napompowania" layoutu fragmentu.
     * @param container          Kontener, do którego dołączany jest widok fragmentu.
     * @param savedInstanceState Zapisany stan fragmentu (jeśli istnieje).
     * @return Utworzony widok fragmentu.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bmi_calc, container, false);

        etWeight = view.findViewById(R.id.etWeight);
        etHeight = view.findViewById(R.id.etHeight);
        btnCalculateBMI = view.findViewById(R.id.btnCalculateBMI);
        tvBMIResult = view.findViewById(R.id.tvBMIResult);

        btnCalculateBMI.setOnClickListener(v -> calculateBMI());
        return view;
    }

    /**
     * Metoda obliczająca wskaźnik BMI na podstawie wprowadzonych danych.
     * Sprawdza poprawność danych wejściowych, wykonuje obliczenia i
     * wyświetla wynik wraz z interpretacją.
     */
    private void calculateBMI() {
        String weightStr = etWeight.getText().toString();
        String heightStr = etHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            tvBMIResult.setText("Proszę wypełnić wszystkie pola.");
            return;
        }

        try {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr) / 100; // konwersja wzrostu na metry

            if (weight <= 0 || height <= 0) {
                tvBMIResult.setText("Nieprawidłowe dane.");
                return;
            }

            float bmi = weight / (height * height);
            String bmiCategory;
            if (bmi < 18.5) bmiCategory = "niedowaga";
            else if (bmi < 24.9) bmiCategory = "optimum";
            else if (bmi < 29.9) bmiCategory = "nadwaga";
            else bmiCategory = "otyłość";

            tvBMIResult.setText(String.format("BMI: %.2f (%s)", bmi, bmiCategory));
        } catch (NumberFormatException e) {
            tvBMIResult.setText("Nieprawidłowe dane.");
        }
    }
}
