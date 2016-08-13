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
        this.mockedCliques.add(new Clique("Keksparty", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Blubb", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Grillen", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Nope", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Großes Nope", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("hmmmm....", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Keksparty1", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Keksparty2", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Keksparty3", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique("Keksparty4", "peter", "wilder haufen"));
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

    public void addNewClique(Clique pClique) {
        //RESTful Request here...
        pClique.setId(this.mockedCliques.get(this.mockedCliques.size()-1).getId()+1);
        this.mockedCliques.add(pClique);

        //The selection of the id should happen on the server. But we need the id of the clique for
        //the events!
    }
}
