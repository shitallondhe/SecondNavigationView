package com.example.shitalbharatlondhe.secondnavigationview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;

/**
 * Created by Shital Bharat Londhe on 11-Dec-16.
 */

public class BluetoothDemoFragment extends Fragment {

    File extDir1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_bluetooth_demo, container, false);



        extDir1 = Environment.getExternalStorageDirectory();
        Button btn = (Button) v.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_STREAM,
                        Uri.fromFile(new File(extDir1.toString() + "/image.jpg")));
                startActivity(intent);
            }
        });
        return v;

    }
}