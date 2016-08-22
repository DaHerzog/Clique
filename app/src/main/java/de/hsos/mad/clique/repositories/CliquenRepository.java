package de.hsos.mad.clique.repositories;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hsos.mad.clique.activities.CreateNewClique;
import de.hsos.mad.clique.activities.LoginActivity;
import de.hsos.mad.clique.activities.RegisterActivity;
import de.hsos.mad.clique.communication.MyRequestQueue;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.interfaces.MyCallbackInterface;
import de.hsos.mad.clique.models.Clique;
import de.hsos.mad.clique.models.User;

/**
 * Created by davidherzog on 03.08.16.
 */
public class CliquenRepository {

    private static CliquenRepository instance = null;
    private static final String CLIQUES_JSON_URL = "http://10.0.2.2:8080/cliqueServer/rest/clique/";

    private CliquenRepository() {

    }

    public static synchronized CliquenRepository getInstance() {
        if (instance == null) {
            instance = new CliquenRepository();
        }
        return instance;
    }

    public void getCliquesForUserId(long pUserId, final Context appCtx) {
        String url = CLIQUES_JSON_URL+"user/"+String.valueOf(pUserId);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject tmpJsonObj = response.getJSONObject(i);
                        long cliqId = tmpJsonObj.getLong("id");
                        String name = tmpJsonObj.getString("name");
                        String creator = tmpJsonObj.getString("creator");
                        Clique respClique = new Clique(cliqId, name, creator);
                        CliquenController.getInstance().getUsersCliques().add(respClique);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (appCtx instanceof LoginActivity) {
                    ((MyCallbackInterface) appCtx).dataReady();
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

        MyRequestQueue.getInstance(appCtx).addToRequestQueue(jsonArrayRequest);
    }

    public void addNewClique(String name, final Context appCtx) {
        //RESTful Request here...

        //The selection of the id should happen on the server. But we need the id of the clique for
        //the events!
        long userId = UserController.getInstance().getActualUser().getId();
        String url = CLIQUES_JSON_URL + "create/" + String.valueOf(userId) + "/" + name;
        JsonObjectRequest theRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            long cliqId = response.getLong("id");
                            String name = response.getString("name");
                            String creator = response.getString("creator");
                            Clique newClique = new Clique(cliqId, name, creator);
                            CliquenController.getInstance().getUsersCliques().add(newClique);
                            if (appCtx instanceof CreateNewClique) {
                                ((MyCallbackInterface) appCtx).dataReady();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.w("DEBUG", "Fehler bei der Übertragung: ");
                        Log.w("DEBUG", error.toString());
                    }
                });
        MyRequestQueue.getInstance(appCtx).addToRequestQueue(theRequest);
    }
}
