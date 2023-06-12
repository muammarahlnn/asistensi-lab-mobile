package com.example.sqlitedatabase;

import android.database.Cursor;

import java.util.ArrayList;

public class MappingHelper {
    public static ArrayList<Note> mapCursorToArrayList(Cursor cursor) {
        ArrayList<Note> notes = new ArrayList<>();
        while (cursor.moveToNext()) {
            int id =
                    cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumn._ID));
            String title =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumn.TITLE));
            String desc =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumn.DESC));
            String datePosted =
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.NoteColumn.DATE_POSTED));
            notes.add(new Note(id, title, desc, datePosted));
        }
        return notes;
    }
}
