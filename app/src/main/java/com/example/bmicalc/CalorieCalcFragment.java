package com.example.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Fragment obsługujący kalkulator dziennego zapotrzebowania kalorycznego.
 * Na podstawie wzoru Harris-Benedicta oblicza BMR, a następnie
 * całkowitą przemianę materii (TDEE) uwzględniając poziom aktywności.
 * Dodatkowo wyświetla rekomendacje kulinarne.
 */
public class CalorieCalcFragment extends Fragment {

    private EditText etAge, etCalWeight, etCalHeight;
    private RadioGroup rgGender;
    private Spinner spinnerActivity;
    private Button btnCalculateCalories;
    private TextView tvCalorieResult, tvRecipes;

    /**
     * Konstruktor bezargumentowy wymagany dla fragmentów.
     */
    public CalorieCalcFragment() {
        // Wymagany konstruktor bezargumentowy
    }

    /**
     * Metoda tworząca widok fragmentu i inicjalizująca elementy interfejsu.
     *
     * @param inflater           LayoutInflater do "napompowania" layoutu fragmentu.
     * @param container          Kontener, do którego dołączany jest widok fragmentu.
     * @param savedInstanceState Zapisany stan fragmentu (jeśli istnieje).
     * @return Utworzony widok fragmentu.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calorie_calc, container, false);

        etAge = view.findViewById(R.id.etAge);
        etCalWeight = view.findViewById(R.id.etCalWeight);
        etCalHeight = view.findViewById(R.id.etCalHeight);
        rgGender = view.findViewById(R.id.rgGender);
        spinnerActivity = view.findViewById(R.id.spinnerActivity);
        btnCalculateCalories = view.findViewById(R.id.btnCalculateCalories);
        tvCalorieResult = view.findViewById(R.id.tvCalorieResult);
        tvRecipes = view.findViewById(R.id.tvRecipes);

        // Konfiguracja Spinnera z poziomami aktywności
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.activity_levels, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActivity.setAdapter(adapter);

        btnCalculateCalories.setOnClickListener(v -> calculateCalories());
        return view;
    }

    /**
     * Metoda obliczająca dzienne zapotrzebowanie kaloryczne na podstawie wzoru Harris-Benedicta.
     * Pobiera dane wejściowe, sprawdza ich poprawność, oblicza BMR i TDEE,
     * a następnie wyświetla wynik i rekomendacje kulinarne.
     */
    private void calculateCalories() {
        String ageStr = etAge.getText().toString();
        String weightStr = etCalWeight.getText().toString();
        String heightStr = etCalHeight.getText().toString();

        if (ageStr.isEmpty() || weightStr.isEmpty() || heightStr.isEmpty()) {
            tvCalorieResult.setText("Proszę wypełnić wszystkie pola.");
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);

            if (age <= 0 || weight <= 0 || height <= 0) {
                tvCalorieResult.setText("Nieprawidłowe dane.");
                return;
            }

            // Określenie płci – domyślnie mężczyzna, chyba że wybrano kobietę
            boolean isMale = (rgGender.getCheckedRadioButtonId() == R.id.rbMale);
            double bmr;
            if (isMale) {
                bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
            } else {
                bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
            }

            String activityLevel = spinnerActivity.getSelectedItem().toString();
            double activityFactor = 1.2;
            switch (activityLevel) {
                case "Brak aktywności":
                    activityFactor = 1.2;
                    break;
                case "Lekka aktywność":
                    activityFactor = 1.375;
                    break;
                case "Umiarkowana aktywność":
                    activityFactor = 1.55;
                    break;
                case "Wysoka aktywność":
                    activityFactor = 1.725;
                    break;
                case "Bardzo wysoka aktywność":
                    activityFactor = 1.9;
                    break;
            }

            double tdee = bmr * activityFactor;
            tvCalorieResult.setText(String.format("Dzienne zapotrzebowanie: %.0f kcal", tdee));

            showRecipeRecommendations(tdee);
        } catch (NumberFormatException e) {
            tvCalorieResult.setText("Nieprawidłowe dane.");
        }
    }

    /**
     * Metoda wyświetlająca rekomendacje kulinarne w zależności od obliczonego TDEE.
     *
     * @param tdee Obliczone dzienne zapotrzebowanie kaloryczne.
     */
    private void showRecipeRecommendations(double tdee) {
        StringBuilder recipes = new StringBuilder();
        recipes.append("Rekomendacje kulinarne:\n\n");
        if (tdee < 2000) {
            recipes.append("1. Sałatka Quinoa z warzywami (wegańska)\n")
                    .append("2. Zupa krem z dyni (wegetariańska)\n");
        } else {
            recipes.append("1. Grillowana pierś z kurczaka z warzywami (wysokobiałkowa)\n")
                    .append("2. Makaron pełnoziarnisty z sosem pomidorowym (zbilansowana)\n");
        }
        tvRecipes.setText(recipes.toString());
    }
}
