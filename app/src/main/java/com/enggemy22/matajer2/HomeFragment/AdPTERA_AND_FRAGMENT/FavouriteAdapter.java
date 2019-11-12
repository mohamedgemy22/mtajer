package com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT;

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

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder> {
ArrayList<ModelFavourite> mlist;
Context context;

    public FavouriteAdapter(ArrayList<ModelFavourite> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favourite,parent,false);
        FavouriteViewHolder holder=new FavouriteViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
       ModelFavourite favourite=mlist.get(position);
        Glide.with(context).load(favourite.getImage()).into(holder.imageView);
        //Glide.with(context).load(favourite.getImagefavourite()).into(holder.imagefav);
        holder.textView.setText(favourite.getText());
        holder.TextPrice.setText(favourite.getTextNumber());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class FavouriteViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView,imagefav;
        TextView textView,TextPrice;
        public FavouriteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.images);
            //imagefav=itemView.findViewById(R.id.mm);
            textView=itemView.findViewById(R.id.text);
            TextPrice=itemView.findViewById(R.id.textPrice);
        }
    }
}
