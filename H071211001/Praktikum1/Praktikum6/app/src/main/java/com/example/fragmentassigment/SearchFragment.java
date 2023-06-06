package com.example.fragmentassigment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SearchFragment extends Fragment {

    private EditText etSearch;
    private ImageView ivCancelSearch;
    private ProgressBar pbUser;
    private RecyclerView rvUser;
    private UserAdapter adapter;

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        return view;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etSearch = view.findViewById(R.id.et_search);
        ivCancelSearch = view.findViewById(R.id.iv_cancelSearch);
        pbUser = view.findViewById(R.id.pb_user);
        rvUser = view.findViewById(R.id.rv_user);
        adapter = new UserAdapter();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);

        etSearch.setHorizontallyScrolling(true);

        pbUser.setVisibility(View.GONE);
        ivCancelSearch.setVisibility(View.GONE);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchData(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ivCancelSearch.setVisibility(View.VISIBLE);
                pbUser.setVisibility(View.VISIBLE);
            }
        });

        ivCancelSearch.setOnClickListener(v -> {
            etSearch.setText("");
        });
    }

    private void searchData(CharSequence charSequence) {
        pbUser.setVisibility(View.VISIBLE);
        rvUser.setVisibility(View.GONE);

        Executor executor = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            handler.post(() -> {
                if (TextUtils.isEmpty(charSequence)) {
                    adapter.setDataList(new ArrayList<>());
                } else {
                    adapter.setDataList(PostDataSource.searchPostModels(charSequence.toString()));
                }
                adapter.notifyDataSetChanged();
                pbUser.setVisibility(View.GONE);
                rvUser.setVisibility(View.VISIBLE);
            });
        });
    }
}