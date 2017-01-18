package com.example.shitalbharatlondhe.secondnavigationview;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 04-06-2015.
 */
public class SendSmsFragment extends Fragment {

    EditText number,msg;

    private static String TAG = "PermissionDemo";
    private static final int REQUEST_SEND_SMS = 112;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_send_sms, container, false);

        Button btn = (Button) v.findViewById(R.id.button);
        number = (EditText) v.findViewById(R.id.editTextNumber);
        msg = (EditText) v.findViewById(R.id.editTextMessage);


        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.M) {
            // Do something for lollipop and above versions

            int permission = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.SEND_SMS);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "Permission to denied for SMS");

                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.SEND_SMS)) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Permission to access SMS")
                            .setTitle("Permission required");

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
//                    boolean result = hasPermissionInManifest(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                    if(result==true)
//                    {
//                        filecode();
//                    }
                }

            }
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mynumber = number.getText().toString();
                String mymsg = msg.getText().toString();

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(mynumber, null, mymsg, null, null);
                    Toast.makeText(getActivity(), "SMS Sent!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(),
                            "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        return v;
    }


    protected void makeRequest()
    {
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS},
                REQUEST_SEND_SMS);


    }



}
