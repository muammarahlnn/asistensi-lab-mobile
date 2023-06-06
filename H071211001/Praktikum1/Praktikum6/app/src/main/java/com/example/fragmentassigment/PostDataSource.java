package com.example.fragmentassigment;

import java.util.ArrayList;

public class PostDataSource {

    public static ArrayList<PostModel> dataList = generateDataDummyPostModels();

    private static ArrayList<PostModel> generateDataDummyPostModels() {
        ArrayList<PostModel> dataList = new ArrayList<>();

        dataList.add(new PostModel("aamonn", "Aamon", "aku tidak pernah jelek.", "https://i.pinimg.com/474x/7e/64/04/7e64045e855b76999da1830f420798ef.jpg", "https://i.pinimg.com/474x/9e/b1/8c/9eb18cc7cb68daf1b58731639d89c0e2.jpg"));
        dataList.add(new PostModel("laylaaaa", "Layla", "aku tidak noob", "https://i.pinimg.com/564x/84/d9/2e/84d92ed6b673dbf98de29c087b2af9be.jpg", "https://i.pinimg.com/564x/f0/ab/f4/f0abf45f14eadf95296e530495772440.jpg"));
        dataList.add(new PostModel("hanabiii_", "Hanabi", "iloveyou.", "https://i.pinimg.com/564x/7a/25/ff/7a25ffb8bcaa25394633ef7467ca0bd9.jpg", "https://i.pinimg.com/564x/de/36/52/de36521ec4d81c0d9f35e3e9b7f1ad04.jpg"));
        dataList.add(new PostModel("hayaaakuun", "Hayabusa", "iloveyoutoo.", "https://i.pinimg.com/564x/ec/1f/b0/ec1fb02b7c0fd2a35e5f41f6946a2558.jpg", "https://i.pinimg.com/564x/b0/99/f7/b099f7ddd5fe9a821eced8526d299d33.jpg"));
        dataList.add(new PostModel("kaguraachan", "Kagura", "imissyou.", "https://i.pinimg.com/564x/94/b3/c1/94b3c1da5bbedb033d1d1b469c811610.jpg", "https://i.pinimg.com/564x/ea/87/ee/ea87ee5027a98f86debc22c328ddb1a6.jpg"));
        dataList.add(new PostModel("alucarddd", "Alucard", "hey miyaa", "https://i.pinimg.com/564x/ef/24/78/ef2478c61176991abe827ae73ef8c60e.jpg", "https://i.pinimg.com/564x/83/cc/fb/83ccfb1e954bdb5a7c045b1acbbaf460.jpg"));
        dataList.add(new PostModel("miyaaachan", "Miya", "hey aluu", "https://i.pinimg.com/564x/ca/f7/34/caf734fd3f4168fdfdf9fa41a50df720.jpg", "https://i.pinimg.com/564x/83/cc/fb/83ccfb1e954bdb5a7c045b1acbbaf460.jpg"));
        dataList.add(new PostModel("lunoxxxx", "Lunox", "hihiihi", "https://i.pinimg.com/564x/08/c1/00/08c1005f401addd774cb653892d509a7.jpg", "https://i.pinimg.com/564x/2a/32/bc/2a32bc8831c7aaa89350a7840cf8a649.jpg"));
        dataList.add(new PostModel("lancelottt", "Lancelot", "hai", "https://i.pinimg.com/564x/99/d3/d0/99d3d0b1b862f57d3f6f19a578cb9180.jpg", "https://i.pinimg.com/564x/e4/76/cf/e476cf0d084a51c48a291915d157f275.jpg"));
        dataList.add(new PostModel("odettt", "Odette", "hola", "https://i.pinimg.com/564x/be/e4/22/bee422a3462762bb089c2a1479e088ea.jpg", "https://i.pinimg.com/564x/54/ea/a1/54eaa1c762d9dd04440402ed19ae10e3.jpg"));
        dataList.add(new PostModel("rafaellaaa", "Rafaela", "heal for everyone", "https://i.pinimg.com/564x/bc/9c/b0/bc9cb091b47bcdebce3abc41bfc1d08a.jpg", "https://i.pinimg.com/564x/9d/f1/24/9df124714c56e3baca1e0526c745aae3.jpg"));

        return dataList;
    }

    public static ArrayList<PostModel> searchPostModels(String query) {
        ArrayList<PostModel> searchedPostModels = new ArrayList<>();

        for (int i = 0; i < dataList.size(); i++) {
            final PostModel postModel = dataList.get(i);
            String q = query.toLowerCase();
            String name = postModel.getName().toLowerCase();
            String username = postModel.getUsername().toLowerCase();
            if (name.startsWith(query) || username.startsWith(query)) {
                searchedPostModels.add(postModel);
            }
        }
        return searchedPostModels;
    }
}