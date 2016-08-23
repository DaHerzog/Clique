package de.hsos.mad.clique.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.interfaces.MyCallbackInterface;

public class CreateNewClique extends AppCompatActivity implements MyCallbackInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_clique);
    }

    public void createCliqueAndReturn(View view) {
        TextView cliqueNameView = (TextView) findViewById(R.id.new_clique_input_name);

        String cliqueName = cliqueNameView.getText().toString();

        if (!cliqueName.isEmpty()) {
            Intent result = new Intent();
            result.putExtra("clique_name", cliqueName);
            CliquenController.getInstance().addNewClique(cliqueName, this);
            setResult(RESULT_OK, result);
        }
    }

    @Override
    public void dataReady() {
        finish();
    }
}
