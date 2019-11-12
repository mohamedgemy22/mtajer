package com.enggemy22.matajer2.HomeFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;

import com.enggemy22.matajer2.R;

public class ExampleDailoge extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog= new AlertDialog.Builder(getActivity());
        dialog.setTitle("يسطي انت عاوز تطلع من الابليكشن بتاعي يسطي وربنا عيب ههههه");
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
return dialog.show();
    }
}
