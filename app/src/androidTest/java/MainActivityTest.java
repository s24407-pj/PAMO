import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.Visibility.VISIBLE;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.bmicalc.MainActivity;
import com.example.bmicalc.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Przykładowy test wykorzystujący ActivityScenarioRule do testowania MainActivity.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testBottomNavigationSwitch() {
        // Na starcie sprawdzamy, czy element interfejsu kalkulatora BMI jest widoczny.
        onView(withId(R.id.tvBMIResult))
                .check(matches(withEffectiveVisibility(VISIBLE)));

        // Klikamy w element dolnej nawigacji, aby przełączyć się na fragment kalkulatora kalorii.
        onView(withId(R.id.nav_calorie)).perform(click());

        // Sprawdzamy, czy po przełączeniu widoczny jest fragment kalkulatora kalorii.
        onView(withId(R.id.tvCalorieResult))
                .check(matches(withEffectiveVisibility(VISIBLE)));
    }
}