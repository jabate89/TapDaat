package com.yourdudeliness.threaddev;


import android.app.Activity;
import android.R.id;
import android.support.v4.app.Fragment;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableListMainActivity extends Fragment
{
    public static List<T_holder> mytrophies = new ArrayList<T_holder>();
    // Create ArrayList to hold parent Items and Child Items
    private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();
    private View view;
    ExpandableListView expandableList = new ExpandableListView(getContext());
    private static MyExpandableAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);


        // Create Expandable List and set it's properties



        // Set the Items of Parent
        setGroupParents();
        // Set The Child Data
        setChildData();


        /*// Set the Adapter to expandableList
        expandableList.setAdapter(adapter);
        expandableList.setOnChildClickListener(this);*/
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


       view=inflater.inflate(R.layout.troph_fragment,container,false);

        setGroupParents();
        setChildData();

        expandableList = (ExpandableListView) view.findViewById(R.id.expandableListView);

        expandableList.setAdapter(adapter);

        expandableList.setDividerHeight(2);
        expandableList.setGroupIndicator(null);
        expandableList.setClickable(true);
        return view;
    }

    // method to add parent Items
    public void setGroupParents()
    {
        parentItems.add("Upgrades");
        parentItems.add("Clicking Rewards");
        parentItems.add("Mana Regen");

    }

    // method to set child data of each parent
    public void setChildData()
    {

        // Add Child Items for Upgrades
        ArrayList<String> child = new ArrayList<String>();
        child.add("Farms");
        child.add("Inns");
        child.add("Blacksmith");

        childItems.add(child);

        // Add Child Items for Clicking Rewards
        child = new ArrayList<String>();
        child.add("Sturdy Treasure");
        child.add("Filled Treasure");
        child.add("Precious Treasure");


        childItems.add(child);

        // Add Child Items for Mana Regen
        child = new ArrayList<String>();
        child.add("mana Droplet");
        child.add("Mana Rain");
        child.add("Mana Surge");
        child.add("Mana Fountain");
        child.add("Mana Shower");
        child.add("Mana Stream");
        child.add("Mana Flood");
        child.add("Automatic Casting");
        child.add("Imrpoved Autocasting");
        child.add("Masterful AutoCasting");
        child.add("Priority Autocasting");
        child.add("Contingency Autocasting");
        child.add("Planned Autocasting");

        childItems.add(child);


    }



