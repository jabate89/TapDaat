package com.yourdudeliness.threaddev;


import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandableListMainActivity extends Fragment
{
    private static final String TAG = ExpandableListMainActivity.class.getSimpleName();


    //public static List<T_holder> mytrophies = new ArrayList<T_holder>();
    // Create ArrayList to hold parent Items and Child Items
    //private ArrayList<String> parentItems = new ArrayList<String>();
    //private ArrayList<Object> childItems = new ArrayList<Object>();
    private View view;
    //ExpandableListView expandableList = new ExpandableListView(getContext());
    private static MyExpandableAdapter adapter;

    public static HashMap<String, ArrayList<T_holder>> Trophies = new HashMap<String,ArrayList<T_holder>>();
    public static ArrayList<String> parentItems;

    private static ArrayList<T_holder> Farm;
    private static ArrayList<T_holder> Inn;
    private static ArrayList<T_holder> Blacksmith;
    private static ArrayList<T_holder> Click_Amount;
    private static ArrayList<T_holder> Click_Coins;
    private static ArrayList<T_holder> Mana;

    ExpandableListView expandableList;

    TextView testbox;

    public ExpandableListMainActivity(){}

    public static ExpandableListMainActivity newInstance(){
        ExpandableListMainActivity fragment = new ExpandableListMainActivity();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        //Log.d(TAG, "adding to farm");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_trophies,container,false);

        setData();
        parentItems = new ArrayList<>(Trophies.keySet());
        adapter = new MyExpandableAdapter(getActivity());
        expandableList = (ExpandableListView) view.findViewById(R.id.expandableListView);

        expandableList.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        testbox = (TextView) view.findViewById(R.id.textView1);
        testbox.setText("Keep Playing to Unlock More");

        /*// Set the Adapter to expandableList
    expandableList.setAdapter(adapter);
    expandableList.setOnChildClickListener(this);*/
        expandableList.setDividerHeight(2);
        expandableList.setGroupIndicator(null);
        //expandableList.setClickable(true);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Set the Items of Parent

        // Set The Data

    }

    // method to add parent Items
    public static void setGroupParents()
    {


    }

    // method to set child data of each parent
    public static void setData()
    {
        Farm = new ArrayList<>();
        Farm.add(0,new T_holder("upgrade: Farm", 1, 5, R.drawable.farm1, "Build 5 farms"));
        Farm.add(1, new T_holder("Upgrade Farm", 2, 25, R.drawable.farm2, "Build 25 farms"));
        Inn = new ArrayList<>();
        Inn.add(0, new T_holder("upgrade: Inn", 1, 5, R.drawable.inn1, "Build 5 inns"));
        Blacksmith = new ArrayList<>();
        Blacksmith.add(0, new T_holder("upgrade: Blacksmith", 1, 5, R.drawable.blacksmith, "Build 5 Blacksmiths"));
        Click_Amount = new ArrayList<>();
        Click_Amount.add(0, new T_holder("Sturdy Treasure", 1, 100, R.drawable.coin1, "100 total clicks"));
        Click_Coins = new ArrayList<>();
        Mana = new ArrayList<>();



        Trophies.put("Mana",Mana);
        Trophies.put("Click_Coins",Click_Coins);
        Trophies.put("Click_Amount",Click_Amount);
        Trophies.put("Blacksmith",Blacksmith);
        Trophies.put("Inn",Blacksmith);
        Trophies.put("Farm",Farm);


    }



public static void nextTrophy(String name, int t) {
    switch(name) {
        case "Farm":
            switch (t) {
                case 0:
                    //primary_activity.testbox.setText("Add trophey case 0");

                    //Trophies.put("Farm",Farm);
                    Log.d(TAG, "adding to farm");
                    break;
                case 1:

                    break;
                case 2:
                    Farm.add(2, new T_holder("Upgrade Farm", 3, 75, R.drawable.farm3, "Build 75 farms"));
                    break;
            }
            adapter.notifyDataSetChanged();
            break;


        case "Inn":
            switch (t) {
                case 0:

                    break;
                case 1:
                    Inn.add(1, new T_holder("Upgrade Inn", 2, 25, R.drawable.inn2, "Build 25 inns"));
                    break;
                case 2:
                    Inn.add(2, new T_holder("Upgrade Inn", 3, 75, R.drawable.inn3, "Build 75 inns"));
                    break;
            }
            adapter.notifyDataSetChanged();
            break;


        case "Blacksmith":
            switch (t) {
                case 0:

                    break;
                case 1:
                    Blacksmith.add(1, new T_holder("Upgrade Blacksmith", 2, 25, R.drawable.inn2, "Build 25 Blacksmiths"));
                    break;
                case 2:
                    Blacksmith.add(2, new T_holder("Upgrade Blacksmith", 3, 75, R.drawable.inn3, "Build 75 Blacksmiths"));
                    break;
            }
            adapter.notifyDataSetChanged();
            break;


        case "ClickingNumber":
            switch (t) {
                case 0:

                    break;
                case 1:
                    Click_Amount.add(1, new T_holder("Durable Treasure", 2, 500, R.drawable.inn3, "500 total clicks"));
                    break;
                case 2:
                    Click_Amount.add(2, new T_holder("Reinforced Treasure", 3, 2500, R.drawable.inn3, "2500 total clicks"));
                    break;
                case 3:
                    Click_Amount.add(3, new T_holder("Resilient Treasure", 4, 10000, R.drawable.inn3, "10000 total clicks"));
                    break;
                case 4:
                    Click_Amount.add(4, new T_holder("Unbreakable Treasure", 5, 50000, R.drawable.inn3, "50000 total clicks"));
                    break;
                case 5:
                    Click_Amount.add(5, new T_holder("Eternal Treasure", 6, 100000, R.drawable.inn3, "100000 total clicks"));
                    break;

            }
            adapter.notifyDataSetChanged();
            break;


        case "ClickingCoins":
            switch (t) {
                case 0:
                    Click_Coins.add(0, new T_holder("Filled Treasure", 1, 100, R.drawable.coin1, "5000 coins by clicking"));
                    break;
                case 1:
                    Click_Coins.add(1, new T_holder("Rich Treasure", 2, 500, R.drawable.coinstack, "5 million coins by clicking"));
                    break;
                case 2:
                    Click_Coins.add(2, new T_holder("Wealthy Treasure", 3, 2500, R.drawable.coinstack3, "5 billion coins by clicking"));
                    break;
                case 3:
                    Click_Coins.add(3, new T_holder("Opulent Treasure", 4, 10000, R.drawable.inn3, "5T coins by clicking"));
                    break;
                case 4:
                    Click_Coins.add(4, new T_holder("Overflowing Treasure", 5, 50000, R.drawable.inn3, "5Qa coins by clicking"));
                    break;

            }
            adapter.notifyDataSetChanged();
            break;
/*
        case "Clicking Rewards3":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("Precious Treasure", 1, 100000, R.drawable.inn3, "100,000 Coins by passive"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Ornate Treasure", 2, 100000000, R.drawable.inn3, "100M Coins by passive"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Adorned Treasure", 3, 100000000000, R.drawable.inn3, "100B Coins by passive"));
                    break;
                case 3:
                    mytrophies.add(0, new T_holder("embellished Treasure", 4, 100000000000000, R.drawable.inn3, "100T Coins by passive"));
                    break;
                case 4:
                    mytrophies.add(0, new T_holder("resplenent Treasure", 5, 100000000000000, R.drawable.inn3, "100Qa (1E20) Coins by passive"));
                    break;

            }
            adapter.notifyDataSetChanged();
            break;*/

        case "Mana Rewards":
            switch (t) {
                case 0:
                    Mana.add(0, new T_holder("Mana Droplet", 1, 200, R.drawable.mana1, "200 mana produced"));
                    break;
                case 1:
                    Mana.add(1, new T_holder("Mana Rain", 2, 2000, R.drawable.mana2, "2000 mana produced"));
                    break;
                case 2:
                    Mana.add(2, new T_holder("Mana Surge", 3, 5000, R.drawable.mana3, "5000 mana produced"));
                    break;
                case 3:
                    Mana.add(3, new T_holder("Mana Fountain", 4, 10000, R.drawable.inn3, "10,000 Mana Produced"));
                    break;
                case 4:
                    Mana.add(4, new T_holder("Mana Shower", 5, 20000, R.drawable.inn3, "20,000 Mana Produced"));
                    break;
                case 5:
                    Mana.add(5, new T_holder("Mana Stream", 6, 100000, R.drawable.inn3, "100,000 Mana Produced"));
                    break;
                case 6:
                    Mana.add(6, new T_holder("Mana Flood", 7, 200000, R.drawable.inn3, "200,000 Mana Produced"));
                    break;

               /* case 7:
                    mytrophies.add(0, new T_holder(" Automatic Casting", 8, 2000000, R.drawable.inn3, "20,000 mana autocasting"));
                    break;

                case 8:
                    mytrophies.add(0, new T_holder("Improved autocasting", 9, 6000000, R.drawable.inn3, "60,000 Mana Autocasting"));
                    break;

                case 9:
                    mytrophies.add(0, new T_holder("Masterful Autocasting", 10, 12000000, R.drawable.inn3, "12,000,000 Mana Autocasting"));
                    break;

                case 10:
                    mytrophies.add(0, new T_holder(" Automatic Casting", 8, 20000000, R.drawable.inn3, "20M  mana autocasting"));
                    break;
                case 11:
                    mytrophies.add(0, new T_holder(" Automatic Casting", 8, 30000000, R.drawable.inn3, "30M  mana autocasting"));
                    break;*/
            }
            adapter.notifyDataSetChanged();
            break;

        }

    }

    public class MyExpandableAdapter extends BaseExpandableListAdapter

    {
        Holder holder;
        Context context;
        //private ArrayList<Object> childtems;
        //private LayoutInflater inflater;
        //private ArrayList<String> parentItems, child;

        // constructor
        public MyExpandableAdapter(Context context){
            this.context = context;
        }


        public T_holder getChild(int groupPosition, int childPosition)
        {
            //ArrayList<T_holder> list =
            return Trophies.get(parentItems.get(groupPosition)).get(childPosition);
        }
        @Override
        public long getChildId(int groupPosition, int childPosition)
        {
            return childPosition;
        }
        // method getChildView is called automatically for each child view.
        //  Implement this method as per your requirement
        @Override
        public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
        {
            TextView textView;
            holder = new Holder();

            /*String child;
            child = () getChild(groupPosition,childPosition);*/

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.child_view,parent,false);
            }

            holder.iconid = (ImageView) convertView.findViewById(R.id.Troph_Thumb);
            holder.description = (TextView) convertView.findViewById(R.id.textViewChild);
            T_holder currentT = getChild(groupPosition,childPosition);

            holder.iconid.setImageResource(currentT.getIconid());
            holder.description.setText(currentT.getBonus());

            // get the textView reference and set the value
            //textView = (TextView) convertView.findViewById(R.id.textViewChild);
            //textView.setText(child);

            // set the ClickListener to handle the click event on child item
            //convertView.setOnClickListener(new OnClickListener() {

                /*@Override
                public void onClick(View view) {
                    Toast.makeText(activity, child.get(childPosition),
                            Toast.LENGTH_SHORT).show();
                }
            });*/
            return convertView;
        }

        @Override
        public int getChildrenCount(int groupPosition)
        {
            return Trophies.get(parentItems.get(groupPosition)).size();
        }


        @Override
        public Object getGroup(int groupPosition)
        {
            return parentItems.get(groupPosition);
        }

        @Override
        public int getGroupCount()
        {
            return parentItems.size();
        }
        @Override
        public long getGroupId(int groupPosition)
        {
            return groupPosition;
        }


        // method getGroupView is called automatically for each parent item
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
        {
            String group = (String) getGroup(groupPosition);
            if(convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.parent_view, null);

            }

            TextView parent_Text = (TextView) convertView.findViewById(R.id.textViewGroupName);
            parent_Text.setTypeface(null, Typeface.BOLD);
            parent_Text.setText(group);

            //((TextView) convertView).setChecked(isExpanded);

            return convertView;
        }

        @Override
        public void onGroupCollapsed(int groupPosition) {
        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return 0;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return 0;
        }

        @Override
        public void onGroupExpanded(int groupPosition)
        {

        }

        @Override
        public boolean hasStableIds()
        {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition)
        {
            return false;
        }

        public class Holder {
            private TextView description;
            private ImageView iconid;

        }

    }

}
