package de.hsos.mad.clique.repositories;

import java.util.ArrayList;

import de.hsos.mad.clique.models.Event;

/**
 * Created by davidherzog on 16.08.16.
 */
public class EventsRepository {

    private static EventsRepository instance = null;

    private EventsRepository() {

    }

    public static EventsRepository getInstance() {
        if (instance == null) {
            instance = new EventsRepository();
        }
        return instance;
    }

    public ArrayList<Event> getEventsPerUserAndClique() {
        //Get the User and Clique ID per actual... variable in corresponding controller

        ArrayList<Event> returnList = new ArrayList<>();

        Event event1 = new Event(1, 10, "Grillen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", true, false, false);
        Event event2 = new Event(2, 10, "Feiern", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", false, true, false);
        Event event3 = new Event(3, 10, "Chillen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", false, false, true);
        Event event4 = new Event(4, 10, "Kekse backen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", true, false, false);
        Event event5 = new Event(5, 10, "Reis kochen", "Neuenkampsweg", 24, 26169, "Friesoythe", "Gemuetliches Grillen", "22.08.2016", false, false, true);

        returnList.add(event1);
        returnList.add(event2);
        returnList.add(event3);
        returnList.add(event4);
        returnList.add(event5);

        return returnList;
    }
}
