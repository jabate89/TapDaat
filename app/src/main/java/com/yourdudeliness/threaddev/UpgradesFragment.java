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

import java.util.ArrayList;


public class UpgradesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayList<Up_Holder> myupgrades = new ArrayList<Up_Holder>();;
    private ListView list;
    private static myAdapter adapter;



    public UpgradesFragment(){
    }

    public static UpgradesFragment newInstance(){
        UpgradesFragment fragment = new UpgradesFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        populateUpgrades();
    }
    private void populateUpgrades() {
        myupgrades.add(new Up_Holder("Farm1", 200, R.drawable.money1, "Increase base farm production 100%"));
        myupgrades.add(new Up_Holder("Farm1", 7000, R.drawable.money2, "Increase base farm production 200%"));
        myupgrades.add(new Up_Holder("Farm1", 10000000, R.drawable.money3, "Increase base farm production 300%"));

        myupgrades.add(new Up_Holder("Inn1", 2500, R.drawable.house1, "Increase base farm production 100%"));
        myupgrades.add(new Up_Holder("Inn2", 850000, R.drawable.house2, "Increase base farm production 200%"));
        myupgrades.add(new Up_Holder("Inn3", 130000000, R.drawable.house3, "Increase base farm production 300%"));
    }
    public static void updateUpgrades(){
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_upgrades,container,false);

        adapter = new myAdapter(getActivity(), R.layout.list_item);
        list = (ListView) view.findViewById(R.id.list);

        list.setAdapter(adapter);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    public class myAdapter extends ArrayAdapter<Up_Holder>{

        public myAdapter(Context context,int res) {
            super(context,res,myupgrades);
        }

        @Override
        public View getView(int position, View currentView, ViewGroup parent) {

            View view = currentView;

            if(view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            }
            else {

                Up_Holder currentUp = myupgrades.get(position);

                ImageView imageView = (ImageView) view.findViewById(R.id.up_thumbnail);
                imageView.setImageResource(currentUp.getIconID());

                TextView name = (TextView) view.findViewById(R.id.up_name);
                name.setText(currentUp.getName());

                TextView cost = (TextView) view.findViewById(R.id.up_cost);
                cost.setText(Integer.toString(currentUp.getCost()));

                TextView description = (TextView) view.findViewById(R.id.up_description);
                description.setText(currentUp.getBonus());

            }
            return view;
        }
    }
}

