package com.example.sqlitedatabase;

import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABLE_NAME = "notes";
    public static final class NoteColumn implements BaseColumns {
        public static String TITLE = "title";
        public static String DESC = "desc";
        public static String DATE_POSTED = "datePosted";

    }
}
