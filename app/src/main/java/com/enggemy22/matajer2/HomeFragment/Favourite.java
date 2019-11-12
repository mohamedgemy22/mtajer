package com.enggemy22.matajer2.HomeFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT.FavouriteAdapter;
import com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT.ModelFavourite;
import com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT.modelAdapter;
import com.enggemy22.matajer2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Favourite extends Fragment {
    private RecyclerView recyclerView;
    private FavouriteAdapter favourite;
    private ArrayList<ModelFavourite>mlist;

View view;
    public Favourite() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view =inflater.inflate(R.layout.fragment_favourite, container, false);
        iniateViews();
         return view;
    }

    private void iniateViews() {
        mlist= new ArrayList<>();
        recyclerView=view.findViewById(R.id.favouriteRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ModelFavourite favouritee=new ModelFavourite(R.drawable.bnr,R.drawable.ic_favorite_black_24dp,"Book1","3350");
        ModelFavourite favourite1=new ModelFavourite(R.drawable.bnr,R.drawable.ic_favorite_black_24dp,"Book2","2225");
        ModelFavourite favourite2=new ModelFavourite(R.drawable.bnr,R.drawable.ic_favorite_black_24dp,"Book3","210.5");
        ModelFavourite favourite3=new ModelFavourite(R.drawable.bnr,R.drawable.ic_favorite_black_24dp,"Book4","3984");


        mlist.add(favouritee);
        mlist.add(favourite1);
        mlist.add(favourite2);
        mlist.add(favourite3);
        favourite= new FavouriteAdapter(mlist,getActivity());
        recyclerView.setAdapter(favourite);


    }

}
