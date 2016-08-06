package de.hsos.mad.clique.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hsos.mad.clique.R;
import de.hsos.mad.clique.controller.CliquenController;
import de.hsos.mad.clique.controller.UserController;
import de.hsos.mad.clique.models.Clique;


/**
 * Created by davidherzog on 06.08.16.
 */
public class CliquesAdapter extends RecyclerView.Adapter<CliquesAdapter.ViewHolder> {

    private Clique[] mUsersCliques = CliquenController.getInstance().getCliquesPerUser(UserController.getInstance().getActualUser());

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView mCliqueName;
        public ViewHolder(View v) {
            super(v);
            this.mCliqueName = (TextView) v.findViewById(R.id.clique_card_view_name);
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
    }

    @Override
    public int getItemCount() {
        return mUsersCliques.length;
    }
}
