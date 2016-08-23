package de.hsos.mad.clique.repositories;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hsos.mad.clique.activities.CreateNewEventActivity;
import de.hsos.mad.clique.activities.ShowCliquesActivity;
import de.hsos.mad.clique.communication.MyRequestQueue;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.EventsController;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.interfaces.MyCallbackInterface;
import de.hsos.mad.clique.models.Event;

/**
 * Created by davidherzog on 16.08.16.
 */
public class EventsRepository {

    private static EventsRepository instance = null;
    private static final String EVENTS_JSON_URL = "http://10.0.2.2:8080/cliqueServer/rest/events/";

    private EventsRepository() {

    }

    public static synchronized EventsRepository getInstance() {
        if (instance == null) {
            instance = new EventsRepository();
        }
        return instance;
    }

    public void getEventsPerUserAndClique(final Context appCtx) {
        //Get the User and Clique ID per actual... variable in corresponding controller
        String userId = String.valueOf(UserController.getInstance().getActualUser().getId());
        String cliqueId = String.valueOf(CliquenController.getInstance().getCurrentlySelectedClique().getId());
        String url = EVENTS_JSON_URL+"get/"+userId+"/"+cliqueId;
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject tmpJsonObj = response.getJSONObject(i);
                        long id = tmpJsonObj.getLong("id");
                        long cliqId = tmpJsonObj.getLong("cliqueId");
                        String eventName = tmpJsonObj.getString("eventName");
                        String eventStreet = tmpJsonObj.getString("eventStreet");
                        int eventStreetNumber = tmpJsonObj.getInt("eventStreetnumber");
                        int eventZip = tmpJsonObj.getInt("eventZip");
                        String eventCity = tmpJsonObj.getString("eventCity");
                        String eventDescription = tmpJsonObj.getString("eventDescription");
                        String eventDate = tmpJsonObj.getString("eventDate");
                        boolean open = tmpJsonObj.getBoolean("open");
                        boolean accepted = tmpJsonObj.getBoolean("accepted");
                        boolean canceled = tmpJsonObj.getBoolean("canceled");
                        Event newEvent = new Event(id, cliqId, eventName, eventStreet,
                                eventStreetNumber, eventZip, eventCity, eventDescription, eventDate,
                                open, accepted, canceled);
                        EventsController.getInstance().populateLists(newEvent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (appCtx instanceof ShowCliquesActivity) {
                    ((MyCallbackInterface) appCtx).dataReady();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.w("DEBUG", "Fehler bei der Übertragung?");
                Log.w("DEBUG", error.toString());
            }
        });
        MyRequestQueue.getInstance(appCtx).addToRequestQueue(jsonArrayRequest);
    }

    public void createNewEvent(long eCliqueId, String eName, String eStreet, int eStreetNr, int eZip,
                               String eCity, String eDesc, String eDate, final Context appCtx) {
        //Restful aufruf mit den parametern und so...
        String url = EVENTS_JSON_URL+"create/"+String.valueOf(eCliqueId)+"/"+eName+"/"+
                eStreet+"+"+eStreetNr+"/"+eZip+"/"+eCity+"/"+eDesc+"/"+eDate;
        JsonObjectRequest theRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            long id = response.getLong("id");
                            long cliqId = response.getLong("cliqueId");
                            String eventName = response.getString("eventName");
                            String eventStreet = response.getString("eventStreet");
                            int eventStreetNumber = response.getInt("eventStreetnumber");
                            int eventZip = response.getInt("eventZip");
                            String eventCity = response.getString("eventCity");
                            String eventDescription = response.getString("eventDescription");
                            String eventDate = response.getString("eventDate");
                            boolean open = response.getBoolean("open");
                            boolean accepted = response.getBoolean("accepted");
                            boolean canceled = response.getBoolean("canceled");
                            Event newEvent = new Event(id, cliqId, eventName, eventStreet,
                                    eventStreetNumber, eventZip, eventCity, eventDescription,
                                    eventDate, open, accepted, canceled);
                            EventsController.getInstance().addOpenEvent(newEvent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (appCtx instanceof CreateNewEventActivity) {
                            ((MyCallbackInterface) appCtx).dataReady();
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

    public void notifyServerChangedStatus(Event acEvent, final Context appCtx, String status) {
        String userId = String.valueOf(UserController.getInstance().getActualUser().getId());
        String eventId = String.valueOf(acEvent.getId());

        String url = EVENTS_JSON_URL+"update/"+userId+"/"+eventId+"/"+status;
        JsonObjectRequest theRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if (response.getBoolean("success")) {
                                Toast.makeText(appCtx.getApplicationContext(), "Status geändert",
                                        Toast.LENGTH_SHORT).show();
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
