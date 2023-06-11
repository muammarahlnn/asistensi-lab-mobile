package com.example.localdata.db.entity;

public class Person {
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "person_id";
    public static final String COLUMN_NAME = "person_name";
    public static final String COLUMN_TITLE = "person_title";
    public static final String COLUMN_TIME = "created_at";


    private String name;
    private String title;
    private int id;
    private String created_at;

    public Person(){

    }

    public Person(String name, String title, int id, String created_at) {
        this.name = name;
        this.title = title;
        this.id = id;
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_TITLE + " TEXT,"
                   + COLUMN_TIME + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
}
