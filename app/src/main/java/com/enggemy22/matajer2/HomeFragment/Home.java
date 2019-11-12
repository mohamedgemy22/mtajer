package com.enggemy22.matajer2.HomeFragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT.model;
import com.enggemy22.matajer2.HomeFragment.AdPTERA_AND_FRAGMENT.modelAdapter;
import com.enggemy22.matajer2.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    View view;
    RecyclerView recyclerView;
    modelAdapter mAdapter;
    ArrayList<model> mlist;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initeteViews();
        return view;
    }

    private void initeteViews() {
        mlist= new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mAdapter= new modelAdapter(mlist,getActivity());
        model model1 = new model("mohamed", "1", R.drawable.shome);
        model model2 = new model("mahmoud", "2", R.drawable.gemy);
        model model3 = new model("mostafa", "3", R.drawable.gemy);
        model model4 = new model("gemy", "4", R.drawable.gemy);
        model model5 = new model("abas", "5", R.drawable.gemy);

        mlist.add(model1);
        mlist.add(model2);
        mlist.add(model3);
        mlist.add(model4);
        mlist.add(model5);

        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}








