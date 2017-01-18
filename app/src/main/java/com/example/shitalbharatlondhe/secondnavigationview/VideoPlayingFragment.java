package com.example.shitalbharatlondhe.secondnavigationview;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Shital Bharat Londhe on 11-Dec-16.
 */

public class VideoPlayingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate
                (R.layout.fragment_video_playing, container, false);


        VideoView mv = (VideoView)v.findViewById(R.id.videoview);

        Uri uri = Uri.parse("android.resource://com.example.shitalbharatlondhe.secondnavigationview/"
                + R.raw.myvideo);
        MediaController mc = new MediaController(getContext());
        mv.setMediaController(mc);
        mv.setVideoURI(uri);
        mv.start();
      return v;
    }

}
