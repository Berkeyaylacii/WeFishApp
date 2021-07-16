package com.example.wefish;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fishingapp.R;

public class AddFishActivity extends AppCompatActivity {
    private EditText name, weight, height;
    Button buttonAdd;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = "Add Fish";
        toolbar.setTitle(title);

        name = findViewById(R.id.editText_name);
        weight = findViewById(R.id.editText_weight);
        height = findViewById(R.id.editText_height);

        buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(view -> {
            FishDatabaseHelper db = new FishDatabaseHelper(AddFishActivity.this);
            db.addFish(name.getText().toString().trim(), weight.getText().toString().trim(), Integer.parseInt(height.getText().toString().trim()));
            Intent intent = new Intent(AddFishActivity.this, LogBookActivity.class);
            startActivity(intent);
        });
    }
}
