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

    public int getId() {
        return this.id;
    }

    public void setId(int pId) {
        this.id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
