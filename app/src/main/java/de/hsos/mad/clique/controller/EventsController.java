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

    public void acceptSelectedEvent() {
        this.currentlySelectedEvent.setAccepted(true);
        this.currentlySelectedEvent.setCanceled(false);
        if (this.openEvents.contains(this.currentlySelectedEvent)) {
            this.openEvents.remove(this.currentlySelectedEvent);
            this.acceptedEvents.add(this.currentlySelectedEvent);
        }
        if (this.canceledEvents.contains(this.currentlySelectedEvent)) {
            this.canceledEvents.remove(this.currentlySelectedEvent);
            this.acceptedEvents.add(this.currentlySelectedEvent);
        }
    }

    public void cancelSelectedEvent() {
        this.currentlySelectedEvent.setAccepted(false);
        this.currentlySelectedEvent.setCanceled(true);
        if (this.openEvents.contains(this.currentlySelectedEvent)) {
            this.openEvents.remove(this.currentlySelectedEvent);
            this.canceledEvents.add(this.currentlySelectedEvent);
        }
        if (this.acceptedEvents.contains(this.currentlySelectedEvent)) {
            this.acceptedEvents.remove(this.currentlySelectedEvent);
            this.canceledEvents.add(this.currentlySelectedEvent);
        }
    }

    public void createNewEvent(int eCliqueId, String eName, String eStreet, int eStreetNr, int eZip,
                               String eCity, String eDesc, String eDate) {
        EventsRepository.getInstance().createNewEvent(eCliqueId, eName, eStreet, eStreetNr, eZip,
            eCity, eDesc, eDate);
    }

    public void addOpenEvent(Event addEvent) {
        this.openEvents.add(addEvent);
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
