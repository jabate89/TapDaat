package com.yourdudeliness.threaddev;


import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class ExpandableListMainActivity extends ExpandableListActivity
{
    // Create ArrayList to hold parent Items and Child Items
    private ArrayList<String> parentItems = new ArrayList<String>();
    private ArrayList<Object> childItems = new ArrayList<Object>();

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);


        // Create Expandable List and set it's properties
        ExpandableListView expandableList = getExpandableListView();
        expandableList.setDividerHeight(2);
        expandableList.setGroupIndicator(null);
        expandableList.setClickable(true);

        // Set the Items of Parent
        setGroupParents();
        // Set The Child Data
        setChildData();

        // Create the Adapter
        MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);

        adapter.setInflater((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE), this);

        // Set the Adapter to expandableList
        expandableList.setAdapter(adapter);
        expandableList.setOnChildClickListener(this);
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

}
