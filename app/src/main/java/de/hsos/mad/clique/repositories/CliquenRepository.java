package de.hsos.mad.clique.repositories;

import java.util.ArrayList;

import de.hsos.mad.clique.models.Clique;

/**
 * Created by davidherzog on 03.08.16.
 */
public class CliquenRepository {

    private static CliquenRepository instance = null;

    private ArrayList<Clique> mockedCliques;

    private CliquenRepository() {
        this.mockedCliques = new ArrayList<Clique>();
        this.mockedCliques.add(new Clique(1, "Keksparty"));
        this.mockedCliques.add(new Clique(2, "Blubb"));
        this.mockedCliques.add(new Clique(3, "Grillen"));
        this.mockedCliques.add(new Clique(4, "Nope"));
        this.mockedCliques.add(new Clique(5, "Großes Nope"));
        this.mockedCliques.add(new Clique(6, "hmmmm...."));
        this.mockedCliques.add(new Clique(7, "Keksparty1"));
        this.mockedCliques.add(new Clique(8, "Keksparty2"));
        this.mockedCliques.add(new Clique(9, "Keksparty3"));
        this.mockedCliques.add(new Clique(10, "Keksparty4"));
    }

    public static CliquenRepository getInstance() {
        if (instance == null) {
            instance = new CliquenRepository();
        }
        return instance;
    }

    public Clique[] getCliquesForUserId(int pUserId) {
        //RESTful Request here....
        Clique[] returnArray = new Clique[this.mockedCliques.size()];
        returnArray = mockedCliques.toArray(returnArray);
        return returnArray;
    }

    public void addNewClique(String name) {
        //RESTful Request here...
        int newId = this.mockedCliques.get(this.mockedCliques.size()-1).getId()+1;
        this.mockedCliques.add(new Clique(newId, name));

        //The selection of the id should happen on the server. But we need the id of the clique for
        //the events!
    }
}
