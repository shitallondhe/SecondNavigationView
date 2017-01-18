package com.example.shitalbharatlondhe.secondnavigationview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.Inflater;

/**
 * Created by Shital Bharat Londhe on 11-Dec-16.
 */

public class InternalStorageFragment extends Fragment {

    EditText mytext,edata;
    Button mybtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_internal_storage, container, false);

        String str="";
        StringBuffer buf = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.mytextfile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        try
        {
            if (is!=null)
            {
                while ((str = reader.readLine()) != null)
                {
                    buf.append(str + "\n" );
                }
            }
            is.close();

            Toast.makeText(getContext(), buf.toString(), Toast.LENGTH_LONG).show();

            edata = (EditText)v.findViewById(R.id.editText2);
            edata.setText(buf.toString());


        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }


        mybtn = (Button)v.findViewById(R.id.button1);

        mybtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub

                try
                {

                    String FILENAME = "hello_file";

                    mytext = (EditText)v.findViewById(R.id.editText1);
                    String string = mytext.getText().toString();

                    try {
                        FileInputStream fos = getActivity().openFileInput(FILENAME);
                        fos.read(string.getBytes());
                        fos.close();
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace(); // Handle the error here
                    }
/*
                    FileOutputStream fos = getActivity().openFileOutput(FILENAME, Context.MODE_PRIVATE);
                    fos.write(string.getBytes());
                    fos.close();*/



                }
                catch (Throwable t)
                {
                    Toast.makeText(getActivity(), "Exception: "+ t.toString(),Toast.LENGTH_LONG).show();
                }


            }
        });
    return v;




    }


}
