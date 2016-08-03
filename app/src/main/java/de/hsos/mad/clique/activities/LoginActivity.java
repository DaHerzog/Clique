package de.hsos.mad.clique.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import de.hsos.mad.clique.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void navigateToRegisterActivity(View view) {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void navigateToShowCliquesActivity(View view) {
        //First check if the user has permissions to use this app @DB...
        startActivity(new Intent(this, ShowCliquesActivity.class));
    }
}
