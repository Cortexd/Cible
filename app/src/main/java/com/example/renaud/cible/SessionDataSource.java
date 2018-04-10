package com.example.renaud.cible;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SessionDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLLiteHelper dbHelper;
    private String[] allColumns = {
            MySQLLiteHelper.COLUMN_SESSION_ID,
            MySQLLiteHelper.COLUMN_SESSION_DATE,
            MySQLLiteHelper.COLUMN_SESSION_NB_TIR,
            MySQLLiteHelper.COLUMN_SESSION_SOMME,
            MySQLLiteHelper.COLUMN_SESSION_COMMENT    };

    public SessionDataSource(Context context) {
        dbHelper = new MySQLLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }
//
//    public Session createComment(String comment) {
//        ContentValues values = new ContentValues();
//        values.put(MySQLLiteHelper.COLUMN_COMMENT, comment);
//        long insertId = database.insert(MySQLLiteHelper.TABLE_COMMENTS, null,
//                values);
//        Cursor cursor = database.query(MySQLLiteHelper.TABLE_COMMENTS,
//                allColumns, MySQLLiteHelper.COLUMN_ID + " = " + insertId, null,
//                null, null, null);
//        cursor.moveToFirst();
//        Session newComment = cursorToSession(cursor);
//        cursor.close();
//        return newComment;
//    }
//
//    public void deleteSession(Session session) {
//        long id = session.getSession_id();
//        System.out.println("Comment deleted with id: " + id);
//        database.delete(MySQLLiteHelper.TABLE_COMMENTS, MySQLLiteHelper.COLUMN_ID
//                + " = " + id, null);
//    }
//
//    public List<Session> getAllComments() {
//        List<Session> comments = new ArrayList<Session>();
//
//        Cursor cursor = database.query(MySQLLiteHelper.TABLE_COMMENTS,
//                allColumns, null, null, null, null, null);
//
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Session comment = cursorToSession(cursor);
//            comments.add(comment);
//            cursor.moveToNext();
//        }
//        // assurez-vous de la fermeture du curseur
//        cursor.close();
//        return comments;
//    }
//
//    private Session cursorToComment(Cursor cursor) {
//        Session comment = new Session();
//        comment.setSession_id(cursor.getLong(0));
//        comment.setComment(cursor.getString(1));
//        return comment;
//    }
}
