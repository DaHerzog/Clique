package de.hsos.mad.clique.repositories;

import de.hsos.mad.clique.models.Clique;

/**
 * Created by davidherzog on 03.08.16.
 */
public class CliquenRepository {

    private static CliquenRepository instance = null;

    private CliquenRepository() {

    }

    public static CliquenRepository getInstance() {
        if (instance == null) {
            instance = new CliquenRepository();
        }
        return instance;
    }

    public Clique[] getCliquesForUserId(int pUserId) {
        //RESTful Request here....
        Clique[] returnCliques = {new Clique(1, "Keksparty"), new Clique(2, "Blubb"), new Clique(3, "Grillen"),
                new Clique(4, "Nope"), new Clique(5, "Großes Nope"), new Clique(6, "hmmmm...."), new Clique(7, "Keksparty"),
                new Clique(8, "Keksparty"), new Clique(9, "Keksparty"), new Clique(10, "Keksparty")};
        return returnCliques;
    }
}
