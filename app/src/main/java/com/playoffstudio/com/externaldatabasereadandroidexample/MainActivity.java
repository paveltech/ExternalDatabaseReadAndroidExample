package com.playoffstudio.com.externaldatabasereadandroidexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.adapter.MyAdapter;
import com.databse.DatabaseAccess;
import com.databse.DatabaseOpenHelper;
import com.pojo.Pojo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.favourite_recycler_view)
    RecyclerView recyclerView;

    public MyAdapter adapter;
    public List<Pojo> pojoList;
    public DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        pojoList = new ArrayList<>();

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        pojoList = databaseAccess.getEmploye();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyAdapter(getApplicationContext() , pojoList);
        recyclerView.setAdapter(adapter);


    }

}
