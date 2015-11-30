package com.yourdudeliness.threaddev;

import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

/**
 * Created by Awesomeness on 10/18/15.
 */
public class FragmentAdapter extends FragmentPagerAdapter {


    public FragmentAdapter(FragmentManager fm){

        super(fm);
    }

    @Override
    public Fragment getItem(int position){

        switch(position){

            case 0:
                return primary_activity.newInstance();
            case 1:
                return UpgradesFragment.newInstance();
            default:
                return ExpandableListMainActivity.newInstance();
        }

    }

    @Override
    public int getCount(){

        return 3;
    }
}
