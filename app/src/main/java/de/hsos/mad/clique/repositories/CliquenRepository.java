package de.hsos.mad.clique.repositories;

import java.util.ArrayList;

import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.models.Clique;

/**
 * Created by davidherzog on 03.08.16.
 */
public class CliquenRepository {

    private static CliquenRepository instance = null;

    private ArrayList<Clique> mockedCliques;

    private CliquenRepository() {
        this.mockedCliques = new ArrayList<Clique>();
        this.mockedCliques.add(new Clique(1, "Keksparty", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(2, "Blubb", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(3, "Grillen", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(4, "Nope", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(5, "Großes Nope", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(6, "hmmmm....", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(7, "Keksparty1", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(8, "Keksparty2", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(9, "Keksparty3", "peter", "wilder haufen"));
        this.mockedCliques.add(new Clique(10, "Keksparty4", "peter", "wilder haufen"));
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

    public void addNewClique(String name, String description) {
        //RESTful Request here...
        int newId = this.mockedCliques.get(this.mockedCliques.size()-1).getId()+1;
        String actualUser = UserController.getInstance().getActualUser().getmName();
        Clique newClique = new Clique(newId, name, actualUser, description);
        this.mockedCliques.add(newClique);

        //The selection of the id should happen on the server. But we need the id of the clique for
        //the events!
    }
}
