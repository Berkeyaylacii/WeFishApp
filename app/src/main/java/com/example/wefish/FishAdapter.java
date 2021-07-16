package com.example.wefish;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fishingapp.R;

import java.util.ArrayList;

public class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> {
    private Context context;
    ArrayList fishIDs, fishNames, fishWeights, fishHeights;

    private Activity activity;

    public FishAdapter(Activity activity, Context context,  ArrayList fishIDs, ArrayList fishNames, ArrayList fishWeights, ArrayList fishHeights ) {
        this.activity = activity;
        this.context = context;
        this.fishIDs = fishIDs;
        this.fishNames = fishNames;
        this.fishWeights = fishWeights;
        this.fishHeights = fishHeights;
    }

    @NonNull
    @Override
    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fishdata_card_view, parent, false);
        return new FishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
        holder.id.setText(String.valueOf(fishIDs.get(position)));
        holder.name.setText(String.valueOf(fishNames.get(position)));
        holder.weight.setText(String.valueOf(fishWeights.get(position)));
        holder.height.setText(String.valueOf(fishHeights.get(position)));
        holder.cardView.setOnClickListener(v -> {

            Intent intent = new Intent(context, UpdateFishActivity.class);
            intent.putExtra("id", String.valueOf(fishIDs.get(position)));
            intent.putExtra("name", String.valueOf(fishNames.get(position)));
            intent.putExtra("weight", String.valueOf(fishWeights.get(position)));
            intent.putExtra("height", String.valueOf(fishHeights.get(position)));

            activity.startActivityForResult(intent, 1);
        });
    }

    @Override
    public int getItemCount() {
        return fishIDs.size();
    }

    public class FishViewHolder extends RecyclerView.ViewHolder{
        private TextView id, name, weight, height;
        LinearLayout cardView;
        public FishViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView_card_fish_id);
            name = itemView.findViewById(R.id.textView_card_fish_name);
            weight = itemView.findViewById(R.id.textView_card_fish_weight);
            height = itemView.findViewById(R.id.textView_card_fish_height);
            cardView = itemView.findViewById(R.id.cardView_fishData);

        }
    }
}
