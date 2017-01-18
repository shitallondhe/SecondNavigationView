package com.example.shitalbharatlondhe.secondnavigationview;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Shital Bharat Londhe on 11-Dec-16.
 */

public class SharedPreferenceDemoFragment extends Fragment {

    EditText setEdit,getEdit;
    Button setBtn,getBtn;

    SharedPreferences appsharedper;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_shared_preference_demo, container, false);

        setEdit = (EditText)v.findViewById(R.id.editText1);
        getEdit = (EditText)v.findViewById(R.id.EditText2);


        setBtn = (Button)v.findViewById(R.id.button1);
        getBtn = (Button)v.findViewById(R.id.Button2);


        appsharedper = PreferenceManager.getDefaultSharedPreferences(getContext());


        setBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub

                SharedPreferences.Editor edit = appsharedper.edit();

                edit.putString("MyValue",setEdit.getText().toString().trim());

                edit.commit();



            }
        });



        getBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                String getValueBack = appsharedper.getString("MyValue", "");
                getEdit.setText(getValueBack);

            }
        });

return v;


    }
}
