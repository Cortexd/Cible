package com.example.renaud.cible.Object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Renaud on 26/03/2018.
 */

public class CinqTir {

    List<Integer> resultats;
    Integer numero;

    public CinqTir(int numero)
    {
        resultats = new ArrayList<>();
        this.numero = numero;
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

    // Numero du tir
    public int GetNumero()
    {
        return this.numero;
    }

    // Met en forme la ligne pour affichage
    public String GetResultatLigne()
    {
        String retour = "";
        for (Integer resultat : resultats) {
            retour = retour + " " +  resultat;
        }

        retour = retour + " ( Tot : " + this.GetTotal() +"/" + this.GetMaxScore()  + " Moy : " + this.GetMoyenne() + ")";

        return retour;
    }

    // Met en forme la ligne pour la base
    public String GetResultatBases()
    {
        String retour = "";
        for (Integer resultat : resultats) {
            retour = retour + " " +  resultat;
        }

        return retour;
    }

    private int GetMaxScore()
    {
        if (this.resultats.size() > 0)
        {
            return this.resultats.size() * 10;
        }
        else
        {
            return 0;
        }
    }

    private int GetTotal()
    {
        int somme = 0;
        for (Integer resultat : resultats) {
            somme = somme + resultat;
        }

        return somme;
    }

    private String GetMoyenne()
    {
        if (this.resultats.size() > 0)
        {
            float m = (float)this.GetTotal() / (float)this.resultats.size();
            return String.format("%.2f",m);
        }
        else
        {
            return "-";
        }
    }

}
