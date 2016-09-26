/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.jhani.myapplication.backend;

import com.example.MyJavaJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.jhani.example.com",
                ownerName = "backend.myapplication.jhani.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "retrieveJokes")
    public MyBean retrieveJokes() {
        MyBean response = new MyBean();
      //  response.setData("Hi, " + name);
        MyJavaJoke myJavaJoke = new MyJavaJoke();
        response.setData(myJavaJoke.returnJoke());

        return response;
    }

}
