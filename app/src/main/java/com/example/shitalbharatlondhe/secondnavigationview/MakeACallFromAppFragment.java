package com.example.shitalbharatlondhe.secondnavigationview;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Shital Bharat Londhe on 10-Dec-16.
 */

public class MakeACallFromAppFragment extends Fragment {


    Button CallButton;
    EditText EnterNo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_make_a_call_from_app, container, false);

        CallButton = (Button) v.findViewById(R.id.button1);
        EnterNo = (EditText) v.findViewById(R.id.editText1);

        CallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent makecall = new Intent(Intent.ACTION_CALL);

                makecall.setData(Uri.parse("tel:" + EnterNo.getText().toString()));

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(makecall);
                //finish();

            }
        });

        return v;

    }
}