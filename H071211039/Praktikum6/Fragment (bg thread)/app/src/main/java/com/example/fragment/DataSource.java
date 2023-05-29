package com.example.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class DataSource {
    public static ArrayList<Home> homes = new ArrayList<>(
            Arrays.asList(
//                    new Home("iniiistyy","Isty Hamdayani","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus bibendum tempor urna. Ut id molestie ipsum. Praesent tellus diam, efficitur ut purus sit amet, vulputate interdum nunc. ",R.drawable.istyy, null ),
                    new Home("Selvianiaml","Selviani Amalia Kartika","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus bibendum tempor urna. Ut id molestie ipsum. Praesent tellus diam, efficitur ut purus sit amet, vulputate interdum nunc. ",R.drawable.selvi,null),
                    new Home("bshriyuni","Besse Sahriyuni","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus bibendum tempor urna. Ut id molestie ipsum. Praesent tellus diam, efficitur ut purus sit amet, vulputate interdum nunc. ",R.drawable.uni,null),
                    new Home("adeliapsptaahl","Adelia Puspita hilal","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus bibendum tempor urna. Ut id molestie ipsum. Praesent tellus diam, efficitur ut purus sit amet, vulputate interdum nunc. ",R.drawable.adel,null),
                    new Home("astrinaawln","Astrina Wulan Putri","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus bibendum tempor urna. Ut id molestie ipsum. Praesent tellus diam, efficitur ut purus sit amet, vulputate interdum nunc. ",R.drawable.astrina,null)

            )
    );

    public static ArrayList<Home> getHomesByQueryName(String queryName) {
        ArrayList<Home> homesByQueryName = new ArrayList<>();
        for (Home home : homes) {
            String query = queryName.toLowerCase(Locale.ROOT);
            String fullname = home.getFullName().toLowerCase(Locale.ROOT);
            String username = home.getUsername().toLowerCase(Locale.ROOT);
            if (fullname.startsWith(query) || username.startsWith(query)) {
                homesByQueryName.add(home);
            }
        }
        return homesByQueryName;
    }



}
