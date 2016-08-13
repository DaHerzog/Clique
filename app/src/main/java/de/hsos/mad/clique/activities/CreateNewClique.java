package de.hsos.mad.clique.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import de.hsos.mad.clique.R;

public class CreateNewClique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_clique);
    }

    public void createCliqueAndReturn(View view) {
        TextView cliqueNameView = (TextView) findViewById(R.id.new_clique_input_name);
        TextView cliqueDescView = (TextView) findViewById(R.id.new_clique_input_desc);

        String cliqueName = cliqueNameView.getText().toString();
        String cliqueDesc = cliqueDescView.getText().toString();

        if (!cliqueName.isEmpty() && !cliqueDesc.isEmpty()) {
            Intent result = new Intent();
            result.putExtra("clique_name", cliqueName);
            result.putExtra("clique_description", cliqueDesc);
            setResult(RESULT_OK, result);
            finish();
        }
    }
}
