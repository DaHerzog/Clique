package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 03.08.16.
 */
public class Clique {

    private long id;
    private String name;
    private String creator;
    private String description;

    public Clique(long pId, String pName, String pCreator) {
        this.id = pId;
        this.name = pName;
        this.creator = pCreator;
        this.description = "Hier könnte eine Beschreibung stehen!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
