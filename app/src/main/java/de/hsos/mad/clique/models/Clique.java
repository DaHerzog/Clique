package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 03.08.16.
 */
public class Clique {

    private int id;
    private String name;

    public Clique(int pId, String pName) {
        this.id = pId;
        this.name = pName;
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
}
