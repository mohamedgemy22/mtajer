package com.enggemy22.matajer2.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.enggemy22.matajer2.R;
import java.util.ArrayList;

public class MainAdapter extends  RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<model2>mlist;
    Context context;

    public MainAdapter(ArrayList<model2> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MainViewHolder holder= new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
          model2 model1=mlist.get(position);
        Glide.with(context).load(model1.getImageRecource()).into(holder.imageView);
        holder.textView.setText(model1.getName());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagerecycler);
            textView = itemView.findViewById(R.id.textRecycler);
        }
    }
}
