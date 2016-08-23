package de.hsos.mad.clique.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.EventsController;

public class ShowEventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event_details);

        String newTitle = EventsController.getInstance().getCurrentlySelectedEvent().getEventName() +
                " am " + EventsController.getInstance().getCurrentlySelectedEvent().getEventDate();
        setTitle(newTitle);
        TextView street = (TextView)findViewById(R.id.event_detail_street);
        street.setText(EventsController.getInstance().getCurrentlySelectedEvent().getEventStreet());
        TextView streetNumber = (TextView)findViewById(R.id.event_detail_streetNumber);
        streetNumber.setText(String.valueOf(EventsController.getInstance().getCurrentlySelectedEvent().getEventStreetNumber()));
        TextView zipAndCity = (TextView)findViewById(R.id.event_detail_city);
        String zipAndCityString = EventsController.getInstance().getCurrentlySelectedEvent().getEventZip() +
                " " + EventsController.getInstance().getCurrentlySelectedEvent().getEventCity();
        zipAndCity.setText(zipAndCityString);
        TextView desc = (TextView)findViewById(R.id.event_detail_desc);
        desc.setText(EventsController.getInstance().getCurrentlySelectedEvent().getEventDescription());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        EventsController.getInstance().setCurrentlySelectedEvent(null);
    }

    public void acceptEvent(View view) {
        EventsController.getInstance().acceptSelectedEvent(this);
        finish();
    }

    public void cancelEvent(View view) {
        EventsController.getInstance().cancelSelectedEvent(this);
        finish();
    }

    public void showEventLocation(View view) {
        String eventStreet = EventsController.getInstance().getCurrentlySelectedEvent().getEventStreet();
        String eventStreetNr = String.valueOf(EventsController.getInstance().getCurrentlySelectedEvent().getEventStreetNumber());
        String eventZip = String.valueOf(EventsController.getInstance().getCurrentlySelectedEvent().getEventZip());
        String eventCity = EventsController.getInstance().getCurrentlySelectedEvent().getEventCity();

        Uri locationUri = Uri.parse("geo:0,0?q="+eventStreet+" "+eventStreetNr+", "+eventZip+" "+eventCity);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
