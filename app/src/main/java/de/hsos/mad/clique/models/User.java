package de.hsos.mad.clique.models;

/**
 * Created by davidherzog on 06.08.16.
 */
public class User {

    int id;
    String mName;
    String mSurName;

    public User(String pName, String pSurName) {
        this.mName = pName;
        this.mSurName = pSurName;
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

    public String getmSurName() {
        return mSurName;
    }

    public void setmSurName(String mSurName) {
        this.mSurName = mSurName;
    }
}
