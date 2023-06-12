package com.example.whatsapp_ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class fragment_chats extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_chats);
        adapter = new RecyclerViewAdapter();

        // Set the LayoutManager for the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Set the Adapter for the RecyclerView
        recyclerView.setAdapter(adapter);

        // Populate the Adapter with data
        adapter.setData(getMyData());

        return view;
    }

    // Function to get some data to populate the RecyclerView
    private List<MyData> getMyData() {
        List<MyData> list = new ArrayList<>();
        list.add(new MyData("Item 1", R.drawable.flawless, new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:06"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("How you you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking! How about you are you doing well?", "12:08"));
        }}, "081234567891", "Busy1", "January 1, 2021"));
        list.add(new MyData("Item 2", R.drawable.crybaby, new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:06"));
            add(new MyChats("How are you?", "12:07"));
        }}, "081234567892", "Busy2", "January 2, 2021"));
        list.add(new MyData("Item 3", R.drawable.patrick_star, new ArrayList<MyChats>() {{
            add(new MyChats("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean quis molestie eros. In hendrerit nunc consequat magna eleifend, ut viverra libero egestas. Donec dui dui, porta ac purus non, condimentum consectetur tortor. Morbi placerat risus ac orci vehicula consequat. Nam commodo tempor nisl nec a", "12:06"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("Donec ullamcorper, diam at sodales ornare, turpis nisl ultrices justo, sed tempor nunc erat dictum ex. Nunc auctor, felis nec rhoncus faucibus, urna felis ornare nisi, ut fringilla mi tortor et lectus. Aliquam erat volutpat. Aliquam erat volutpat. Integer sed porttitor metus. Nunc condimentum massa a condimentum pharetra. Phasellus varius leo et justo pretium vestibulum. Vivamus in nulla congue, fringilla nibh a, facilisis dui. Donec quis risus ligula. Vestibulum dapibus dignissim est, ut interdum diam scelerisque ut. Curabitur ac pretium sapien", "12:07"));
            add(new MyChats(" posuere a justo et tincidunt. Mauris ex nunc, accumsan at diam non, consectetur pretium turpis. Cras nec mauris augue. Nunc finibus dictum lorem, non ornare sapien mattis quis. Sed condimentum suscipit sem quis scelerisque. Morbi molestie purus sit amet euismod ultrices. Quisque tempus, ", "12:07"));
            add(new MyChats("Fusce sit amet semper nisl. Morbi rhoncus finibus mollis. Praesent sagittis consequat ullamcorper. Integer nibh neque, ornare in tortor ac, pellentesque", "12:07"));
        }}, "081234567893", "Busy3", "January 3, 2021"));
        list.add(new MyData("Item 4", R.drawable.squidward, new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:07"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking!", "12:07"));
        }}, "081234567894", "Busy4", "January 4, 2021"));
        list.add(new MyData("Item 5", new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:07"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking!", "12:07"));
        }}, "081234567895", "Busy5", "January 5, 2021"));
        list.add(new MyData("Item 6", new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:07"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking!", "12:07"));
        }}, "081234567896", "Busy6", "January 6, 2021"));
        list.add(new MyData("Item 7", new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:07"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking!", "12:07"));
        }}, "081234567897", "Busy7", "January 7, 2021"));
        list.add(new MyData("Item 8", new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:07"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking!", "12:07"));
        }}, "081234567898", "Busy8", "January 8, 2021"));
        list.add(new MyData("Item 9", new ArrayList<MyChats>() {{
            add(new MyChats("Hello there!", "12:07"));
            add(new MyChats("How are you?", "12:07"));
            add(new MyChats("I'm doing well, thanks for asking!", "12:07"));
        }}, "081234567899", "Busy9", "January 9, 2021"));
        return list;
    }
}