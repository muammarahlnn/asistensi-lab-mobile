package com.attar.tugas4;

import java.util.ArrayList;

public class DataSource {


    public static ArrayList<Contact> contacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(
                new Contact("Monkey D.Luffy", "lorem ipsum dolar sit amet","23.24",R.drawable.baseline_account_circle_24)
        );
        contacts.add(
                new Contact("Roronoa zoro", "Lorem ipsum dolar sit amet", "22.09", R.drawable.baseline_account_circle_24)
        );
        contacts.add(
                new Contact("Nami", "Lorem ipsum dolar sit amet", "21.52", R.drawable.baseline_account_circle_24)
        );
        contacts.add(
                new Contact("Usopp", "Lorem ipsum dolar sit amet", "21.21", R.drawable.baseline_account_circle_24)
        );
        contacts.add(
                new Contact("Sanji", "Aut suscipit sequi et voluptates", "21.17", R.drawable.baseline_account_circle_24)
        );
        contacts.add(
                new Contact("Tony Tony Chopper", "Lorem ipsum dolar sit amet", "20.30", R.drawable.baseline_account_circle_24)
        );
        contacts.add(
                new Contact("Nico Robin", "Lorem ipsum dolar sit amet", "20.02", R.drawable.baseline_account_circle_24)
        );
        return contacts;
    }

    private static ArrayList<Chat> chats() {
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.00")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.01")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.02")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.03")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.04")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.05")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.06")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.07")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.08")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.09")
        );
        chats.add(
                new Chat("Lorem ipsum dollar sit amet","18.10")
        );
        return chats;
    }
}
