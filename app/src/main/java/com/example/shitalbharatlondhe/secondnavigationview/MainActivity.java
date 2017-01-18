package com.example.shitalbharatlondhe.secondnavigationview;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Defining Variables
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView)
                findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {

                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {


                        //Checking if the item is in checked state or not, if not make it in checked state
                        if(menuItem.isChecked())
                            menuItem.setChecked(false);
                        else
                            menuItem.setChecked(true);

                        //Closing drawer on item click
                        drawerLayout.closeDrawers();

                        //Check to see which item was being clicked and perform appropriate action
                        switch (menuItem.getItemId()){


                            //Replacing the main content with SendSmsFragment Which is our Inbox View;
                            case R.id.send_sms:
                                Toast.makeText(getApplicationContext(),"Send Sms",
                                        Toast.LENGTH_SHORT).show();
                                SendSmsFragment fragment = new SendSmsFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.frame,fragment);
                                fragmentTransaction.commit();
                                return true;


                            case R.id.make_call_from_app:
                                Toast.makeText(getApplicationContext(),"Make Call From App",
                                        Toast.LENGTH_SHORT).show();
                               MakeACallFromAppFragment fragmentmake = new MakeACallFromAppFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactionmake = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionmake.replace(R.id.frame,fragmentmake);
                                fragmentTransactionmake.commit();
                                return true;


                            case R.id.gps_location:
                                Toast.makeText(getApplicationContext(),"GPS Location",
                                        Toast.LENGTH_SHORT).show();
                               GPSLocationFragment fragmentgps = new GPSLocationFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactiongps = getSupportFragmentManager().beginTransaction();
                                fragmentTransactiongps.replace(R.id.frame,fragmentgps);
                                fragmentTransactiongps.commit();
                                return true;


                            case R.id.telephony_manger:
                                Toast.makeText(getApplicationContext(),"Telephony Manager",
                                        Toast.LENGTH_SHORT).show();
                              TelephonyMangerDemoFragment fragmenttelephony = new  TelephonyMangerDemoFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactiontelephony = getSupportFragmentManager().beginTransaction();
                                fragmentTransactiontelephony.replace(R.id.frame,fragmenttelephony);
                                fragmentTransactiontelephony.commit();
                                return true;



                            case R.id.wifi_demo:
                                Toast.makeText(getApplicationContext(),"Wifi Demo", Toast.LENGTH_SHORT).show();
                                WifiDemoFragment fragmentwifi = new  WifiDemoFragment ();
                                android.support.v4.app.FragmentTransaction fragmentTransactionwifi = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionwifi.replace(R.id.frame,fragmentwifi);
                                fragmentTransactionwifi.commit();
                                return true;





                            case R.id.video_playing:
                                Toast.makeText(getApplicationContext(),"Video Playing Demo",
                                        Toast.LENGTH_SHORT).show();
                              VideoPlayingFragment fragmentvideo = new  VideoPlayingFragment ();
                                android.support.v4.app.FragmentTransaction fragmentTransactionvideo = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionvideo.replace(R.id.frame,fragmentvideo);
                                fragmentTransactionvideo.commit();
                                return true;



                            case R.id.bluetooth_demo:
                                Toast.makeText(getApplicationContext(),"Bluetooth Demo",
                                        Toast.LENGTH_SHORT).show();
                                BluetoothDemoFragment fragmentbluetooth = new  BluetoothDemoFragment ();
                                android.support.v4.app.FragmentTransaction fragmentTransactionbluetooth = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionbluetooth.replace(R.id.frame,fragmentbluetooth);
                                fragmentTransactionbluetooth.commit();
                                return true;




                            case R.id.camera_demo:
                                Toast.makeText(getApplicationContext(),"Camera Demo",
                                        Toast.LENGTH_SHORT).show();
                              CameraDemoFragment fragmentcamera = new   CameraDemoFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactioncamera = getSupportFragmentManager().beginTransaction();
                                fragmentTransactioncamera.replace(R.id.frame,fragmentcamera);
                                fragmentTransactioncamera.commit();
                                return true;



                            case R.id.external_storage:
                                Toast.makeText(getApplicationContext()," external storage Demo",
                                        Toast.LENGTH_SHORT).show();
                                ExternalStorageFragment fragmentexternal = new   ExternalStorageFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactionexternal = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionexternal.replace(R.id.frame,fragmentexternal);
                                fragmentTransactionexternal.commit();
                                return true;



                            case R.id.internal_storage:
                                Toast.makeText(getApplicationContext(),"internal storage Demo",
                                        Toast.LENGTH_SHORT).show();
                               InternalStorageFragment fragmentinternal = new   InternalStorageFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactioninternal = getSupportFragmentManager().beginTransaction();
                                fragmentTransactioninternal.replace(R.id.frame,fragmentinternal);
                                fragmentTransactioninternal.commit();
                                return true;


                            case R.id.cache_demo:
                                Toast.makeText(getApplicationContext(),"cache Demo",
                                        Toast.LENGTH_SHORT).show();
                                CacheDemoFragment fragmentcache = new  CacheDemoFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactioncache = getSupportFragmentManager().beginTransaction();
                                fragmentTransactioncache.replace(R.id.frame,fragmentcache);
                                fragmentTransactioncache.commit();
                                return true;




                            case R.id.shared_preference_demo:
                                Toast.makeText(getApplicationContext()," shared_preference Demo",
                                        Toast.LENGTH_SHORT).show();
                               SharedPreferenceDemoFragment fragmentshared_preference = new SharedPreferenceDemoFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransactionshared_preference = getSupportFragmentManager().beginTransaction();
                                fragmentTransactionshared_preference.replace(R.id.frame,fragmentshared_preference);
                                fragmentTransactionshared_preference.commit();
                                return true;






                            default:
                                Toast.makeText(getApplicationContext(),"Somethings Wrong",Toast.LENGTH_SHORT).show();
                                return true;

                        }
                    }
                });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.openDrawer, R.string.closeDrawer){

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



