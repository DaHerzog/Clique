package de.hsos.mad.clique.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.adapter.EventsAdapter;
import de.hsos.mad.clique.controller.EventsController;

/**
 * Created by davidherzog on 18.08.16.
 */
public class CanceledEventsFragment extends Fragment{

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private EventsAdapter eventsAdapter;

    public CanceledEventsFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static OpenEventsFragment newInstance(int sectionNumber) {
        OpenEventsFragment fragment = new OpenEventsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_canceled_events, container, false);
        RecyclerView eventsList = (RecyclerView)rootView.findViewById(R.id.events_canceled_recycler_view);
        LinearLayoutManager myLlm = new LinearLayoutManager(rootView.getContext());
        myLlm.setOrientation(LinearLayoutManager.VERTICAL);
        eventsList.setLayoutManager(myLlm);
        EventsAdapter canceledAdapter = new EventsAdapter(EventsController.getInstance().getCanceledEventsAsArray());
        eventsList.setAdapter(canceledAdapter);

        return rootView;
    }

    public EventsAdapter getEventsAdapter() {
        return eventsAdapter;
    }

    public void setEventsAdapter(EventsAdapter eventsAdapter) {
        this.eventsAdapter = eventsAdapter;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (this.getView() != null) {
            RecyclerView eventsList = (RecyclerView) this.getView().findViewById(R.id.events_canceled_recycler_view);
            LinearLayoutManager myLlm = new LinearLayoutManager(this.getView().getContext());
            myLlm.setOrientation(LinearLayoutManager.VERTICAL);
            eventsList.setLayoutManager(myLlm);
            EventsAdapter canceledAdapter = new EventsAdapter(EventsController.getInstance().getCanceledEventsAsArray());
            eventsList.setAdapter(canceledAdapter);
        }
    }
}
