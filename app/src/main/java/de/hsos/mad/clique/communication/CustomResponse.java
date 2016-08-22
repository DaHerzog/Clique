package de.hsos.mad.clique.communication;

/**
 * Created by davidherzog on 22.08.16.
 */
public class CustomResponse {

    boolean success;

    public CustomResponse(boolean pBool) {
        this.success = pBool;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
