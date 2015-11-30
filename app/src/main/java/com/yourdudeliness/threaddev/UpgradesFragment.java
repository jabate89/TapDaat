package com.yourdudeliness.threaddev;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class UpgradesFragment extends Fragment  {

    public static List<Up_Holder> myupgrades = new ArrayList<Up_Holder>();
    private ListView list;
    private static myAdapter adapter;
    View view;




    public UpgradesFragment(){
    }

    public static UpgradesFragment newInstance(){
        UpgradesFragment fragment = new UpgradesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    private void populateUpgrades() {
        //First Upgrades placed statically
        /*
        myupgrades.add(new Up_Holder("Farm",1, 200, R.drawable.farm1, "Increase base farm production 100%"));

        myupgrades.add(new Up_Holder("Inn",1, 2500, R.drawable.inn1, "Increase base Inn production 100%"));

        myupgrades.add(new Up_Holder("Blacksmith",1,12000,R.drawable.money1,"Increase base blacksmith production 100%"));
*/
    }
    //Simple helper function for updating the ArrayList
    public void updateUpgrades(){
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflater for Listview xml
        view = inflater.inflate(R.layout.fragment_upgrades,container,false);

        //Fill list with initial upgrades
        //populateUpgrades();

        //Create adapter for ListView
        adapter = new myAdapter(getActivity());

        //Attach List view to layout
        list = (ListView) view.findViewById(R.id.list);

        //Attach data to ArrayList Adapter
        list.setAdapter(adapter);

        //Initialize
        ClickCallback();

        return view;
    }

    public static void nextUpgrade(String name,int t){
        switch (name) {
            case "Farm":
                switch (t){
                    case 0:
                        //primary_activity.testbox.setText("Add upgrade case 0");
                        myupgrades.add(0, new Up_Holder("Farm", 1, 200, R.drawable.farm1, "Increase base farm production 100%"));
                        break;
                    case 1:
                        myupgrades.add(0,new Up_Holder("Farm",2, 7000, R.drawable.farm2, "Increase base farm production 200%"));
                        break;
                    case 2:
                        myupgrades.add(0,new Up_Holder("Farm",3, 10000000, R.drawable.farm3, "Increase base farm production 300%"));
                        break;
                }
                ExpandableListMainActivity.nextTrophy(name,t);
                adapter.notifyDataSetChanged();
                break;
            case "Inn":
                switch (t){
                    case 0:
                        myupgrades.add(0,new Up_Holder("Inn",1, 2500, R.drawable.inn1, "Increase base Inn production 100%"));
                        break;
                    case 1:
                        myupgrades.add(0,new Up_Holder("Inn",2, 850000, R.drawable.inn2, "Increase base Inn production 200%"));
                        break;
                    case 2:
                        myupgrades.add(0,new Up_Holder("Inn",3, 130000000, R.drawable.inn3, "Increase base Inn production 300%"));
                        break;
                }
                ExpandableListMainActivity.nextTrophy(name,t);
                adapter.notifyDataSetChanged();
                break;
            case "Blacksmith":
                switch (t){
                    case 0:
                        myupgrades.add(0,new Up_Holder("Blacksmith",1,12000,R.drawable.money1,"Increase base blacksmith production 100%"));
                        break;
                    case 1:
                        myupgrades.add(0,new Up_Holder("Blacksmith",2,400000,R.drawable.money2,"Increase base blacksmith production 200%"));
                        break;
                    case 2:
                        myupgrades.add(0,new Up_Holder("Blacksmith", 3, 650000000, R.drawable.money3, "Increase base blacksmith production 300%"));
                        break;
                }
                ExpandableListMainActivity.nextTrophy(name,t);
                adapter.notifyDataSetChanged();
                break;

            case "ClickingNumber":
                switch (t){
                    case 0:
                        myupgrades.add(0,new Up_Holder("Treasure",1,500,R.drawable.yen,"Increase base clicking reward by 4"));
                        break;
                    case 1:
                        myupgrades.add(0,new Up_Holder("Treasure",2,5000,R.drawable.dollar,"Increase base clicking reward by 45"));
                        break;
                    case 2:
                        myupgrades.add(0,new Up_Holder("Treasure", 3, 5000000, R.drawable.euro, "Increase base clicking reward by 4950"));
                        break;
                }
                ExpandableListMainActivity.nextTrophy(name,t);
                adapter.notifyDataSetChanged();
                break;
            case "ClickingCoins":
                switch (t){
                    case 0:
                        myupgrades.add(0,new Up_Holder("ClickBonus",1,10000,R.drawable.yen,"Increase clicking reward by 25% and the production of all buildings by 25%"));
                        break;
                    case 1:
                        myupgrades.add(0,new Up_Holder("ClickBonus",2,50000000,R.drawable.dollar,"Increase clicking reward by 25% and the production of all buildings by 25%"));
                        break;
                    case 2:
                        myupgrades.add(0,new Up_Holder("ClickBonus", 3, 1000000000, R.drawable.euro, "Increase clicking reward by 25% and the production of all buildings by 25%"));
                        break;
                }
                ExpandableListMainActivity.nextTrophy(name,t);
                adapter.notifyDataSetChanged();
                break;
            //case ""
        }

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter.notifyDataSetChanged();
    }


    private void ClickCallback(){
        list = (ListView) view.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Up_Holder clicked = myupgrades.get(position);
                String message = "You clicked position " + position
                        + "Which is " + clicked.getName();
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

                if(MainActivity.currScore >= clicked.getCost()) {

                    MainActivity.currScore -= clicked.getCost();

                    switch (clicked.getName()) {
                        case "Farm":

                            switch (clicked.getTier()) {
                                case 1:
                                    MainActivity.neutral1.setBasePassive(2);
                                    break;
                                case 2:
                                    MainActivity.neutral1.setBasePassive(3);
                                    break;
                                case 3:
                                    MainActivity.neutral1.setBasePassive(4);
                                    break;
                            }
                            myupgrades.remove(position);
                            //nextUpgrade(clicked.getName(), clicked.getTier());
                            adapter.notifyDataSetChanged();
                            MainActivity.neutral1.updateCumulativePassive();
                            primary_activity.updateButton("neutral1");
                            break;

                        case "Inn":
                            switch (clicked.getTier()) {
                                case 1:
                                    MainActivity.neutral2.setBasePassive(2);
                                    break;
                                case 2:
                                    MainActivity.neutral2.setBasePassive(3);
                                    break;
                                case 3:
                                    MainActivity.neutral2.setBasePassive(4);
                                    break;
                            }
                            myupgrades.remove(position);
                            //nextUpgrade(clicked.getName(), clicked.getTier());
                            adapter.notifyDataSetChanged();
                            MainActivity.neutral2.updateCumulativePassive();
                            primary_activity.updateButton("neutral2");
                            break;
                        case "Blacksmith":
                            switch (clicked.getTier()) {
                                case 1:
                                    MainActivity.neutral3.setBasePassive(2);
                                    break;
                                case 2:
                                    MainActivity.neutral3.setBasePassive(3);
                                    break;
                                case 3:
                                    MainActivity.neutral3.setBasePassive(4);
                                    break;
                            }
                            myupgrades.remove(position);
                            //nextUpgrade(clicked.getName(), clicked.getTier());
                            adapter.notifyDataSetChanged();
                            MainActivity.neutral3.updateCumulativePassive();
                            primary_activity.updateButton("neutral3");
                            break;
                        case "Treasure":
                            switch (clicked.getTier()) {
                                case 1:
                                    MainActivity.setBaseClickVal(4);
                                    break;
                                case 2:
                                    MainActivity.setBaseClickVal(45);
                                    break;
                                case 3:
                                    MainActivity.setBaseClickVal(4950);
                                    break;
                            }
                            myupgrades.remove(position);
                            //nextUpgrade(clicked.getName(), clicked.getTier());
                            adapter.notifyDataSetChanged();
                            break;
                        case "ClickBonus":
                            switch (clicked.getTier()) {
                                case 1:
                                    MainActivity.neutral1.setBasePassive(1.25);
                                    MainActivity.neutral2.setBasePassive(1.25);
                                    MainActivity.neutral3.setBasePassive(1.25);
                                    MainActivity.setBaseClickVal(1.25);
                                    break;
                                case 2:
                                    MainActivity.neutral1.setBasePassive(1.25);
                                    MainActivity.neutral2.setBasePassive(1.25);
                                    MainActivity.neutral3.setBasePassive(1.25);
                                    MainActivity.setBaseClickVal(1.25);
                                    break;
                                case 3:
                                    MainActivity.neutral1.setBasePassive(1.25);
                                    MainActivity.neutral2.setBasePassive(1.25);
                                    MainActivity.neutral3.setBasePassive(1.25);
                                    MainActivity.setBaseClickVal(1.25);
                                    break;
                            }
                            myupgrades.remove(position);
                            //nextUpgrade(clicked.getName(), clicked.getTier());
                            adapter.notifyDataSetChanged();
                            break;

                    }
                }

            }
        });
    }

    /*
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("DataListFragment", "Item clicked: " + id);
    }
*/
    public class myAdapter extends ArrayAdapter<Up_Holder>{

        Holder holder;
        public myAdapter(Context context) {
            super(context,R.layout.list_item, myupgrades);
        }

        //list = (ListView) view.findViewById(R.id.list);


        @Override
        public View getView(int position, View currentView, ViewGroup parent) {

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

            /*if(view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            }
            else {
*/
                holder = new Holder();
                holder.up_thumb = (ImageView) view.findViewById(R.id.up_thumbnail);
                holder.up_name = (TextView) view.findViewById(R.id.up_name);
                holder.up_tier = (TextView) view.findViewById(R.id.up_tier);
                holder.up_cost = (TextView) view.findViewById(R.id.up_cost);
                holder.up_desc = (TextView) view.findViewById(R.id.up_description);

            Up_Holder currentUp = getItem(position);

                holder.up_thumb.setImageResource(currentUp.getIconID());
                holder.up_name.setText(currentUp.getName());
                holder.up_tier.setText(" Tier " + Integer.toString(currentUp.getTier()));
                holder.up_cost.setText(Integer.toString(currentUp.getCost()));
            holder.up_desc.setText(currentUp.getBonus());

                /*
                ImageView imageView = (ImageView) view.findViewById(R.id.up_thumbnail);
                imageView.setImageResource(currentUp.getIconID());

                TextView name = (TextView) view.findViewById(R.id.up_name);
                name.setText(currentUp.getName());

                TextView cost = (TextView) view.findViewById(R.id.up_cost);
                cost.setText(Integer.toString(currentUp.getCost()));

                TextView description = (TextView) view.findViewById(R.id.up_description);
                description.setText(currentUp.getBonus());*/

           // }
            return view;
        }
        public class Holder{
            ImageView up_thumb;
            TextView up_name;
            TextView up_tier;
            TextView up_cost;
            TextView up_desc;
        }
    }
}

