package de.hsos.mad.clique.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.adapter.CliquesAdapter;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.repositories.CliquenRepository;

public class ShowCliquesActivity extends AppCompatActivity {

    static final int CREATE_CLIQUE_REQUEST = 1;

    private CliquesAdapter cliquesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cliques);

        //creation of the recyclerView with the several cliques
        RecyclerView cliqueList = (RecyclerView)findViewById(R.id.my_recycler_view);
        //performance improvement
        cliqueList.setHasFixedSize(true);
        LinearLayoutManager myLlm = new LinearLayoutManager(this);
        myLlm.setOrientation(LinearLayoutManager.VERTICAL);
        cliqueList.setLayoutManager(myLlm);
        //set the adapter
        this.cliquesAdapter = new CliquesAdapter();
        cliqueList.setAdapter(this.cliquesAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createCliqueIntent = new Intent(view.getContext(), CreateNewClique.class);
                startActivityForResult(createCliqueIntent, CREATE_CLIQUE_REQUEST);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_CLIQUE_REQUEST) {
            if (resultCode == RESULT_OK) {
                String cliqueName = data.getStringExtra("clique_name");
                String cliqueDescription = data.getStringExtra("clique_description");
                CliquenController.getInstance().addNewClique(cliqueName, cliqueDescription);
                this.cliquesAdapter.getActualCliques();
                this.cliquesAdapter.notifyDataSetChanged();
            } else if (resultCode == RESULT_CANCELED) {
                Log.w("DEBUG", "User canceled");
            }
        }
    }
}
