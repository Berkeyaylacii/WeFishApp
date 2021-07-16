package com.example.wefish;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fishingapp.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DataObjectHolder> {

    private Context context;
    private ArrayList<Fish> fishList;




    public RecyclerViewAdapter(Context context, ArrayList<Fish> fishList) {
        this.context = context;
        this.fishList = fishList;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_view, parent, false);
        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder holder, int position) {
        holder.textFish.setText(fishList.get(position).getName());
        holder.imgFish.setImageResource(fishList.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        return fishList.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgFish;
        private TextView textFish;

        public DataObjectHolder(@NonNull View itemView) {
            super(itemView);
            this.imgFish = itemView.findViewById(R.id.fishImage);
            this.textFish = itemView.findViewById(R.id.fishType);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, FishesDetailActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("id", position);
            context.startActivity(intent);


        }
    }


}
