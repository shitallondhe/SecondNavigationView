package com.example.shitalbharatlondhe.secondnavigationview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Shital Bharat Londhe on 11-Dec-16.
 */

public class CacheDemoFragment extends Fragment {

    Button mycache;
    EditText myedit;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_cache_demo, container, false);

        mycache = (Button) v.findViewById(R.id.button1);
        myedit = (EditText) v.findViewById(R.id.editText1);

        mycache.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                try {
                    File path = getActivity().getCacheDir();
                    File file = new File(path, "cache.txt");
                    FileOutputStream fos = new FileOutputStream(file);

                    String cached_data = myedit.getText().toString();
                    fos.write(cached_data.getBytes());
                    fos.close();
                    Toast.makeText(getActivity(), "Cached File cache.txt \n" + "saved at " + path.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    // TODO: handle exception
                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
                }


            }
        });
        return v;

    }
}