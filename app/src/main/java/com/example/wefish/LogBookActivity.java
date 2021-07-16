package com.example.wefish;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fishingapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class LogBookActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    private ArrayList<String> ids, names, weights, heights;
    private FishAdapter fishAdapter;
    private FishDatabaseHelper fishDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);

        View parentLayout = findViewById(android.R.id.content);
        Snackbar.make(parentLayout, "Enter the fishes you caught here!", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }).setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = "Fish LogBook";
        toolbar.setTitle(title);

        recyclerView = findViewById(R.id.recyclerView);
        fab =  findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddFishActivity.class);
            startActivity(intent);
        });

        fishDBHelper = new FishDatabaseHelper(LogBookActivity.this);
        ids = new ArrayList<>();
        names = new ArrayList<>();
        weights = new ArrayList<>();
        heights = new ArrayList<>();



        showFishes();

        fishAdapter = new FishAdapter(  LogBookActivity.this, this, ids, names, weights, heights);

        recyclerView.setAdapter(fishAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LogBookActivity.this));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    private void showFishes() {
        Cursor cursor = fishDBHelper.readFishes();

        while (cursor.moveToNext()){
            ids.add(cursor.getString(0));
            names.add(cursor.getString(1));
            weights.add(cursor.getString(2));
            heights.add(cursor.getString(3));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_delete, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.deleteAll:
                FishDatabaseHelper bookDb = new FishDatabaseHelper(this);
                bookDb.deleteAllFishes();
                Intent intent = new Intent(this, LogBookActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
