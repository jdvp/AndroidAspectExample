package me.jdvp.androidaspectexample.activity;

import android.view.View;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import me.jdvp.androidaspectexample.R;
import me.jdvp.androidaspectexample.application.TestDaggerSetupApplication;

import static junit.framework.Assert.assertEquals;

/**
 * Tests created to test functional requirements for the MainActivity
 *
 * To run, remove the @ignore annotation and update the JUnit Run configuration with the following
 *
 * VM Options : -ea -noverify
 * Working directory : $MODULE_DIR$
 *
 * Details on running Robolectric tests in Android Studio can be found at http://robolectric.org/other-environments/
 *
 * Created by jdvp on 6/19/18.
 */
@Ignore
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {


    @Before
    public void setup() {
        //inject the unit test with the same dependencies that will be injected into the activity
        TestDaggerSetupApplication app = (TestDaggerSetupApplication) RuntimeEnvironment.application;
        app.getTestAppComponent().inject(this);
    }


    //todo add actual tests here

    @Test
    public void testVisible() {
        MainActivity mainActivity = getResumedActivity();

        assertEquals(View.VISIBLE, mainActivity.findViewById(R.id.button_1).getVisibility());
    }


    /**
     * Builds the activity under test. Call after setting the mocks appropriately
     *
     * @return A resumed version of MainActivity
     */
    private MainActivity getResumedActivity() {
        return Robolectric.buildActivity(MainActivity.class)
                .create().start().resume().visible().get();
    }
}
