package de.hsos.mad.clique.activities;

import android.content.DialogInterface;
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
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.repositories.CliquenRepository;

public class ShowCliquesActivity extends AppCompatActivity {

    CliquesAdapter cliquesAdapter;

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
                //Neue Activity für neue Clique
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
