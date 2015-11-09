package com.yourdudeliness.threaddev;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

    private List<Up_Holder> myupgrades = new ArrayList<Up_Holder>();
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
        myupgrades.add(new Up_Holder("Farm1", 200, R.drawable.money1, "Increase base farm production 100%"));
        myupgrades.add(new Up_Holder("Farm1", 7000, R.drawable.money2, "Increase base farm production 200%"));
        myupgrades.add(new Up_Holder("Farm1", 10000000, R.drawable.money3, "Increase base farm production 300%"));

        myupgrades.add(new Up_Holder("Inn1", 2500, R.drawable.house1, "Increase base farm production 100%"));
        myupgrades.add(new Up_Holder("Inn2", 850000, R.drawable.house2, "Increase base farm production 200%"));
        myupgrades.add(new Up_Holder("Inn3", 130000000, R.drawable.house3, "Increase base farm production 300%"));
    }
    public void updateUpgrades(){
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_upgrades,container,false);

        populateUpgrades();
        adapter = new myAdapter(getActivity());
        list = (ListView) view.findViewById(R.id.list);

        list.setAdapter(adapter);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter.notifyDataSetChanged();
    }


    private void ClickCallback(){
        ListView list = (ListView) view.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View viewClicked,int position,long id){
                Up_Holder clicked = myupgrades.get(position);
                String message = "You clicked position " + position
                                + "Which is " + clicked.getName();
                Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
            }
        });
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("DataListFragment", "Item clicked: " + id);
    }*/

    public class myAdapter extends ArrayAdapter<Up_Holder>{

        Holder holder;
        public myAdapter(Context context) {
            super(context,R.layout.list_item, myupgrades);
        }


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
                holder.up_cost = (TextView) view.findViewById(R.id.up_cost);
                holder.up_desc = (TextView) view.findViewById(R.id.up_description);
                Up_Holder currentUp = getItem(position);

                holder.up_thumb.setImageResource(currentUp.getIconID());
                holder.up_name.setText(currentUp.getName());
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
            TextView up_cost;
            TextView up_desc;
        }
    }
}