public static void nextTrophey(string name, int t) {
    switch(name) {
        case "upgrades1":
                switch (t) {
                    case 0:
                        primary_activity.testbox.setText("Add trophey case 0");
                        mytrophies.add(0, new T_holder("upgrade: Farm", 1, 5, R.drawable.farm1, "Build 5 farms"));
                        break;
                    case 1:
                        mytrophies.add(0, new T_holder("Upgrade Farm", 2, 25, R.drawable.farm2, "Build 25 farms"));
                        break;
                    case 2:
                        mytrophies.add(0, new T_holder("Upgrade Farm", 3, 75, R.drawable.farm3, "Build 75 farms"));
                        break;
                }
            adapter.notifyDataSetChanged();
            break;


        case "upgrades2":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("upgrade: Inn", 1, 5, R.drawable.inn1, "Build 5 inns"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Upgrade Inn", 2, 25, R.drawable.inn2, "Build 25 inns"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Upgrade Inn", 3, 75, R.drawable.inn3, "Build 75 inns"));
                    break;
            }
            adapter.notifyDataSetChanged();
            break;


        case "upgrades3":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("upgrade: Blacksmith", 1, 5, R.drawable.inn1, "Build 5 Blacksmiths"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Upgrade Blacksmith", 2, 25, R.drawable.inn2, "Build 25 Blacksmiths"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Upgrade Blacksmith", 3, 75, R.drawable.inn3, "Build 75 Blacksmiths"));
                    break;
            }
            adapter.notifyDataSetChanged();
            break;



        case "Clicking Rewards":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("Sturdy Treasure", 1, 100, R.drawable.click1, "100 total clicks"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Durable Treasure", 2, 500, R.drawable.click2, "500 total clicks"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Reinforced Treasure", 3, 2500, R.drawable.click3, "2500 total clicks"));
                    break;
                case 3:
                    mytrophies.add(0, new T_holder("Resilient Treasure", 4, 10000, R.drawable.click4, "10000 total clicks"));
                    break;
                case 4:
                    mytrophies.add(0, new T_holder("Unbreakable Treasure", 5, 50000, R.drawable.click5, "50000 total clicks"));
                    break;
                case 5:
                    mytrophies.add(0, new T_holder("Eternal Treasure", 6, 100000, R.drawable.click6, "100000 total clicks"));
                    break;

            }
            adapter.notifyDataSetChanged();
            break;


        case "Clicking Rewards2":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("Filled Treasure", 1, 100, R.drawable.cclick1, "5000 coins by clicking"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Rich Treasure", 2, 500, R.drawable.cclick2, "5 million coins by clicking"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Wealthy Treasure", 3, 2500, R.drawable.cclick3, "5 billion coins by clicking"));
                    break;
                case 3:
                    mytrophies.add(0, new T_holder("Opulent Treasure", 4, 10000, R.drawable.cclick4, "5T coins by clicking"));
                    break;
                case 4:
                    mytrophies.add(0, new T_holder("Overflowing Treasure", 5, 50000, R.drawable.cclick5, "5Qa coins by clicking"));
                    break;

            }
            adapter.notifyDataSetChanged();
            break;

        case "Clicking Rewards3":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("Precious Treasure", 1, 100000, R.drawable.pclick1, "100,000 Coins by passive"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Ornate Treasure", 2, 100000000, R.drawable.pclick2, "100M Coins by passive"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Adorned Treasure", 3, 100000000000, R.drawable.pclick3, "100B Coins by passive"));
                    break;
                case 3:
                    mytrophies.add(0, new T_holder("embellished Treasure", 4, 100000000000000, R.drawable.pclick4, "100T Coins by passive"));
                    break;
                case 4:
                    mytrophies.add(0, new T_holder("resplenent Treasure", 5, 100000000000000, R.drawable.pclick5, "100Qa (1E20) Coins by passive"));
                    break;

            }
            adapter.notifyDataSetChanged();
            break;

        case "Mana Rewards":
            switch (t) {
                case 0:
                    mytrophies.add(0, new T_holder("Mana Droplet", 1, 200, R.drawable.manar1, "200 mana produced"));
                    break;
                case 1:
                    mytrophies.add(0, new T_holder("Mana Rain", 2, 2000, R.drawable.manar2, "2000 mana produced"));
                    break;
                case 2:
                    mytrophies.add(0, new T_holder("Mana Surge", 3, 5000, R.drawable.manar3, "5000 mana produced"));
                    break;
                case 3:
                    mytrophies.add(0, new T_holder("Mana Fountain", 4, 10000, R.drawable.manar4, "10,000 Mana Produced"));
                    break;
                case 4:
                    mytrophies.add(0, new T_holder("Mana Shower", 5, 20000, R.drawable.manar5, "20,000 Mana Produced"));
                    break;
                case 5:
                    mytrophies.add(0, new T_holder("Mana Stream", 6, 100000, R.drawable.manar6, "100,000 Mana Produced"));
                    break;

                case 6:
                    mytrophies.add(0, new T_holder("Mana Flood", 7, 200000, R.drawable.manar7, "200,000 Mana Produced"));
                    break;

                case 7:
                    mytrophies.add(0, new T_holder(" Automatic Casting", 8, 2000000, R.drawable.manar8, "20,000 mana autocasting"));
                    break;

                case 8:
                    mytrophies.add(0, new T_holder("Improved autocasting", 9, 6000000, R.drawable.manar9, "60,000 Mana Autocasting"));
                    break;

                case 9:
                    mytrophies.add(0, new T_holder("Masterful Autocasting", 10, 12000000, R.drawable.manar10, "12,000,000 Mana Autocasting"));
                    break;

                case 10:
                    mytrophies.add(0, new T_holder(" Automatic Casting", 8, 20000000, R.drawable.manar8, "20M  mana autocasting"));
                    break;
                case 11:
                    mytrophies.add(0, new T_holder(" Automatic Casting", 8, 30000000, R.drawable.manar8, "30M  mana autocasting"));
                    break;
            }
            adapter.notifyDataSetChanged();
            break;






    }




    public class MyExpandableAdapter extends ArrayAdapter<T_holder>
{

    private Activity activity;
    //private ArrayList<Object> childtems;
    private LayoutInflater inflater;
    //private ArrayList<String> parentItems, child;

    // constructor
    public MyExpandableAdapter(Context context)
    {
        this.
    }

    public void setInflater(LayoutInflater inflater, Activity activity)
    {
        this.inflater = inflater;
        this.activity = activity;
    }

    // method getChildView is called automatically for each child view.
    //  Implement this method as per your requirement
    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {

        child = (ArrayList<String>) childtems.get(groupPosition);

        TextView textView = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_view, null);
        }

        // get the textView reference and set the value
        textView = (TextView) convertView.findViewById(R.id.textViewChild);
        textView.setText(child.get(childPosition));

        // set the ClickListener to handle the click event on child item
        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(activity, child.get(childPosition),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    // method getGroupView is called automatically for each parent item
    // Implement this method as per your requirement
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.parent_view, null);
        }

        ((CheckedTextView) convertView).setText(parentItems.get(groupPosition));
        ((CheckedTextView) convertView).setChecked(isExpanded);

        return convertView;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return null;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return ((ArrayList<String>) childtems.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return null;
    }

    @Override
    public int getGroupCount()
    {
        return parentItems.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition)
    {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition)
    {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return 0;
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

}

}
