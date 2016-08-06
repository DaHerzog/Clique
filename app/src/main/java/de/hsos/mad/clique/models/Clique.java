package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 03.08.16.
 */
public class Clique {

    private String name;

    public Clique(String pName) {
        this.name = pName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
