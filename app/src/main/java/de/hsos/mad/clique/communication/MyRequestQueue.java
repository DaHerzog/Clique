package de.hsos.mad.clique.communication;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by davidherzog on 22.08.16.
 */
public class MyRequestQueue {

    private static MyRequestQueue instance;
    private static Context theContext;
    private RequestQueue theQueue;


    private MyRequestQueue(Context appCtx) {
        theContext = appCtx;
        theQueue = getRequestQueue();
    }

    public static synchronized MyRequestQueue getInstance(Context appCtx) {
        if (instance == null) {
            instance = new MyRequestQueue(appCtx);
        }
        return instance;
    }

    private RequestQueue getRequestQueue() {
        if (theQueue == null) {

            theQueue = Volley.newRequestQueue(theContext.getApplicationContext(), new OkHttpStack(new OkHttpClient()));
        }
        return theQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public RequestQueue getTheQueue() {
        return theQueue;
    }

}
