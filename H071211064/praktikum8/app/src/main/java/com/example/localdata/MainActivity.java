package com.example.localdata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.localdata.db.DatabaseHelper;
import com.example.localdata.db.adapter.PersonAdapter;
import com.example.localdata.db.entity.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private PersonAdapter personAdapter;
    private ArrayList<com.example.localdata.db.entity.Person> personList  = new ArrayList<com.example.localdata.db.entity.Person>();
    private RecyclerView recyclerView;
    private DatabaseHelper db;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Person Information");

        recyclerView = findViewById(R.id.recycler_view_contacts);
        db = new DatabaseHelper(this);
        personList = db.getAllPerson();
        personAdapter = new PersonAdapter(this, personList,MainActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(personAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> addAndEditContacts(false, null, -1));

        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                personList = db.searchPerson(newText);
                personAdapter = new PersonAdapter(MainActivity.this, personList,MainActivity.this);
                recyclerView.setAdapter(personAdapter);
                return true;
            }
        });

    }

    public void addAndEditContacts(final boolean isUpdated,final Person person,final int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(getApplicationContext());
        View view = layoutInflater.inflate(R.layout.layout_add_person,null);

        AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alerDialogBuilder.setView(view);

        TextView contactTitle = view.findViewById(R.id.new_contact_title);
        final EditText newPerson = view.findViewById(R.id.name);
        final EditText titlePerson= view.findViewById(R.id.titlePerson);
        contactTitle.setText(!isUpdated ? "Add New Person" : "Edit Person");
        if (isUpdated && person != null){
            newPerson.setText(person.getName());
            titlePerson.setText(person.getTitle());
        }

        alerDialogBuilder.setCancelable(false)
                .setPositiveButton(isUpdated ? "Update" : "Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Delete",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (isUpdated){
                                    DeletePerson(person, position);
                                }else{
                                    dialogInterface.cancel();
                                }
                            }
                        }
                );

        final AlertDialog alertDialog = alerDialogBuilder.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(newPerson.getText().toString())){
                    Toast.makeText(MainActivity.this, "Please Enter a Name", Toast.LENGTH_SHORT).show();

                    return;
                }else{
                    alertDialog.dismiss();
                }

                if (isUpdated && person != null){
                    UpdateContact(newPerson.getText().toString(), titlePerson.getText().toString(),position);

                }else{
                    CreatePerson(newPerson.getText().toString(), titlePerson.getText().toString());

                }

            }
        });
    }
    private void DeletePerson(Person person, int position) {

       personList.remove(position);
        db.deletePerson(person);
        personAdapter.notifyDataSetChanged();


    }
    private void UpdateContact(String name, String title, int position){
        Person person = personList.get(position);
        person.setName(name);
        person.setTitle(title);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String strDate = formatter.format(date);
        person.setCreated_at("Edited at: " + strDate);
        db.updatePerson(person);

        personList.set(position, person);
        personAdapter.notifyDataSetChanged();


    }


    private void CreatePerson(String name, String title){

        long id = db.insertPerson(name, title);
        Person person = db.getPerson(id);

        if (person != null){
            personList.add(0, person);
            personAdapter.notifyDataSetChanged();
        }

    }
}