package com.example.renaud.cible.Base;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.renaud.cible.Object.CinqTir;

public class SessionDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLLiteHelper dbHelper;
    private String[] allColumnsSession = {
            MySQLLiteHelper.COLUMN_SESSION_ID,
            MySQLLiteHelper.COLUMN_SESSION_DATE,
            MySQLLiteHelper.COLUMN_SESSION_NB_TIR,
            MySQLLiteHelper.COLUMN_SESSION_SOMME,
            MySQLLiteHelper.COLUMN_SESSION_COMMENT    };

    private String[] allColumnsResultat = {
            MySQLLiteHelper.COLUMN_RESULTAT_ID,
            MySQLLiteHelper.COLUMN_RESULTAT_LIST,
            MySQLLiteHelper.COLUMN_RESULTAT_SESSION
    };


    Context context;

    public SessionDataSource(Context context) {
        context = context;
        dbHelper = new MySQLLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

   public Session createSession(Session session, List<CinqTir> cinqTirs) {

        ContentValues values = new ContentValues();
        values.put(MySQLLiteHelper.COLUMN_SESSION_DATE, session.getSession_date());
        values.put(MySQLLiteHelper.COLUMN_SESSION_COMMENT , session.getSession_comment());
        values.put(MySQLLiteHelper.COLUMN_SESSION_NB_TIR, session.getSession_nb_tir());
        values.put(MySQLLiteHelper.COLUMN_SESSION_SOMME, session.getSession_somme());

        long insertId = database.insert(MySQLLiteHelper.TABLE_SESSIONS , null, values);

        Cursor cursor = database.query(MySQLLiteHelper.TABLE_SESSIONS, allColumnsSession, MySQLLiteHelper.COLUMN_SESSION_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Session newSession = cursorToSession(cursor);
        cursor.close();



        //for (Resultat resultat: resultats)
        //{
        //    rsdata.createResultat(resultat);
        //}

       for (CinqTir tir : cinqTirs)
       {
           Resultat resultat = new Resultat();
           resultat.setResultat_list(tir.GetResultatBases());
           resultat.setResultat_session(insertId);
           createResultat(resultat);
       }


        return newSession;
    }

    public void deleteSession(Session session) {
        long id = session.getSession_id();
        System.out.println("Session deleted with id: " + id);
        database.delete(MySQLLiteHelper.TABLE_SESSIONS, MySQLLiteHelper.COLUMN_SESSION_ID
                + " = " + id, null);
    }

    public List<Session> getAllSessions() {List<Session> comments = new ArrayList<Session>();

        Cursor cursor = database.query(MySQLLiteHelper.TABLE_SESSIONS,
                allColumnsSession, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Session comment = cursorToSession(cursor);
            comments.add(comment);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return comments;
    }

    private Session cursorToSession(Cursor cursor) {
        Session session = new Session();
        session.setSession_id(cursor.getLong(0));
        session.setSession_date(cursor.getString(1));
        session.setSession_comment(cursor.getString(2));
        session.setSession_nb_tir(cursor.getInt(3));
        session.setSession_somme(cursor.getInt(4));
        return session;
    }

    public void createResultat(Resultat resultat) {
        ContentValues values = new ContentValues();
        values.put(MySQLLiteHelper.COLUMN_RESULTAT_LIST, resultat.getResultat_list());
        values.put(MySQLLiteHelper.COLUMN_RESULTAT_SESSION, resultat.getResultat_session());

        long insertId = database.insert(MySQLLiteHelper.TABLE_RESULTAT, null,                values);
//        Cursor cursor = database.query(MySQLLiteHelper.TABLE_RESULTAT,
//                allColumnsResultat, MySQLLiteHelper.COLUMN_RESULTAT_ID + " = " + insertId, null,
//                null, null, null);
//
//        cursor.moveToFirst();
//        Resultat newResultat = cursorToResultat(cursor);
//        cursor.close();
//        return newResultat;
    }

    public void deleteResultat(Resultat resultat) {
        long id = resultat.getResultat_id();
        System.out.println("Resultat deleted with id: " + id);
        database.delete(MySQLLiteHelper.TABLE_RESULTAT, MySQLLiteHelper.COLUMN_RESULTAT_ID                + " = " + id, null);
    }

    private Resultat cursorToResultat(Cursor cursor) {
        Resultat resultat = new Resultat();
        resultat.setResultat_id(cursor.getLong(0));
        resultat.setResultat_list(cursor.getString(1));
        resultat.setResultat_session(cursor.getLong(2));
        return resultat;
    }


}
