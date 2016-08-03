package de.hsos.mad.clique.controller;

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

}
