package com.prantae.proflo_u.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prantae.proflo_u.R;
import com.prantae.proflo_u.model.HorizontalModel;

import java.util.ArrayList;
import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    ArrayList<HorizontalModel> horizontalModelList;

    public HorizontalAdapter(ArrayList<HorizontalModel> horizontalModelList) {
        this.horizontalModelList = horizontalModelList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_card, parent, false);
        HorizontalViewHolder horizontalViewHolder = new HorizontalViewHolder(view);
        return horizontalViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {

        holder.logo1.setImageResource(horizontalModelList.get(position).getImage());
        holder.title.setText(horizontalModelList.get(position).getTitle());
        holder.desc.setText(horizontalModelList.get(position).getDescription());

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
        return horizontalModelList.size();
    }

    public static final class HorizontalViewHolder extends RecyclerView.ViewHolder {

        ImageView logo1;
        TextView title, desc;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);

            logo1 = itemView.findViewById(R.id.logo1);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
