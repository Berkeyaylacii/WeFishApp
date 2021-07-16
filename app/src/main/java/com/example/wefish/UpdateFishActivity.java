package com.example.wefish;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fishingapp.R;

public class UpdateFishActivity extends AppCompatActivity {

    private EditText updateName, updateWeight, updateHeight;
    private Button buttonUpdate, buttonDelete;

    private String idFromIntent, nameFromIntent, weightFromIntent, heightFromIntent;
    private String id, name, weight, height;

    private ActionBar actionBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = "Update Fish";
        toolbar.setTitle(title);


        updateName = findViewById(R.id.editText_update_name);
        updateWeight = findViewById(R.id.editText_update_weight);
        updateHeight = findViewById(R.id.editText_update_height);

        buttonUpdate = findViewById(R.id.button_update);
        buttonDelete = findViewById(R.id.button_delete);
        getAndSetIntentData();

        actionBar = getSupportActionBar();
        actionBar.setTitle(nameFromIntent);

        buttonUpdate.setOnClickListener(v -> {
            FishDatabaseHelper db = new FishDatabaseHelper(UpdateFishActivity.this);
            id = idFromIntent.toString().trim();
            name = updateName.getText().toString().trim();
            weight = updateWeight.getText().toString().trim();
            height = updateHeight.getText().toString().trim();
            db.updateFish(id, name, weight, height);

            Intent intent = new Intent(UpdateFishActivity.this, LogBookActivity.class);
            startActivity(intent);
        });

        buttonDelete.setOnClickListener(v -> {
            showDeleteWarning();

        });

    }

    public void showDeleteWarning(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + nameFromIntent + "?");
        builder.setMessage("Are you sure you want to delete "+ nameFromIntent + " ?");
        builder.setPositiveButton("Yes", (dialog, which) -> {
            FishDatabaseHelper db = new FishDatabaseHelper(UpdateFishActivity.this);
            db.deleteTheFish(idFromIntent);
            Intent intent = new Intent(UpdateFishActivity.this, LogBookActivity.class);
            startActivity(intent);
        });
        builder.setNegativeButton("No", (dialog, which) -> {

        });

        builder.create().show();
    }


    public void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("weight") && getIntent().hasExtra("height")){

            //data from intent
            idFromIntent = getIntent().getStringExtra("id");
            nameFromIntent = getIntent().getStringExtra("name");
            weightFromIntent = getIntent().getStringExtra("weight");
            heightFromIntent = getIntent().getStringExtra("height");

            //setting text views
            updateName.setText(nameFromIntent);
            updateWeight.setText(weightFromIntent);
            updateHeight.setText(heightFromIntent);
        }
    }
}

