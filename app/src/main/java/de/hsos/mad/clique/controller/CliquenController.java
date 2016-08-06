package de.hsos.mad.clique.controller;

import de.hsos.mad.clique.models.Clique;
import de.hsos.mad.clique.models.User;
import de.hsos.mad.clique.repositories.CliquenRepository;

/**
 * Created by davidherzog on 03.08.16.
 */
public class CliquenController {

    private static CliquenController instance = null;

    private CliquenController() {

    }

    public static CliquenController getInstance() {
        if (instance == null) {
            instance = new CliquenController();
        }
        return instance;
    }

    public Clique[] getCliquesPerUser(User pUser) {
        return CliquenRepository.getInstance().getCliquesForUserId(pUser.getId());
    }

}
