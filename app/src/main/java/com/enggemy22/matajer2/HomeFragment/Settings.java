package com.enggemy22.matajer2.HomeFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.enggemy22.matajer2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment implements View.OnClickListener {

View  view;
RelativeLayout mEdittext;
RelativeLayout mChangeLanguage;
RelativeLayout mContact_US;
RelativeLayout mShareApp;
RelativeLayout mRateApp;
RelativeLayout mLogOut;


    public Settings() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_settings, container, false);
        iniateViews();
        return view;
    }

    private void iniateViews() {
        mEdittext=view.findViewById(R.id.editProfile);
        mEdittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.pageContent,new EditProfile()).commit();
            }
        });

        mChangeLanguage=view.findViewById(R.id.changeLanguage);
        mContact_US=view.findViewById(R.id.contact_us);
        mShareApp=view.findViewById(R.id.Share_APP);
        mRateApp=view.findViewById(R.id.rateapp);
        mLogOut=view.findViewById(R.id.log_out);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.editProfile:

                break;

        }
    }
}
