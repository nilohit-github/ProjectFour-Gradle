package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.test.AndroidTestCase;
import android.test.RenamingDelegatingContext;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by jhani on 9/26/2016.
 */

public class TestProcessor extends AndroidTestCase implements JokeProcessor.AsyncResponse {

    Context mContext;
// get the app context in your test class
    @Before
    public void setUp() {
        mContext = new RenamingDelegatingContext(InstrumentationRegistry.getTargetContext(), "test_");
    }
    @Test
    public void testAsync() {
        String response = "";
        try{

            JokeProcessor task= new JokeProcessor(this);
            task.execute();
            response= task.get(30, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }

        assertNotNull("not null",response);
    }


    @Override
    public void processFinish(String output) {

        //assertNotNull("not null",output);

    }
}
