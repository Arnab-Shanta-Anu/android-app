package com.example.jobbank;

import android.content.Context;

<<<<<<< HEAD
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
=======
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
>>>>>>> ea335180174ccde307e38e78dfc50885ed418529

import org.junit.Test;
import org.junit.runner.RunWith;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
=======
import static org.junit.Assert.*;
>>>>>>> ea335180174ccde307e38e78dfc50885ed418529

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.jobbank", appContext.getPackageName());
    }
}
