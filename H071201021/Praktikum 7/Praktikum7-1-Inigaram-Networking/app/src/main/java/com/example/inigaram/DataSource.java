package com.example.inigaram;

import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {
    public static ArrayList<Post> posts = new ArrayList<>();

//    private static ArrayList<Post> generateDummyPosts() {
//        ArrayList<Post> posts = new ArrayList<>();
//        // Add dummy posts manually
////        posts.add(new Post("Monkey D. Luffy", "SHP01", "https://cdnwpseller.gramedia.net/wp-content/uploads/2023/02/luffy.jpg", "SHP01", "https://cdnwpseller.gramedia.net/wp-content/uploads/2023/02/luffy.jpg"));
////        posts.add(new Post("Roronoa Zoro", "SHP02", "https://i.pinimg.com/736x/1d/f2/bb/1df2bb83a6911b6f97e42119d38ee8b6.jpg", "SHP02", "https://i.pinimg.com/736x/1d/f2/bb/1df2bb83a6911b6f97e42119d38ee8b6.jpg"));
////        posts.add(new Post("Nami", "SHP03", "https://cdn.idntimes.com/content-images/community/2021/12/fromandroid-28b0f5dbcfc79a65664150939f01560c_600x400.jpg", "SHP03", "https://cdn.idntimes.com/content-images/community/2021/12/fromandroid-28b0f5dbcfc79a65664150939f01560c_600x400.jpg"));
////        posts.add(new Post("Usopp", "SHP04", "https://imgx.sonora.id/crop/0x0:0x0/700x465/photo/2021/12/09/usoppjpg-20211209053848.jpg", "SHP04", "https://imgx.sonora.id/crop/0x0:0x0/700x465/photo/2021/12/09/usoppjpg-20211209053848.jpg"));
////        posts.add(new Post("Sanji", "SHP05", "https://www.wikwiw.com/wp-content/uploads/2022/08/Vinsmoke-Sanji-One-Piece-1-1-660x330.jpg", "SHP05", "https://www.wikwiw.com/wp-content/uploads/2022/08/Vinsmoke-Sanji-One-Piece-1-1-660x330.jpg"));
////        posts.add(new Post("Tony Tony Chopper", "SHP06", "https://api.duniagames.co.id/api/content/upload/file/19162337861574314437.jpg", "SHP06", "https://api.duniagames.co.id/api/content/upload/file/19162337861574314437.jpg"));
////        posts.add(new Post("Nico Robin", "SHP07", "https://assets.kompasiana.com/items/album/2021/10/10/nico-robin-6162fde16e7f010ca309c532.png", "SHP07", "https://assets.kompasiana.com/items/album/2021/10/10/nico-robin-6162fde16e7f010ca309c532.png"));
////        posts.add(new Post("Franky", "SHP08", "https://cdn.idntimes.com/content-images/duniaku/post/20200824/franky-one-piece-488432631fd987199787c01f9ab6266a.jpg", "SHP08", "https://cdn.idntimes.com/content-images/duniaku/post/20200824/franky-one-piece-488432631fd987199787c01f9ab6266a.jpg"));
////        posts.add(new Post("Brook", "SHP09", "https://cdn.idntimes.com/content-images/duniaku/post/20211022/brook-b64a756321e9b224b3225bd373b149cc.jpg", "SHP09", "https://cdn.idntimes.com/content-images/duniaku/post/20211022/brook-b64a756321e9b224b3225bd373b149cc.jpg"));
////        posts.add(new Post("Jimbei", "SHP10", "https://www.greenscene.co.id/wp-content/uploads/2020/02/Jinbe.jpg", "SHP10", "https://www.greenscene.co.id/wp-content/uploads/2020/02/Jinbe.jpg"));
//        return posts;
//    }

//    public static void fetchPosts(final PostAdapter postAdapter, final StoryAdapter storyAdapter) {
//        Call<DataResponse> client = ApiConfig.getApiService().getUsers("12");
//        client.enqueue(new Callback<DataResponse>() {
//            @Override
//            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        List<UserResponse> userResponse = response.body().getData();
//                        System.out.println(userResponse);
////                        posts.clear();
//                        for (UserResponse user : userResponse) {
//                            System.out.println(user);
//                            Post post = new Post(user.getFirstName(), user.getEmail(), user.getAvatarUrl(), String.valueOf(user.getId()), user.getAvatarUrl());
//                            posts.add(post);
//                        }
//                        // Update the adapters with the new data
//                        postAdapter.notifyDataSetChanged();
//                        storyAdapter.notifyDataSetChanged();
//                    }
//                } else {
//                    if (response.body() != null) {
//                        Log.e("DataSource", "onFailure: " + response.message());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DataResponse> call, Throwable t) {
//                Log.e("DataSource", "onFailure: " + t.getMessage());
//            }
//        });
//    }

}
