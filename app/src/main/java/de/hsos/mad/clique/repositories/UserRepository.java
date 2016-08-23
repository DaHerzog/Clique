package de.hsos.mad.clique.repositories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import de.hsos.mad.clique.activities.RegisterActivity;
import de.hsos.mad.clique.communication.MyRequestQueue;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.interfaces.MyCallbackInterface;
import de.hsos.mad.clique.models.User;

/**
 * Created by davidherzog on 22.08.16.
 */
public class UserRepository {

    private static UserRepository instance = null;
    private static final String USER_JSON_URL = "http://10.0.2.2:8080/cliqueServer/rest/users/";

    private UserRepository() {

    }

    public static synchronized UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public boolean createNewUser(User newUser, String password, final Context appCtx) {
        try {
            String encodedNameParameter = URLEncoder.encode(newUser.getmName(), "UTF-8");
            String url = USER_JSON_URL+"new/"+newUser.geteMail()+"/"+encodedNameParameter+"/"+password;
            Log.w("DEBUG", url);


            JsonObjectRequest theRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.getBoolean("success")) {
                                    if (appCtx instanceof RegisterActivity) {
                                        ((MyCallbackInterface) appCtx).dataReady();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.w("DEBUG", "Fehler bei der Übertragung?");
                            Log.w("DEBUG", error.toString());
                            Log.w("DEBUG", error.getMessage());
                        }
                    });


            MyRequestQueue.getInstance(appCtx).addToRequestQueue(theRequest);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void login(final String email, String password, final Context appCtx) {

        String url = USER_JSON_URL+"login/"+email+"/"+password;
        Log.w("DEBUG", url);


        JsonObjectRequest theRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getBoolean("success")) {
                                String secondUrl = USER_JSON_URL+"email/"+email;
                                JsonObjectRequest theRequest = new JsonObjectRequest
                                        (Request.Method.GET, secondUrl, null, new Response.Listener<JSONObject>() {
                                            @Override
                                            public void onResponse(JSONObject response) {
                                                try {
                                                    long id = response.getLong("id");
                                                    String name = response.getString("name");
                                                    String email = response.getString("email");
                                                    User newUser = new User(name, email);
                                                    newUser.setId(id);
                                                    UserController.getInstance().setActualUser(newUser);
                                                    CliquenRepository.getInstance().getCliquesForUserId(id, appCtx);
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }

                                            }
                                        }, new Response.ErrorListener() {
                                            @Override
                                            public void onErrorResponse(VolleyError error){

                                            }
                                        });
                                MyRequestQueue.getInstance(appCtx).addToRequestQueue(theRequest);
                            } else {
                                Toast.makeText(appCtx.getApplicationContext(), "Falsche Eingabedaten",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.w("DEBUG", "Fehler bei der Übertragung?");
                        Log.w("DEBUG", error.toString());
                        Log.w("DEBUG", error.getMessage());
                    }
                });


        MyRequestQueue.getInstance(appCtx).addToRequestQueue(theRequest);

    }
}
