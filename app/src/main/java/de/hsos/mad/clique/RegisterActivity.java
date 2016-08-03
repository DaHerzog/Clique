package de.hsos.mad.clique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void executeRegistration(View view) {
        //Check for an existing user @ DB and so on....
    }

    public void backToLoginFromRegistration(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
