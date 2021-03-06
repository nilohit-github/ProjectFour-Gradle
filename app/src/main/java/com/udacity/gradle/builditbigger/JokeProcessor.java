package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.example.jhani.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by jhani on 9/25/2016.
 */

public class JokeProcessor extends AsyncTask<Void, Void, String>  {


        private static MyApi myApiService = null;
        private Context context;

    // you may separate this or combined to caller class.
    public interface AsyncResponse {
        void processFinish(String output);
    }
    public JokeProcessor(AsyncResponse delegate){
        this.delegate = delegate;
    }

    public AsyncResponse delegate = null;

        @Override
        protected String doInBackground(Void... voids) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApiService = builder.build();
            }

           // context = params[0].first;


            try {
                return myApiService.retrieveJokes().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }


    @Override
        protected void onPostExecute(String result) {
           // Toast.makeText(context, result, Toast.LENGTH_LONG).show();
            delegate.processFinish(result);
            //Intent intent = new Intent(context, MainJoke.class);
           // MyJavaJoke myJavaJoke = new MyJavaJoke();

            //intent.putExtra(MainJoke.JOKE_KEY, result);
            //context.startActivity(intent);
        }
    }

