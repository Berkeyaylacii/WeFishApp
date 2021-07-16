package com.example.wefish;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fishingapp.R;


public class FishesDetailActivity extends AppCompatActivity {
    private String Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fishesdetail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = "Fish Detail";
        toolbar.setTitle(title);



        Intent intent = getIntent();
        int Id = intent.getIntExtra("id",0);



        ImageView fishImg =findViewById(R.id.imageViewFish);
        TextView name = findViewById(R.id.textViewName);
        TextView detail = findViewById(R.id.textViewDetail);

        Fish fish = Fish.getFish(Id);

        name.setText(fish.getName());
        detail.setText(fish.getInfo());
        fishImg.setImageResource(fish.getImg());
    }


    public void setFish(String Id){
        this.Id = Id;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,true);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
