package com.example.marvelcharacters.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.marvelcharacters.R;
import com.example.marvelcharacters.model.pojo.Result;
import com.example.marvelcharacters.view.adapter.CharactersAdapter;
import com.example.marvelcharacters.view.interfaces.ClickDetail;
import com.example.marvelcharacters.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements ClickDetail {
    private CharactersAdapter adapter;
    private RecyclerView recyclerView;
    private HomeViewModel homeViewModel;
    private ProgressBar progressBar;
    private List<Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        setLayoutRecycler();
        loadApi();
    }
    public void setLayoutRecycler(){
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    public void loadApi(){
        homeViewModel.getCharacterApi(1);

        homeViewModel.getMutable().observe(this, results -> {
            adapter.setUpdate(results);
        });

        homeViewModel.getLoading().observe(this, (Boolean loading) -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        homeViewModel.getError().observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG);
        });
    }

    public void initView(){
        adapter = new CharactersAdapter(results, this);
        recyclerView = findViewById(R.id.recycler_view_home);
        progressBar = findViewById(R.id.progress_bar);
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    }

    @Override
    public void clickTransition(Result result) {

    }
}
