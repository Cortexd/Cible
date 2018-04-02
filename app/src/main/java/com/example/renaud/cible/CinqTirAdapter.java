package com.example.renaud.cible;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CinqTirAdapter extends ArrayAdapter<CinqTir> {

    //tweets est la liste des models à afficher
    public CinqTirAdapter(Context context, List<CinqTir> cinqTir) {
        super(context, 0, cinqTir);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_cinqtir,parent, false);
        }

        CinqTirViewHolder viewHolder = (CinqTirViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CinqTirViewHolder();
            viewHolder.numeroTir = (TextView) convertView.findViewById(R.id.numeroTir);
            viewHolder.valeurCinqTir = (TextView) convertView.findViewById(R.id.valeurCinqTir);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        CinqTir cinqTir = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.numeroTir.setText("" + cinqTir.GetNumero());
        viewHolder.valeurCinqTir.setText(cinqTir.GetResultatLigne());

        return convertView;
    }

    private class CinqTirViewHolder
    {
        public TextView numeroTir;
        public TextView valeurCinqTir;
    }
}