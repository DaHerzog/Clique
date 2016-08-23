package de.hsos.mad.clique.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.models.Clique;
import de.hsos.mad.clique.repositories.EventsRepository;


/**
 * Created by davidherzog on 06.08.16.
 */
public class CliquesAdapter extends RecyclerView.Adapter<CliquesAdapter.ViewHolder> {

    private Clique[] mUsersCliques;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView mCliqueName;
        protected Clique clique;
        protected CardView cardView;

        public ViewHolder(View v) {
            super(v);
            this.mCliqueName = (TextView) v.findViewById(R.id.clique_card_view_name);
            this.cardView = (CardView)v.findViewById(R.id.cliques_card_view);
            this.cardView.setOnClickListener(this);
        }

        public Clique getClique() {
            return clique;
        }

        public void setClique(Clique clique) {
            this.clique = clique;
        }

        @Override
        public void onClick(View v) {
            CliquenController.getInstance().setCurrentlySelectedClique(this.clique);
            EventsRepository.getInstance().getEventsPerUserAndClique(v.getContext());
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
        holder.setClique(mUsersCliques[position]);
    }

    @Override
    public int getItemCount() {
        return mUsersCliques.length;
    }

    public Clique[] getmUsersCliques() {
        return mUsersCliques;
    }

    public void setmUsersCliques(Clique[] mUsersCliques) {
        this.mUsersCliques = mUsersCliques;
    }

    public void getActualCliques() {
        this.mUsersCliques = CliquenController.getInstance().getCliquesPerUser();
    }
}
