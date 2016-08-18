package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 10.08.16.
 */
public class Event {

    private int id;
    private int cliqueId;
    private String eventName;
    private String eventStreet;
    private int eventStreetNumber;
    private int eventZip;
    private String eventCity;
    private String eventDescription;
    private String eventDate;
    private boolean open;
    private boolean accepted;
    private boolean canceled;

    public Event(int pId, int pCliqueId, String pEventName, String pEventStreet, int pEventStreetNumber, int pEventZip, String pEventCity,
                    String pEventDescription, String pEventDate, boolean pOpen, boolean pAccepted, boolean pCanceled) {
        this.id = pId;
        this.cliqueId = pCliqueId;
        this.eventName = pEventName;
        this.eventStreet = pEventStreet;
        this.eventStreetNumber = pEventStreetNumber;
        this.eventZip = pEventZip;
        this.eventCity = pEventCity;
        this.eventDescription = pEventDescription;
        this.eventDate = pEventDate;
        this.open = pOpen;
        this.accepted = pAccepted;
        this.canceled = pCanceled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliqueId() {
        return cliqueId;
    }

    public void setCliqueId(int cliqueId) {
        this.cliqueId = cliqueId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventStreet() {
        return eventStreet;
    }

    public void setEventStreet(String eventStreet) {
        this.eventStreet = eventStreet;
    }

    public int getEventStreetNumber() {
        return eventStreetNumber;
    }

    public void setEventStreetNumber(int eventStreetNumber) {
        this.eventStreetNumber = eventStreetNumber;
    }

    public int getEventZip() {
        return eventZip;
    }

    public void setEventZip(int eventZip) {
        this.eventZip = eventZip;
    }

    public String getEventCity() {
        return eventCity;
    }

    public void setEventCity(String eventCity) {
        this.eventCity = eventCity;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
