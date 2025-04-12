package com.example.bmicalc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Aktywność wyświetlająca ekran powitalny (splash screen).
 * Wyświetla grafikę oraz dolną nawigację przez określony czas,
 * po czym przechodzi do głównej aktywności aplikacji.
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    /**
     * Metoda wywoływana przy tworzeniu aktywności.
     * Ustawia widok splash screen oraz inicjalizuje dolną nawigację.
     *
     * @param savedInstanceState Zapisany stan aktywności (jeśli istnieje).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bottomNavigationView = findViewById(R.id.bottom_navigation_splash);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Przykładowa obsługa kliknięć – na splash screenie interakcja jest zazwyczaj ograniczona.
            int id = item.getItemId();
            if (id == R.id.nav_bmi) {
                // Możesz dodać akcję lub wyświetlić komunikat.
            } else if (id == R.id.nav_calorie) {
                // Analogiczna obsługa.
            }
            return true;
        });

        // Wyświetlanie splash screen przez 3 sekundy, po czym przejście do MainActivity.
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 3000);
    }
}
