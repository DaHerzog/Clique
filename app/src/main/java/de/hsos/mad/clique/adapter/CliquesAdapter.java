package de.hsos.mad.clique.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.activities.ShowEventsActivity;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.models.Clique;


/**
 * Created by davidherzog on 06.08.16.
 */
public class CliquesAdapter extends RecyclerView.Adapter<CliquesAdapter.ViewHolder> {

    private Clique[] mUsersCliques = CliquenController.getInstance().getCliquesPerUser(UserController.getInstance().getActualUser());

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView mCliqueName;
        protected int cliqueId;
        protected CardView cardView;

        public ViewHolder(View v) {
            super(v);
            this.mCliqueName = (TextView) v.findViewById(R.id.clique_card_view_name);
            this.cardView = (CardView)v.findViewById(R.id.cliques_card_view);
            this.cardView.setOnClickListener(this);
        }

        public void setCliqueId(int pCliqueId) {
            this.cliqueId = pCliqueId;
        }

        public int getCliqueId() {
            return cliqueId;
        }

        public void onClick(View v) {
            //Log.w("Clique custom Log", String.valueOf(this.getCliqueId()));
            Intent goToEvents = new Intent(v.getContext(), ShowEventsActivity.class);
            goToEvents.putExtra("Clique_Id", this.getCliqueId());
            v.getContext().startActivity(goToEvents);
        }

    }

    public CliquesAdapter() {

    }

    public CliquesAdapter(Clique[] pUsersCliques) {
        this.mUsersCliques = pUsersCliques;
    }

    @Override
    public CliquesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.show_cliques_cardview, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Clique currClique = mUsersCliques[position];
        holder.mCliqueName.setText(currClique.getName());
        holder.setCliqueId(mUsersCliques[position].getId());
    }

    @Override
    public int getItemCount() {
        return mUsersCliques.length;
    }
}
