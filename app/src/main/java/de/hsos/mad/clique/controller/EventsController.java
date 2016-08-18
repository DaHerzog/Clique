package de.hsos.mad.clique.controller;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mad.clique.models.Event;
import de.hsos.mad.clique.repositories.EventsRepository;

/**
 * Created by davidherzog on 16.08.16.
 */
public class EventsController {

    private static EventsController instance = null;

    private List<Event> openEvents;
    private List<Event> acceptedEvents;
    private List<Event> canceledEvents;

    private Event currentlySelectedEvent;

    private EventsController() {
        this.openEvents = new ArrayList<Event>();
        this.acceptedEvents = new ArrayList<Event>();
        this.canceledEvents = new ArrayList<Event>();
        this.populateLists();
    }

    public static EventsController getInstance() {
        if (instance == null) {
            instance = new EventsController();
        }
        return instance;
    }

    public void populateLists() {
        ArrayList<Event> allEvents = EventsRepository.getInstance().getEventsPerUserAndClique();
        for (Event currEvent : allEvents) {
            if (currEvent.isOpen()) {
                this.openEvents.add(currEvent);
            }
            if (currEvent.isAccepted()) {
                this.acceptedEvents.add(currEvent);
            }
            if (currEvent.isCanceled()) {
                this.canceledEvents.add(currEvent);
            }
        }
    }

    public Event[] getOpenEventsAsArray() {
        Event[] returnArray = new Event[this.openEvents.size()];
        returnArray = this.openEvents.toArray(returnArray);
        return returnArray;
    }

    public Event[] getAcceptedEventsAsArray() {
        Event[] returnArray = new Event[this.acceptedEvents.size()];
        returnArray = this.acceptedEvents.toArray(returnArray);
        return returnArray;
    }

    public Event[] getCanceledEventsAsArray() {
        Event[] returnArray = new Event[this.canceledEvents.size()];
        returnArray = this.canceledEvents.toArray(returnArray);
        return returnArray;
    }

    public List<Event> getOpenEvents() {
        return openEvents;
    }

    public void setOpenEvents(List<Event> openEvents) {
        this.openEvents = openEvents;
    }

    public List<Event> getAcceptedEvents() {
        return acceptedEvents;
    }

    public void setAcceptedEvents(List<Event> acceptedEvents) {
        this.acceptedEvents = acceptedEvents;
    }

    public List<Event> getCanceledEvents() {
        return canceledEvents;
    }

    public void setCanceledEvents(List<Event> canceledEvents) {
        this.canceledEvents = canceledEvents;
    }

    public Event getCurrentlySelectedEvent() {
        return currentlySelectedEvent;
    }

    public void setCurrentlySelectedEvent(Event currentlySelectedEvent) {
        this.currentlySelectedEvent = currentlySelectedEvent;
    }
}
