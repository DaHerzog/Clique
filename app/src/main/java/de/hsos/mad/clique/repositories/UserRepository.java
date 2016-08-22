package de.hsos.mad.clique.repositories;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import de.hsos.mad.clique.communication.MyRequestQueue;
import de.hsos.mad.clique.models.User;

/**
 * Created by davidherzog on 22.08.16.
 */
public class UserRepository {

    private static UserRepository instance = null;
    private static final String USER_JSON_URL = "http://localhost:8080/cliqueServer/rest/users/";

    private UserRepository() {

    }

    public static synchronized UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public boolean createNewUser(User newUser, String password, Context appCtx) {
        try {
            String encodedNameParameter = URLEncoder.encode(newUser.getmName(), "UTF-8");
            String url = USER_JSON_URL+"new/"+newUser.geteMail()+"/"+encodedNameParameter+"/"+password;
            Log.w("DEBUG", url);
            JsonObjectRequest theRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.w("DEBUG", "Antwort vom Server"+response.toString());
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.w("DEBUG", "Fehler bei der Übertragung?");
                            Log.w("DEBUG", error.toString());
                        }
                    });


            MyRequestQueue.getInstance(appCtx).addToRequestQueue(theRequest);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return true;
    }
}
