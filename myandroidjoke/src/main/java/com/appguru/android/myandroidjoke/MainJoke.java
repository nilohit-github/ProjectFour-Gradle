package com.appguru.android.myandroidjoke;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainJoke extends AppCompatActivity {
    public static String JOKE_KEY = "Joke key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);
        Log.i(TAG, "onCreate::: ");

    }
}
