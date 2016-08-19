package de.hsos.mad.clique.activities;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.EventsController;

public class CreateNewEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_event);
    }

    public void createNewEvent(View view) {
        TextView eventName = (TextView)findViewById(R.id.new_event_name);
        TextView eventDate = (TextView)findViewById(R.id.new_event_date);
        TextView eventStreet = (TextView)findViewById(R.id.new_event_street);
        TextView eventStreetNr = (TextView)findViewById(R.id.new_event_street_nr);
        TextView eventZip = (TextView)findViewById(R.id.new_event_zip);
        TextView eventCity = (TextView)findViewById(R.id.new_event_city);
        TextView eventDesc = (TextView)findViewById(R.id.new_event_desc);

        int eventCliqueId = CliquenController.getInstance().getCurrentlySelectedClique().getId();
        String eventNameString = eventName.getText().toString();
        String eventDateString = eventDate.getText().toString();
        String eventStreetString = eventStreet.getText().toString();
        int eventStreetNrInt = Integer.parseInt(eventStreetNr.getText().toString());
        int eventZipInt = Integer.parseInt(eventZip.getText().toString());
        String eventCityString = eventCity.getText().toString();
        String eventDescString = eventDesc.getText().toString();

        EventsController.getInstance().createNewEvent(eventCliqueId,eventNameString,
                eventStreetString, eventStreetNrInt, eventZipInt, eventCityString, eventDescString,
                eventDateString);

        finish();
    }
}
