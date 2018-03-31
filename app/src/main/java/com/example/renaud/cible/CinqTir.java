package com.example.renaud.cible;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Renaud on 26/03/2018.
 */

public class CinqTir {

    List<Integer> resultats;

    public CinqTir()
    {
        resultats = new ArrayList<>();
    }

    public void AjoutResultat(Integer resultat)
    {
        this.resultats.add(resultat);
    }

    public void EnleveLeDernierResultat()
    {
        if (this.resultats.size()>=1)
        {
            this.resultats.remove(this.resultats.size() - 1);
        }
    }

    public String GetResultatLigne()
    {
        String retour = "";
        for (Integer resultat : resultats) {
            retour = retour + " | " +  resultat;

        }
        return retour;

    }

}
