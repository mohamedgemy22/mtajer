package com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.enggemy22.matajer2.R;
import com.enggemy22.matajer2.category.ItemCat;

import java.util.ArrayList;

public class modelAdapter extends RecyclerView.Adapter<modelAdapter.RecyclerViewHolder> {

    ArrayList<model> mlist;
    Context context;

    public modelAdapter(ArrayList<model> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        final model model = mlist.get(position);
        holder.textView.setText(model.getName());
        Glide.with(context).load(model.getImageRecource()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ItemCat.class).putExtra(
                        "title",model.getName()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textRecycler);
            imageView = itemView.findViewById(R.id.imagerecycler);
        }
    }
}
