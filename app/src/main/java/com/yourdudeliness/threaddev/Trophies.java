package com.yourdudeliness.threaddev;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 *
 */
public class Trophies extends Fragment {


    public static Trophies newInstance() {
        Trophies fragment = new Trophies();

        return fragment;
    }

    public Trophies() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.troph_fragment, container, false);
        thisView.setBackgroundColor(Color.WHITE);
        return thisView;
    }


}
