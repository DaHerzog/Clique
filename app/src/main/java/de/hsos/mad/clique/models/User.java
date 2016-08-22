package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 06.08.16.
 */
public class User {

    int id;
    String mName;
    String eMail;

    public User(String pName, String pEmail) {
        this.mName = pName;
        this.eMail = pEmail;
    }

    public int getId() {
        return id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
