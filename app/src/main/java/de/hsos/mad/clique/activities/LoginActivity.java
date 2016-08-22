package de.hsos.mad.clique.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.interfaces.MyCallbackInterface;
import de.hsos.mad.clique.models.User;

public class LoginActivity extends AppCompatActivity implements MyCallbackInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void navigateToRegisterActivity(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void navigateToShowCliquesActivity(View view) {
        TextView email = (TextView)findViewById(R.id.loginEmail);
        TextView pw = (TextView)findViewById(R.id.loginPassword);

        UserController.getInstance().login(email.getText().toString(), pw.getText().toString(), this);
    }

    public void dataReady() {
        startActivity(new Intent(this, ShowCliquesActivity.class));
    }
}
