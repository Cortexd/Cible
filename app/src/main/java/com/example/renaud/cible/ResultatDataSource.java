package com.example.renaud.cible;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Comment;

public class ResultatDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLLiteHelper dbHelper;
    private String[] allColumns = {
            MySQLLiteHelper.COLUMN_RESULTAT_ID,
            MySQLLiteHelper.COLUMN_RESULTAT_LIST,
            MySQLLiteHelper.COLUMN_RESULTAT_SESSION
    };

    public ResultatDataSource(Context context) {
        dbHelper = new MySQLLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

   public Resultat createResultat(Resultat resultat) {
        ContentValues values = new ContentValues();
        values.put(MySQLLiteHelper.COLUMN_RESULTAT_LIST, resultat.getResultat_list());
        values.put(MySQLLiteHelper.COLUMN_RESULTAT_SESSION, resultat.getResultat_session());

        long insertId = database.insert(MySQLLiteHelper.TABLE_RESULTAT, null,                values);
        Cursor cursor = database.query(MySQLLiteHelper.TABLE_RESULTAT,
                allColumns, MySQLLiteHelper.COLUMN_RESULTAT_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();
        Resultat newResultat = cursorToResultat(cursor);
        cursor.close();
        return newResultat;
    }

    public void deleteResultat(Resultat resultat) {
        long id = resultat.getResultat_id();
        System.out.println("Resultat deleted with id: " + id);
        database.delete(MySQLLiteHelper.TABLE_RESULTAT, MySQLLiteHelper.COLUMN_RESULTAT_ID                + " = " + id, null);
    }

//    public List<Comment> getAllComments() {
//        List<Comment> comments = new ArrayList<Comment>();
//
//        Cursor cursor = database.query(MySQLLiteHelper.TABLE_COMMENTS,
//                allColumns, null, null, null, null, null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Comment comment = cursorToComment(cursor);
//            comments.add(comment);
//            cursor.moveToNext();
//        }
//        // assurez-vous de la fermeture du curseur
//        cursor.close();
//        return comments;
//    }
//
    private Resultat cursorToResultat(Cursor cursor) {
        Resultat resultat = new Resultat();
        resultat.setResultat_id(cursor.getLong(0));
        resultat.setResultat_list(cursor.getString(1));
        resultat.setResultat_session(cursor.getLong(2));
        return resultat;
    }
}
