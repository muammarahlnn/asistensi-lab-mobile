package com.attar.fragmentassignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class DataSource {

    private static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas egestas rhoncus urna, luctus varius erat dignissim sit amet. Curabitur sagittis dolor vel ornare sagittis. Etiam egestas orci ornare, consequat arcu ac, porta erat. Praesent mauris orci, scelerisque vitae lectus ut, venenatis vulputate ex";

    public static void addUser(User user){
        users.add(0, user);
    }

    public static ArrayList<User> getUsersByQueryName(String queryName) {
        ArrayList<User> filteredUser = new ArrayList<>();
        for (User user : users){
            String query = queryName.toLowerCase(Locale.ROOT);
            String username = user.getUsername().toLowerCase(Locale.ROOT);
            String fullname = user.getFullname().toLowerCase(Locale.ROOT);
            if (username.startsWith(query) || fullname.startsWith(query)){
                filteredUser.add(user);
            }
        }
        return filteredUser;
    }
    public static ArrayList<User>users = new ArrayList<>(
            Arrays.asList(
                    new User(
                            "Lionel Messi",
                            "Messi",
                            R.drawable.messiarg,
                            new Post(
                                null,
                                    lorem
                            )

                    ),
                    new User(
                            "Muhammad Ali",
                            "Ali",
                            R.drawable.muhammadali,
                            new Post(
                                    null,
                                    lorem
                            )

                    ),
                    new User(
                            "Dembele",
                            "Dembele",
                            R.drawable.dembele,
                            new Post(
                                    null,
                                    lorem
                            )

                    ),
                    new User(
                            "Neymar Junior",
                            "Neymar",
                            R.drawable.neymar,
                            new Post(
                                    null,
                                    lorem
                            )

                    ),
                    new User(
                            "Kylian Mbappe",
                            "Mbappe",
                            R.drawable.mbappe,
                            new Post(
                                    null,
                                    lorem
                            )

                    )
            )
    );
}
