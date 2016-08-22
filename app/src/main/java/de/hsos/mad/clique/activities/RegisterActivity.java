package de.hsos.mad.clique.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.interfaces.MyCallbackInterface;
import de.hsos.mad.clique.models.User;
import de.hsos.mad.clique.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity implements MyCallbackInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void executeRegistration(View view) {
        //Check for an existing user @ DB and so on....
        TextView name = (TextView)findViewById(R.id.registerName);
        TextView surName = (TextView)findViewById(R.id.registerSurname);
        TextView email = (TextView)findViewById(R.id.registerEmail);

        TextView password = (TextView)findViewById(R.id.registerPassword);
        TextView passwordRepeated = (TextView)findViewById(R.id.registerRepeatPassword);

        if (password.getText().toString().equals(passwordRepeated.getText().toString())) {
            String userName = name.getText().toString() + " " + surName.getText().toString();
            String eMailString = email.getText().toString();
            String passwordString = password.getText().toString();
            User newUser = new User(userName, eMailString);
            if (UserRepository.getInstance().createNewUser(newUser, passwordString, this)) {
                Toast.makeText(this.getApplicationContext(), "Erfolgreich registriert",
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this.getApplicationContext(), "Passwörter stimmen nicht überein",
                    Toast.LENGTH_SHORT).show();

        }
    }

    public void backToLoginFromRegistration(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void dataReady() {
        finish();
    }
}
