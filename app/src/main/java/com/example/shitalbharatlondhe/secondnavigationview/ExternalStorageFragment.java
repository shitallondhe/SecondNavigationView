package com.example.shitalbharatlondhe.secondnavigationview;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Shital Bharat Londhe on 11-Dec-16.
 */

public class ExternalStorageFragment extends Fragment {

    private static String TAG = "PermissionDemo";
    private static final int REQUEST_WRITE_STORAGE = 112;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_external_storage, container, false);




        int currentapiVersion = android.os.Build.VERSION.SDK_INT;//os versiom retrive by this statement
        if (currentapiVersion >= Build.VERSION_CODES.M){
            // Do something for lollipop and above versions

            int permission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission to record denied");

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Permission to access the SD-CARD").setTitle("Permission required");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int id) {
                            Log.i(TAG, "Clicked");
                            makeRequest();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {

                    makeRequest();

                }

            }

        } else{
            // do something for phones running an SDK before lollipop
            filecode();
        }

   return v;

    }

    private void filecode()
    {

        File extDir1 = Environment.getExternalStorageDirectory();
        Log.d("Test", "External storage dir from Environment: " + extDir1);

        try
        {
            FileWriter out = new FileWriter(new File(extDir1, "test.txt"));
            Toast.makeText(getActivity(),"file stored in"+extDir1,Toast.LENGTH_LONG).show();
            out.write("Writing test!");
            out.close();
        }
        catch (IOException e)
        {
            Log.e("Test", "What? " + e);
        }
        Toast.makeText(getActivity(),"file stored in"+extDir1,Toast.LENGTH_LONG).show();
    }


    protected void makeRequest()
    {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_WRITE_STORAGE);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_WRITE_STORAGE: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user");

                } else {

                    Log.i(TAG, "Permission has been granted by user");
                    filecode();
                }
               // return;
            }
        }
    }


}


