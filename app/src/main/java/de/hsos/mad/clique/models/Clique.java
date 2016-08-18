package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 03.08.16.
 */
public class Clique {

    private int id;
    private String name;
    private String creator;
    private String description;

    public Clique(int pId, String pName, String pCreator, String pDesc) {
        this.id = pId;
        this.name = pName;
        this.creator = pCreator;
        this.description = pDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
