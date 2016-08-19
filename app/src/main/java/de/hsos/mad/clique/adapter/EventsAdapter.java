package de.hsos.mad.clique.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.activities.ShowEventDetails;
import de.hsos.mad.clique.activities.ShowEventsActivity;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.EventsController;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.models.Event;

/**
 * Created by davidherzog on 16.08.16.
 */
public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder>{

    private Event[] events;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView mEventName;
        protected Event event;
        protected CardView cardView;

        public ViewHolder(View v) {
            super(v);
            this.mEventName = (TextView) v.findViewById(R.id.event_card_view_name);
            this.cardView = (CardView)v.findViewById(R.id.events_card_view);
            this.cardView.setOnClickListener(this);
        }

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        @Override
        public void onClick(View v) {
            //Generate intent for "show detailed Event" - activity
            EventsController.getInstance().setCurrentlySelectedEvent(this.event);
            v.getContext().startActivity(new Intent(v.getContext(), ShowEventDetails.class));

        }

    }

    public EventsAdapter() {

    }

    public EventsAdapter(Event[] pUsersEvents) {
        this.events = pUsersEvents;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_events_cardview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event currEvent = events[position];
        holder.mEventName.setText(currEvent.getEventName());
        holder.setEvent(events[position]);
    }

    @Override
    public int getItemCount() {
        return events.length;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }
}
