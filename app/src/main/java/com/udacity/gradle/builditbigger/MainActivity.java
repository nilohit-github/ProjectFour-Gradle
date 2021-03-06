package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.appguru.android.myandroidjoke.MainJoke;


public class MainActivity extends ActionBarActivity  implements JokeProcessor.AsyncResponse{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new JokeProcessor(this).execute();
    }

    //this override the implemented method from AsyncResponse
    @Override
    public void processFinish(String output){

        Intent intent = new Intent(this, MainJoke.class);
        // MyJavaJoke myJavaJoke = new MyJavaJoke();

        intent.putExtra(MainJoke.JOKE_KEY, output);
        startActivity(intent);
        //Here you will receive the result fired from async class
        //of onPostExecute(result) method.
    }









}
