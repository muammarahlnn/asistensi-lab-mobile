package com.example.ldatatask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

public class NoteDatabase extends SQLiteOpenHelper {

    public static final String database_name = "noteDatabase";
    public static final int database_version = 4;

    public static final String table_note = "note_table";
    public static final String id_note = "id";
    public static final String title = "title";
    public static final String time = "time";
    public static final String description = "description";

    private final SQLiteDatabase db;

    public NoteDatabase(@Nullable Context context) {
        super(context, database_name, null, database_version);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + table_note + " ("
                + id_note + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + title + " TEXT NOT NULL, "
                + time + " TIMESTAMP DEFAULT (datetime('now', 'localtime', 'start of month', '+1 month', '-1 second')), "
                + description + " TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("drop table if exists " + table_note);
    }

    public void insertNote(ContentValues values){
        db.insert(table_note, null, values);
    }

    public void updateNote(ContentValues values, long id){
        db.update(table_note, values, id_note + "=" + id, null);
    }

    public void deleteNote(long id){
        db.delete(table_note,id_note + "=" + id, null);
    }

    public Cursor getAllNote(){
        return db.query(table_note, null, null, null, null, null, id_note + " ASC");
    }

    public Cursor getNote(long id){
        return db.rawQuery("select * from " + table_note + " where " + id_note + "=" + id, null);
    }

    public Cursor searchNotes(String query) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = title + " LIKE ?";
        String[] selectionArgs = new String[]{"%" + query + "%"};
        return db.query(table_note, null, selection, selectionArgs, null, null, title + " ASC");
    }
}
