package com.enggemy22.matajer2.HomeFragment;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.enggemy22.matajer2.Main.HomeActivity;
import com.enggemy22.matajer2.R;
import com.enggemy22.matajer2.SharedPreferenceP.SharedImages;
import com.enggemy22.matajer2.SharedPreferenceP.SharedSignUp;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditProfile extends Fragment implements View.OnClickListener,EasyPermissions.PermissionCallbacks {
private ImageView mImageUpload;
private TextView mTextUpload;
private EditText editTextfirdst;
private EditText editTextLast;
private EditText editTextEmailst;
private EditText editTextPassword;
private Button buttonSave;
private int GALLERY = 1, CAMERA = 2;
SharedSignUp up;
SharedImages images;
View view;


    public EditProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_edit_profile, container, false);
        up=new SharedSignUp(getActivity());
        iniateView();
        return view;
    }
    //iniate Views
    private void iniateView() {
        mImageUpload=view.findViewById(R.id.chooseImage);
        mTextUpload=view.findViewById(R.id.txtEditProfile);
        editTextfirdst=view.findViewById(R.id.fNameEditText);
        editTextLast=view.findViewById(R.id.LNameEditText);
        editTextEmailst=view.findViewById(R.id.EEditText);
        editTextPassword=view.findViewById(R.id.PaEditText);
        buttonSave=view.findViewById(R.id.SaEditText);
        buttonSave.setOnClickListener(this);
        mImageUpload.setOnClickListener(this);
        mTextUpload.setOnClickListener(this);
        getDataFromSharedPreferences();


    }

    //getdataFromSharedPreferences
    private void getDataFromSharedPreferences() {
       editTextfirdst.setText(up.getUser().get(SharedSignUp.KEY_FNAME));
       editTextLast.setText(up.getUser().get(SharedSignUp.KEY_LNAME));
       editTextEmailst.setText(up.getUser().get(SharedSignUp.KEY_NAME));
       editTextPassword.setText(up.getUser().get(SharedSignUp.KEY_PASSWORD));
    }

    //Validate data
    public boolean validateData(){
        if (editTextEmailst.getText().toString().isEmpty()){
            Toast.makeText(getActivity(),"please entre your email",Toast.LENGTH_LONG).show();
            return false;
        }else if(editTextPassword.getText().toString().isEmpty()){
            Toast.makeText(getActivity(),"please entre your password",Toast.LENGTH_LONG).show();
            return false;
        }else if(editTextfirdst.getText().toString().isEmpty()){
            Toast.makeText(getActivity(),"please entre your first Name",Toast.LENGTH_LONG).show();
            return false;
        }else if(editTextLast.getText().toString().isEmpty()){
            Toast.makeText(getActivity(),"please entre your Last Name",Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    //clicks
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.chooseImage:
                showPictureDialog();
                break;
            case R.id.txtEditProfile:
                showPictureDialog();
                break;
            case R.id.SaEditText:
                if (validateData()) {
                    up.saveData(editTextfirdst.getText().toString(), editTextLast.getText().toString(), editTextEmailst.getText().toString(), editTextPassword.getText().toString(), true);
                    view=getActivity().findViewById(R.id.pageContent);
                    Snackbar snackbar = Snackbar
                            .make(view, "data is saved", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
                break;
        }
    }

    //AlertDailog
    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(getActivity());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery",
                "Capture photo from camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    //choose form GAllary
    @AfterPermissionGranted(101)
    private void choosePhotoFromGallary() {
        String [] gallaryPerimission=new String[0];
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){
            gallaryPerimission=new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(getActivity(),gallaryPerimission)){
            Intent gallryIntent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(gallryIntent,GALLERY);
        }else{
            EasyPermissions.requestPermissions(getActivity(),"Asess for storage",101,gallaryPerimission);
        }
    }

    //choose form camera
    @AfterPermissionGranted(203)
    private void  takePhotoFromCamera() {
        String [] gallaryPerimission=new String[0];
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){
            gallaryPerimission=new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE};
        }
        if (EasyPermissions.hasPermissions(getActivity(),gallaryPerimission)){
            Intent gallryIntent= new Intent( MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(gallryIntent,CAMERA);
        }else{
            EasyPermissions.requestPermissions(getActivity(),"Asess for storage",203,gallaryPerimission);
        }
    }

    //OnActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), contentURI);
                    mImageUpload.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            mImageUpload.setImageBitmap(thumbnail);
            Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }
}
