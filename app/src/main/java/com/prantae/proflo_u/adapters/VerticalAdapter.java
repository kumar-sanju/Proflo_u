package com.prantae.proflo_u.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.prantae.proflo_u.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prantae.proflo_u.model.HorizontalModel;
import com.prantae.proflo_u.model.VerticalModel;

import java.util.ArrayList;
import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    ArrayList<VerticalModel> verticalModelList;

    public VerticalAdapter(ArrayList<VerticalModel> verticalModels) {
        this.verticalModelList = verticalModels;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_cardview, parent, false);
        VerticalAdapter.VerticalViewHolder verticalViewHolder = new VerticalAdapter.VerticalViewHolder(view);
        return verticalViewHolder;
    }

    @Override
    public void onBindViewHolder( VerticalViewHolder holder, int position) {

        holder.image2.setImageResource(verticalModelList.get(position).getImageUrl());
        holder.name.setText(verticalModelList.get(position).getName());
//        holder.rating2.setText(verticalModelList.get(position).getRating());
        holder.desc.setText(verticalModelList.get(position).getDesc());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, Gnp20Activity.class);
//                context.startActivity(i);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return verticalModelList.size();
    }

    public static final class VerticalViewHolder extends RecyclerView.ViewHolder{

        ImageView image2;
        TextView name, rating2, desc;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);

            image2 = itemView.findViewById(R.id.image2);
            name = itemView.findViewById(R.id.name);
//            rating2 = itemView.findViewById(R.id.rating2);
            desc = itemView.findViewById(R.id.desc);

        }
    }
}

