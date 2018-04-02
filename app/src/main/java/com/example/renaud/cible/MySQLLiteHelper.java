package com.example.renaud.cible;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/*
// Classe utilitaire de creation de base de données
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

   /*
    public static final String TABLE_SESSIONS = "tb_session";
    public static final String COLUMN_ID_SESSION = "_idSession";
    public static final String COLUMN_DATE_SESSION = "date";
    public static final String COLUMN_COMMENT_SESSION = "comment";

    public static final String TABLE_RESULTAT = "tb_resultat";
    public static final String COLUMN_ID_CINQ_TIR = "_idResultat";
    public static final String COLUMN_SESSION_CINQ_TIR = "_idResultat";
    public static final String COLUMN_RESULTATS = "0;1;2;5;10";

    private static final String DATABASE_NAME = "resultats.db";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE_TABLE_SESSION = "create table "
            + TABLE_SESSIONS + "("
            + COLUMN_ID_SESSION + " integer primary key autoincrement, "
            + COLUMN_DATE_SESSION + " , "
            + COLUMN_COMMENT_SESSION + " text not null);";

    private static final String DATABASE_CREATE_TABLE_RESULTAT = "create table "
            + TABLE_RESULTAT + "("
            + COLUMN_ID_CINQ_TIR + " integer primary key autoincrement, "
            + " FOREIGN KEY ("+TASK_CAT+") REFERENCES "+CAT_TABLE+"("+CAT_ID+"));";

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
}*/
