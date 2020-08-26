package com.prantae.proflo_u.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prantae.proflo_u.R;
import com.prantae.proflo_u.model.CategoriesModel;
import com.prantae.proflo_u.model.VerticalModel;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriViewHolder> {

    ArrayList<CategoriesModel> categoriesModelList;

    public CategoriesAdapter(ArrayList<CategoriesModel> categoriesModels) {
        this.categoriesModelList = categoriesModels;
    }

    @NonNull
    @Override
    public CategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_cardview, parent, false);
        CategoriesAdapter.CategoriViewHolder categoriViewHolder = new CategoriesAdapter.CategoriViewHolder(view);
        return categoriViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriViewHolder holder, int position) {
        holder.image2.setImageResource(categoriesModelList.get(position).getImage());
        holder.name.setText(categoriesModelList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoriesModelList.size();
    }

    public static final class CategoriViewHolder extends RecyclerView.ViewHolder{

        ImageView image2;
        TextView name;

        public CategoriViewHolder(@NonNull View itemView) {
            super(itemView);

            image2 = itemView.findViewById(R.id.image2);
            name = itemView.findViewById(R.id.name);
        }
    }
}
