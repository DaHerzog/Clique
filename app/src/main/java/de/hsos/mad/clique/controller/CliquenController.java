package de.hsos.mad.clique.controller;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import de.hsos.mad.clique.models.Clique;
import de.hsos.mad.clique.models.User;
import de.hsos.mad.clique.repositories.CliquenRepository;

/**
 * Created by davidherzog on 03.08.16.
 */
public class CliquenController {

    private static CliquenController instance = null;

    private List<Clique> usersCliques;

    private Clique currentlySelectedClique;

    private CliquenController() {
        this.usersCliques = new ArrayList<Clique>();
    }

    public static CliquenController getInstance() {
        if (instance == null) {
            instance = new CliquenController();
        }
        return instance;
    }

    public Clique[] getCliquesPerUser() {
        Clique[] returnedCliques = new Clique[this.usersCliques.size()];
        return this.usersCliques.toArray(returnedCliques);
    }

    public void addNewClique(String name, Context appCtx) {
        CliquenRepository.getInstance().addNewClique(name, appCtx);
    }

    public List<Clique> getUsersCliques() {
        return usersCliques;
    }

    public void setUsersCliques(List<Clique> usersCliques) {
        this.usersCliques = usersCliques;
    }

    public Clique getCurrentlySelectedClique() {
        return currentlySelectedClique;
    }

    public void setCurrentlySelectedClique(Clique currentlySelectedClique) {
        this.currentlySelectedClique = currentlySelectedClique;
    }


}
