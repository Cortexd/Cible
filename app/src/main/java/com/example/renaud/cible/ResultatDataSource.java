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

//    public Comment createComment(String comment) {
//        ContentValues values = new ContentValues();
//        values.put(MySQLLiteHelper., comment);
//        long insertId = database.insert(MySQLLiteHelper.TABLE_COMMENTS, null,
//                values);
//        Cursor cursor = database.query(MySQLLiteHelper.TABLE_COMMENTS,
//                allColumns, MySQLLiteHelper.COLUMN_ID + " = " + insertId, null,
//                null, null, null);
//        cursor.moveToFirst();
//        Comment newComment = cursorToComment(cursor);
//        cursor.close();
//        return newComment;
//    }

//    public void deleteComment(Comment comment) {
//        long id = comment.getId();
//        System.out.println("Comment deleted with id: " + id);
//        database.delete(MySQLLiteHelper.TABLE_COMMENTS, MySQLLiteHelper.COLUMN_ID
//                + " = " + id, null);
//    }

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
//    private Comment cursorToComment(Cursor cursor) {
//        Comment comment = new Comment();
//        comment.setId(cursor.getLong(0));
//        comment.setComment(cursor.getString(1));
//        return comment;
//    }
}
