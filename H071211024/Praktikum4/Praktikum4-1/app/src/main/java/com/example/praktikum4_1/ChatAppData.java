package com.example.praktikum4_1;

import java.util.ArrayList;

public class ChatAppData {
    private static String profileName[] = {
            "Serina",
            "Atsuko",
            "Mimori",
            "Yuuka",
            "Azusa",
            "Chise",
            "Izuna",
            "Chihiro",
            "Miyako",
    };
    private static String profileDetail[] = {
            "Has anyone been injured? I'll be there soon",
            "This hatred we've carried for as long as we can remember... it's not ours",
            "I'm still a rookie, but I will show you the results of my training...",
            "Lucky? No, it's just as calculated",
            "Even if everything is in vain, I will keep on struggling...",
            "I'm not sure, but it's nice to win!",
            "I'll present you Izuna-Style Ninjutsu!",
            "Something tells me my girls are at it again...",
            "This is RABBIT 1, we will now begin operations",
    };
    private static int profileImage[] = {
            R.drawable.picture1,
            R.drawable.picture2,
            R.drawable.picture3,
            R.drawable.picture4,
            R.drawable.picture5,
            R.drawable.picture6,
            R.drawable.picture7,
            R.drawable.picture8,
            R.drawable.picture9,
    };
    private static String profilestatus[] = {
            "I'll help you get healthy",
            "I've been learning the language of the flowers lately",
            "Take one step at a time",
            "Just as I calculated...",
            "et omnia vanitas",
            "Looking at the clouds",
            "Training hard! Nin nin!",
            "Let's make security checks a daily habit",
            "For the peace of kivotos!"
    };
    private static String profileNumber[] = {
            "+62-812-6969-4200",
            "+62-812-6969-4201",
            "+62-812-6969-4202",
            "+62-812-6969-4203",
            "+62-812-6969-4204",
            "+62-812-6969-4205",
            "+62-812-6969-4206",
            "+62-812-6969-4207",
            "+62-812-6969-4208",
    };
    static ArrayList<Data> getListData(){
        ArrayList<Data> list = new ArrayList<>();
        for (int i = 0; i < profileName.length; i++){
            Data data = new Data();
            data.setName(profileName[i]);
            data.setDetail(profileDetail[i]);
            data.setPhoto(profileImage[i]);
            data.setNumber(profileNumber[i]);
            data.setStatus(profilestatus[i]);
            list.add(data);
        }
        return list;
    }
}

