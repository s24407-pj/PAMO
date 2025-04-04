package com.example.bmicalc;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Główna aktywność aplikacji.
 * Inicjalizuje dolną nawigację oraz ładuje odpowiednie fragmenty w zależności od wybranej opcji.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Metoda wywoływana przy tworzeniu aktywności.
     * Ustawia domyślny fragment (kalkulator BMI) i obsługuje przełączanie fragmentów przy użyciu dolnej nawigacji.
     *
     * @param savedInstanceState Zapisany stan aktywności (jeśli istnieje).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ładowanie domyślnego fragmentu (kalkulator BMI)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new BMICalcFragment())
                    .commit();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int id = item.getItemId();
            if (id == R.id.nav_bmi) {
                selectedFragment = new BMICalcFragment();
            } else if (id == R.id.nav_calorie) {
                selectedFragment = new CalorieCalcFragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
            return true;
        });
    }
}
