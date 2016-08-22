package de.hsos.mad.clique.controller;

import android.content.Context;

import de.hsos.mad.clique.models.User;
import de.hsos.mad.clique.repositories.UserRepository;

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

    public void login(String email, String password, Context appCtx) {
        CliquenController.getInstance().getUsersCliques().clear();
        UserRepository.getInstance().login(email, password, appCtx);
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }
}
