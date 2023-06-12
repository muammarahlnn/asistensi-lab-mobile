package com.example.inigaram;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Profile> profiles = generateDummyProfiles();
    public static ArrayList<Post> posts = generateDummyPosts();

    private static ArrayList<Profile> generateDummyProfiles() {
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Monkey D. Luffy", "SHP01",  "https://cdnwpseller.gramedia.net/wp-content/uploads/2023/02/luffy.jpg"));
        profiles.add(new Profile("Roronoa Zoro", "SHP02", "https://i.pinimg.com/736x/1d/f2/bb/1df2bb83a6911b6f97e42119d38ee8b6.jpg"));
        profiles.add(new Profile("Nami", "SHP03", "https://cdn.idntimes.com/content-images/community/2021/12/fromandroid-28b0f5dbcfc79a65664150939f01560c_600x400.jpg"));
        profiles.add(new Profile("Usopp", "SHP04", "https://imgx.sonora.id/crop/0x0:0x0/700x465/photo/2021/12/09/usoppjpg-20211209053848.jpg"));
        profiles.add(new Profile("Sanji", "SHP05","https://www.wikwiw.com/wp-content/uploads/2022/08/Vinsmoke-Sanji-One-Piece-1-1-660x330.jpg"));
        profiles.add(new Profile("Tony Tony Chopper", "SHP06","https://api.duniagames.co.id/api/content/upload/file/19162337861574314437.jpg"));
        profiles.add(new Profile("Nico Robin", "SHP07",  "https://assets.kompasiana.com/items/album/2021/10/10/nico-robin-6162fde16e7f010ca309c532.png"));
        profiles.add(new Profile("Franky","SHP08", "https://cdn.idntimes.com/content-images/duniaku/post/20200824/franky-one-piece-488432631fd987199787c01f9ab6266a.jpg"));
        profiles.add(new Profile("Brook", "SHP09", "https://cdn.idntimes.com/content-images/duniaku/post/20211022/brook-b64a756321e9b224b3225bd373b149cc.jpg"));
        profiles.add(new Profile("Jimbei","SHP10", "https://www.greenscene.co.id/wp-content/uploads/2020/02/Jinbe.jpg"));
        return profiles;
    }

    private static ArrayList<Post> generateDummyPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("Monkey D. Luffy", "SHP01", "https://cdnwpseller.gramedia.net/wp-content/uploads/2023/02/luffy.jpg", "SHP01", "https://cdnwpseller.gramedia.net/wp-content/uploads/2023/02/luffy.jpg"));
        posts.add(new Post("Roronoa Zoro", "SHP02", "https://i.pinimg.com/736x/1d/f2/bb/1df2bb83a6911b6f97e42119d38ee8b6.jpg", "SHP02", "https://i.pinimg.com/736x/1d/f2/bb/1df2bb83a6911b6f97e42119d38ee8b6.jpg"));
        posts.add(new Post("Nami", "SHP03", "https://cdn.idntimes.com/content-images/community/2021/12/fromandroid-28b0f5dbcfc79a65664150939f01560c_600x400.jpg", "SHP03", "https://cdn.idntimes.com/content-images/community/2021/12/fromandroid-28b0f5dbcfc79a65664150939f01560c_600x400.jpg"));
        posts.add(new Post("Usopp", "SHP04", "https://imgx.sonora.id/crop/0x0:0x0/700x465/photo/2021/12/09/usoppjpg-20211209053848.jpg", "SHP04", "https://imgx.sonora.id/crop/0x0:0x0/700x465/photo/2021/12/09/usoppjpg-20211209053848.jpg"));
        posts.add(new Post("Sanji", "SHP05", "https://www.wikwiw.com/wp-content/uploads/2022/08/Vinsmoke-Sanji-One-Piece-1-1-660x330.jpg", "SHP05", "https://www.wikwiw.com/wp-content/uploads/2022/08/Vinsmoke-Sanji-One-Piece-1-1-660x330.jpg"));
        posts.add(new Post("Tony Tony Chopper", "SHP06", "https://api.duniagames.co.id/api/content/upload/file/19162337861574314437.jpg", "SHP06", "https://api.duniagames.co.id/api/content/upload/file/19162337861574314437.jpg"));
        posts.add(new Post("Nico Robin", "SHP07", "https://assets.kompasiana.com/items/album/2021/10/10/nico-robin-6162fde16e7f010ca309c532.png", "SHP07", "https://assets.kompasiana.com/items/album/2021/10/10/nico-robin-6162fde16e7f010ca309c532.png"));
        posts.add(new Post("Franky", "SHP08", "https://cdn.idntimes.com/content-images/duniaku/post/20200824/franky-one-piece-488432631fd987199787c01f9ab6266a.jpg", "SHP08", "https://cdn.idntimes.com/content-images/duniaku/post/20200824/franky-one-piece-488432631fd987199787c01f9ab6266a.jpg"));
        posts.add(new Post("Brook", "SHP09", "https://cdn.idntimes.com/content-images/duniaku/post/20211022/brook-b64a756321e9b224b3225bd373b149cc.jpg", "SHP09", "https://cdn.idntimes.com/content-images/duniaku/post/20211022/brook-b64a756321e9b224b3225bd373b149cc.jpg"));
        posts.add(new Post("Jimbei", "SHP10", "https://www.greenscene.co.id/wp-content/uploads/2020/02/Jinbe.jpg", "SHP10", "https://www.greenscene.co.id/wp-content/uploads/2020/02/Jinbe.jpg"));
        return posts;
    }
}
