package de.hsos.mad.clique.repositories;

import java.util.ArrayList;

import de.hsos.mad.clique.controller.EventsController;
import de.hsos.mad.clique.models.Event;

/**
 * Created by davidherzog on 16.08.16.
 */
public class EventsRepository {

    private static EventsRepository instance = null;

    private ArrayList<Event> mockedEvents;

    private EventsRepository() {
        this.mockedEvents = new ArrayList<>();
    }

    public static synchronized EventsRepository getInstance() {
        if (instance == null) {
            instance = new EventsRepository();
        }
        return instance;
    }

    public ArrayList<Event> getEventsPerUserAndClique() {
        //Get the User and Clique ID per actual... variable in corresponding controller

        Event event1 = new Event(1, 10, "Grillen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", true, false, false);
        Event event2 = new Event(2, 10, "Feiern", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", false, true, false);
        Event event3 = new Event(3, 10, "Chillen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", false, false, true);
        Event event4 = new Event(4, 10, "Kekse backen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", true, false, false);
        Event event5 = new Event(5, 10, "Reis kochen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", false, false, true);

        mockedEvents.add(event1);
        mockedEvents.add(event2);
        mockedEvents.add(event3);
        mockedEvents.add(event4);
        mockedEvents.add(event5);

        return this.mockedEvents;
    }

    public void createNewEvent(int eCliqueId, String eName, String eStreet, int eStreetNr, int eZip,
                               String eCity, String eDesc, String eDate) {
        //Restful aufruf mit den parametern und so...
        Event newEvent = new Event(this.mockedEvents.size(), eCliqueId,eName, eStreet, eStreetNr,
                eZip, eCity, eDesc, eDate, true, false, false);
        EventsController.getInstance().addOpenEvent(newEvent);
    }
}
