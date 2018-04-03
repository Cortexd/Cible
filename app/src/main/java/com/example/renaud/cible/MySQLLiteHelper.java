package com.example.renaud.cible;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Classe utilitaire de creation de base de données
//
public abstract class MySQLLiteHelper extends SQLiteOpenHelper
{


 /*  CREATE TABLE artist(
            artistid    INTEGER PRIMARY KEY,
            artistname  TEXT
    );
    CREATE TABLE track(
            trackid     INTEGER,
            trackname   TEXT,
            trackartist INTEGER     -- Must map to an artist.artistid!
    );*/


    public static final String TABLE_SESSIONS = "tb_session";
    public static final String COLUMN_SESSION_ID = "session_id";
    public static final String COLUMN_SESSION_DATE = "session_date";
    public static final String COLUMN_SESSION_COMMENT = "session_comment";
    public static final String COLUMN_SESSION_SOMME = "session_somme";
    public static final String COLUMN_SESSION_NB_TIR = "session_nb_tir";

    public static final String TABLE_RESULTAT = "tb_resultat";
    public static final String COLUMN_RESULTAT_ID = "resultat_id";
    public static final String COLUMN_RESULTAT_SESSION = "resultat_session";
    public static final String COLUMN_RESULTAT_LIST = "resultat_list";


    private static final String DATABASE_NAME = "resultatstirs.db";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE_TABLE_SESSION = "create table "
            + TABLE_SESSIONS + "("
            + COLUMN_SESSION_ID + " integer primary key autoincrement, "
            + COLUMN_SESSION_DATE + " text not null, "
            + COLUMN_SESSION_COMMENT + " text not null,"
            + COLUMN_SESSION_SOMME + " integer not null,"
            + COLUMN_SESSION_NB_TIR + " integer not null "
            + ");";

    private static final String DATABASE_CREATE_TABLE_RESULTAT = "create table "
            + TABLE_RESULTAT + "("
            + COLUMN_RESULTAT_ID + " integer primary key autoincrement, "
            + COLUMN_RESULTAT_SESSION + " integer not null, "
            + COLUMN_RESULTAT_LIST + " text not null,"
            + " FOREIGN KEY ("+COLUMN_RESULTAT_SESSION+") REFERENCES "+TABLE_SESSIONS+"("+COLUMN_SESSION_ID+"));";

    public MySQLLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_TABLE_SESSION);
        database.execSQL(DATABASE_CREATE_TABLE_RESULTAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(MySQLLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SESSIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULTAT);

        onCreate(db);

    }
}
