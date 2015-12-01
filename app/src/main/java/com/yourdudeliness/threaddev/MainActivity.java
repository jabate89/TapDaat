package com.yourdudeliness.threaddev;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    public final Handler scoreHandler = new Handler();
    private final static int SECOND = 800;
    protected static double currClickVal;
    protected static double baseClickVal = 200;
    protected static int totalClicks;
    protected static double totalClickValue;
    protected static double currScore = 0;
    protected static double currPassive = 10;
    protected static int currMana = 0;
    protected static double currPassiveMana = 10;
    public static TextView scoreBox;
    public static Building neutral1, neutral2, neutral3, pathos1, pathos2, pathos3, deity;
    public static boolean pathosEnabled = false; //A flag for when the user has chosen an in-game path
    public static PathosCoins coinCollection;



    /*
    TEST VARIABLES  DELETE THESE
     */

    public static int testBonus = 100;

    /*
    DELETE ABOVE DELETE ABOVE
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_background);

        ViewPager appViewPager = new ViewPager(this);
        appViewPager.setId(View.generateViewId());

        //creates an object to reference the <LinearLayout> xml in pager_background.xml
        LinearLayout linLayout = (LinearLayout) findViewById(R.id.container);

        linLayout.addView(appViewPager);//adds the view generated by the view pager to the layout

        //assigns FragmentPagerAdapter to the PageViewer
        appViewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));


        scoreBox = (TextView) findViewById(R.id.score_box);


        /*
        Increments the player's score once every second, printing that score
        to the screen.
         */
        scoreHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (true) {

                    currScore += currPassive;
                    primary_activity.printScore();
                    checkFunds();
                    currMana += currPassiveMana;
                    primary_activity.manaBar.setProgress(currMana);

                    updatePassive();


                }
                scoreHandler.postDelayed(this, SECOND);
            }
        }, SECOND); // tells it to run itself again in 1 second



        currClickVal = baseClickVal;
        totalClicks = 0;
        totalClickValue = 0;
        initializeBuildings();
    }




    private void initializeBuildings(){

        neutral1 = new Building("Farm", 10, 1);
        neutral2 = new Building("Inn", 30, 5);
        neutral3 = new Building("Blacksmith", 50, 20);
        coinCollection = new PathosCoins();

    }
    public static void updatePassive(){
        currPassive = neutral1.getCumulativePassive()
                + neutral2.getCumulativePassive()
                + neutral3.getCumulativePassive();
    }


    /*
   when called, checks available funds against the cost of buildings, disabling
   buttons when funds are insufficient
    */
    public static void checkFunds(){


        if(currMana < 350){
            primary_activity.cp1.setEnabled(false);
        } else {
            primary_activity.cp1.setEnabled(true);
        }
        if(currScore < neutral1.getCostOfNext()){

            primary_activity.n1.setEnabled(false);
        } else {
            primary_activity.n1.setEnabled(true);
        }

        if(currScore < neutral2.getCostOfNext()){

            primary_activity.n2.setEnabled(false);
        } else {
            primary_activity.n2.setEnabled(true);
        }

        if(currScore < neutral3.getCostOfNext()){

            primary_activity.n3.setEnabled(false);
        } else {
            primary_activity.n3.setEnabled(true);
        }

        /*
        Statement only runs if the pathos have been enabled, was previously getting
        a NULL OBJECT error when calling getCostOfNext() before instantiation of the ojbects
         */
        if(pathosEnabled) {
            if (currScore < pathos1.getCostOfNext()) {

                primary_activity.p1.setEnabled(false);
            } else {
                primary_activity.p1.setEnabled(true);
            }

            if (currScore < pathos2.getCostOfNext()) {

                primary_activity.p2.setEnabled(false);
            } else {
                primary_activity.p2.setEnabled(true);
            }

            if (currScore < pathos3.getCostOfNext()) {
                primary_activity.p3.setEnabled(false);
            } else {
                primary_activity.p3.setEnabled(true);
            }
            if(currScore < deity.getCostOfNext()){
                primary_activity.deity.setEnabled(false);
            } else {
                primary_activity.deity.setEnabled(true);
            }
            if(currMana < 600){
                primary_activity.cp2.setEnabled(false);
            } else {
                primary_activity.cp2.setEnabled(true);
            }
            if(currMana < 750){
                primary_activity.cp3.setEnabled(false);
            } else {
                primary_activity.cp3.setEnabled(true);
            }
        }

    }


    static void setBaseClickVal(double val)
    {
        baseClickVal *= val;
    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(getString(R.string.Bounty),(long)currScore);
        editor.putInt(getString(R.string.saved_totalClicks),totalClicks);

        editor.putInt(getString(R.string.Farm_total_buildings),neutral1.getTotalBuildings());
        editor.putLong(getString(R.string.Farm_cost), (long) neutral1.getCostOfNext());
        editor.putLong(getString(R.string.Farm_Passive), (long) neutral1.getCumulativePassive());
        editor.putLong(getString(R.string.Farm_Base), (long) neutral1.getBasePassive());

        editor.putInt(getString(R.string.Inn_total_buildings),neutral2.getTotalBuildings());
        editor.putLong(getString(R.string.Inn_cost), (long) neutral2.getCostOfNext());
        editor.putLong(getString(R.string.Inn_Passive), (long) neutral2.getCumulativePassive());
        editor.putLong(getString(R.string.Inn_Base),(long)neutral2.getBasePassive());

        editor.putInt(getString(R.string.Blacksmith_total_buildings),neutral3.getTotalBuildings());
        editor.putLong(getString(R.string.Blacksmith_cost), (long) neutral3.getCostOfNext());
        editor.putLong(getString(R.string.Blacksmith_Passive), (long) neutral3.getCumulativePassive());
        editor.putLong(getString(R.string.Blacksmith_Base),(long)neutral3.getBasePassive());

        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        currScore = sharedPreferences.getLong(getString(R.string.Bounty),0);

        neutral1.setCostOfNext((double)sharedPreferences.getLong(getString(R.string.Farm_cost), 10));
        neutral1.setTotalBuildings(sharedPreferences.getInt(getString(R.string.Farm_total_buildings), 0));
        neutral1.setCumulativePassive((double) sharedPreferences.getLong(getString(R.string.Farm_Passive), 0));
        neutral1.setBasePassive(sharedPreferences.getLong(getString(R.string.Farm_Base), 1));

        neutral2.setCostOfNext((double)sharedPreferences.getLong(getString(R.string.Inn_cost), 30));
        neutral2.setTotalBuildings(sharedPreferences.getInt(getString(R.string.Inn_total_buildings), 0));
        neutral2.setCumulativePassive((double) sharedPreferences.getLong(getString(R.string.Inn_Passive), 0));
        neutral2.setBasePassive(sharedPreferences.getLong(getString(R.string.Inn_Base), 5));

        neutral3.setCostOfNext((double)sharedPreferences.getLong(getString(R.string.Blacksmith_cost), 50));
        neutral3.setTotalBuildings(sharedPreferences.getInt(getString(R.string.Blacksmith_total_buildings), 0));
        neutral3.setCumulativePassive((double) sharedPreferences.getLong(getString(R.string.Blacksmith_Passive), 0));
        neutral3.setBasePassive(sharedPreferences.getLong(getString(R.string.Blacksmith_Base), 20));

    }

*/
}
