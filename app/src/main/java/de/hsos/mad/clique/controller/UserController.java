package de.hsos.mad.clique.controller;

import de.hsos.mad.clique.models.User;

/**
 * Created by davidherzog on 06.08.16.
 */
public class UserController {

    private static UserController instance = null;

    private User actualUser;

    private UserController() {

    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }
}
