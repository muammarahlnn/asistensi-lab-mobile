package com.example.localdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NoteHelper {
    private static final String DATABASE_TABLE = DatabaseContract.TABLE_NAME;
    private static DatabaseHelper databaseHelper;
    private static SQLiteDatabase database;
    private static volatile NoteHelper INSTANCE;
    private NoteHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }
    public static NoteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NoteHelper(context);
                }
            }
        }
        return INSTANCE;
    }
    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }
    public void close() {
        databaseHelper.close();
        if (database.isOpen()) {
            database.close();
        }
    }
    public Cursor queryAll() {
//        ArrayList<Note> notesList = new ArrayList<>();
        return database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.NoteColumns._ID + " ASC"
        );
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Note notes = getNotesFromCursor(cursor);
//            notesList.add(notes);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return (Cursor) notesList;
    }
    private Note getNotesFromCursor(Cursor cursor) {
        Note notes = new Note();
        notes.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID)));
        notes.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE)));
        notes.setDescription(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION)));
        notes.setDate(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE)));
        return notes;
    }

    public Cursor queryById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.NoteColumns._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }
    public long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }
    public int update(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, DatabaseContract.NoteColumns._ID + " = ?", new String[]{id});
    }
    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, DatabaseContract.NoteColumns._ID + " = ?", new String[]{id});
    }

    public ArrayList<Note> searchNotes(String searchText) {
        ArrayList<Note> searchResults = new ArrayList<>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseContract.TABLE_NAME + " WHERE " + DatabaseContract.NoteColumns.TITLE + " LIKE '" + searchText + "%'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Note notes = getNotesFromCursor(cursor);
                searchResults.add(notes);
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        return searchResults;
    }
}
