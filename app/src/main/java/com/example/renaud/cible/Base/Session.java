package com.example.renaud.cible.Base;

public class Session {

    private long session_id;
    private String session_date;
    private String session_comment;
    private int  session_somme;
    private int  session_nb_tir;


    public long getSession_id() {
        return session_id;
    }

    public void setSession_id(long session_id) {
        this.session_id = session_id;
    }

    public String getSession_date() {
        return session_date;
    }

    public void setSession_date(String session_date) {
        this.session_date = session_date;
    }

    public String getSession_comment() {
        return session_comment;
    }

    public void setSession_comment(String session_comment) {
        this.session_comment = session_comment;
    }

    public int getSession_somme() {
        return this.session_somme;
    }

    public void setSession_somme(int session_somme) {
        this.session_somme = session_somme;
    }

    public float getSession_moyenne() {

        if (this.session_nb_tir > 0) {
            float resultat = (float) this.session_somme / this.session_nb_tir;
            return Math.round(resultat * 100.0f) / 100.0f;

        } else {
            return 0;
        }

    }

    public int getSession_nb_tir() {
        return this.session_nb_tir;
    }

    public void setSession_nb_tir(int session_nb_tir) {
        this.session_nb_tir = session_nb_tir;
    }
}
