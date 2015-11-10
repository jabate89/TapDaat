package com.yourdudeliness.threaddev;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class Upgrades extends Fragment {

    private List<Up_Holder> myupgrades = new ArrayList<Up_Holder>();
    public ListView list;

    public static Upgrades newInstance() {
        Upgrades fragment = new Upgrades();

        return fragment;
    }

    public Upgrades() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    private void populateUpgrades() {
        //myupgrades.add(new Up_Holder("Farm1", 200, R.drawable.house1, "Increase base farm production 100%"));
        //myupgrades.add(new Up_Holder("Farm2", 7000, R.drawable.house2, "Increase base farm production 200%"));
        //myupgrades.add(new Up_Holder("Farm3", 10000000, R.drawable.house3, "Increase base farm production 300%"));
    }


    private class MyListAdapter extends ArrayAdapter<Up_Holder>{

        public MyListAdapter(Context context,int layout,List myupgrades) {
            super(context,layout,myupgrades);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Make sure we have View
            View itemView = convertView;
            if(itemView == null){
                itemView = getActivity().getLayoutInflater().inflate(R.layout.list_item, parent);
            }

            Up_Holder current_up = myupgrades.get(position);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.up_thumbnail);
            imageView.setImageResource(current_up.getIconID());

            return itemView;
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_upgrades, container, false);

        list = (ListView)thisView.findViewById(R.id.list);



        thisView.setBackgroundColor(Color.WHITE);

        ArrayAdapter<Up_Holder> adapter = new MyListAdapter(this.getActivity(),R.layout.list_item, myupgrades);

        populateUpgrades();

        list.setAdapter(adapter);


        return thisView;
    }

    /*@Override
    public void onClick(View v) {
    }*/

}
