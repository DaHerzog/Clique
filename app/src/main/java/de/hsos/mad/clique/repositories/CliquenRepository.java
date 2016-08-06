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
        Clique[] returnCliques = {new Clique("Keksparty"), new Clique("Blubb"), new Clique("Grillen"),
                new Clique("Nope"), new Clique("Großes Nope"), new Clique("hmmmm...."), new Clique("Keksparty"),
                new Clique("Keksparty"), new Clique("Keksparty"), new Clique("Keksparty")};
        return returnCliques;
    }
}
