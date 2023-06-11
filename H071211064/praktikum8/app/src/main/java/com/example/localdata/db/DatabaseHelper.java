package com.example.localdata.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.localdata.db.entity.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "persons_db";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Person.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Person.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertPerson(String name, String title){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Person.COLUMN_NAME, name);
        values.put(Person.COLUMN_TITLE, title);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String strDate = formatter.format(date);

        values.put(Person.COLUMN_TIME, "Created at: " + strDate);
        long id = db.insert(Person.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Person getPerson(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Person.TABLE_NAME,
                new String[]{
                        Person.COLUMN_ID,
                        Person.COLUMN_NAME,
                        Person.COLUMN_TITLE,
                        Person.COLUMN_TIME},
                Person.COLUMN_ID + "=?",
                new String[]{
                        String.valueOf(id)
                },
                null,
                null,
                null,
                null);
        if (cursor != null)
            cursor.moveToFirst();
        Person person = new Person(
                cursor.getString(cursor.getColumnIndex(Person.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Person.COLUMN_TITLE)),
                cursor.getInt(cursor.getColumnIndex(Person.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Person.COLUMN_TIME))
        );
        cursor.close();
        return person;
    }

    public ArrayList<Person> getAllPerson(){
        ArrayList<Person> person = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + Person.TABLE_NAME + " ORDER BY " + Person.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            do{
                Person person1 = new Person();
                person1.setId(cursor.getInt(cursor.getColumnIndex(Person.COLUMN_ID)));
                person1.setName(cursor.getString(cursor.getColumnIndex(Person.COLUMN_NAME)));
                person1.setTitle(cursor.getString(cursor.getColumnIndex(Person.COLUMN_TITLE)));
                person1.setCreated_at(cursor.getString(cursor.getColumnIndex(Person.COLUMN_TIME)));
                person.add(person1);
            }while (cursor.moveToNext());
        }
        db.close();
        return person;

    }
    public int updatePerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Person.COLUMN_NAME, person.getName());
        values.put(Person.COLUMN_TITLE, person.getTitle());
        values.put(Person.COLUMN_TIME, person.getCreated_at());
        return db.update(Person.TABLE_NAME, values, Person.COLUMN_ID + "=?",
                new String[]{String.valueOf(person.getId())});
    }

    public void deletePerson(Person person){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Person.TABLE_NAME, Person.COLUMN_ID + "=?",
                new String[]{String.valueOf(person.getId())});
        db.close();
    }
    @SuppressLint("Range")
    public ArrayList<Person> searchPerson(String keyword){
        ArrayList<Person> personArrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + Person.TABLE_NAME + " WHERE " +
                Person.COLUMN_NAME + " LIKE '%" + keyword + "%'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                Person person = new Person();
                person.setId(cursor.getInt(cursor.getColumnIndex(Person.COLUMN_ID)));
                person.setName(cursor.getString(cursor.getColumnIndex(Person.COLUMN_NAME)));
                person.setTitle(cursor.getString(cursor.getColumnIndex(Person.COLUMN_TITLE)));
                person.setCreated_at(cursor.getString(cursor.getColumnIndex(Person.COLUMN_TIME)));


                personArrayList.add(person);

            }while(cursor.moveToNext());
        }

        db.close();

        return personArrayList;
    }
}
