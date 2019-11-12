package com.enggemy22.matajer2.HomeFragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.enggemy22.matajer2.Main.Splash;
import com.enggemy22.matajer2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Log_Out extends Fragment  implements View.OnClickListener {

View view;
private Button buttonyes;
private Button buttonno;

    public Log_Out() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_log__out, container, false);
        iniateViews();
         return view;
    }

    private void iniateViews() {
        buttonyes=view.findViewById(R.id.yes);
        buttonno=view.findViewById(R.id.no);
        buttonno.setOnClickListener(this);
        buttonyes.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.yes:
                AlertDialog.Builder dialog= new AlertDialog.Builder(getActivity());
                dialog.setTitle("برده يسطي عاوز تخرج ههههه");
                dialog.setIcon(R.drawable.images24);
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                        System.exit(1);
                        AlertDialog.Builder dialog= new AlertDialog.Builder(getActivity());
                        dialog.setTitle("برده يسطي انت عاوز تخرج ههههههه");
                        dialog.setIcon(R.drawable.images24);
                        dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                getActivity().finish();
                                System.exit(1);
                                Toast.makeText(getActivity().getApplicationContext(),"شكرا علي غدر الصحاب ههههه" ,Toast.LENGTH_LONG ).show();

                            }
                        });
                        dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity().getApplicationContext(),"شكرا ياسيدي" ,Toast.LENGTH_LONG ).show();
                            }
                        });
                         dialog.show();
                        Toast.makeText(getActivity().getApplicationContext(),"شكرا علي غدر الصحاب ههههه" ,Toast.LENGTH_LONG ).show();

                    }
                });
                dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getApplicationContext(),"شكرا ياسيدي" ,Toast.LENGTH_LONG ).show();

                    }
                });
                dialog.show();

                break;
            case R.id.no:
                Toast.makeText(getActivity().getApplicationContext(),"شكرا ياسيدي" ,Toast.LENGTH_LONG ).show();

                break;
        }
    }
}
