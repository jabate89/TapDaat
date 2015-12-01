package com.yourdudeliness.threaddev;


import android.view.View.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link primary_activity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class primary_activity extends Fragment implements OnClickListener {

    protected static Button n1, n2, n3, p1, p2, p3, deity, cp1, cp2, cp3;
    protected static ImageButton mainButton;
    public static ProgressBar manaBar;
    public static TextView scoreBox;
    public static TextView [] coins;
    public static Random coinGen;
    public static int isCoin, coinChance = 2;
    public static NumberFormat format;
    public static TextView clickTest, passiveTest;//displays the current passive and active scoring values
    private static int clickCoinsflag = 0;
    public static boolean good = false;
    public static boolean evil = false; //used to control view background once pathos is chosen



// Bryan was here



    public static primary_activity newInstance() {
        primary_activity fragment = new primary_activity();

        return fragment;
    }

    public primary_activity() {
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
        View thisView = inflater.inflate(R.layout.fragment_primary_activity, container, false);
        if(good){

        } else if(evil){

        }
        initializeButtons(thisView);


        return thisView;
    }

    @Override
    public void onClick(View v){
        //switch statement which button was pressed
        switch(v.getId()) {

            case R.id.main_button:
                incrementScore();
                MainActivity.totalClicks++;
                switch(MainActivity.totalClicks){
                    case 100:
                        UpgradesFragment.nextUpgrade("ClickingNumber",0);
                        break;
                    case 500:
                        UpgradesFragment.nextUpgrade("ClickingNumber",1);
                        break;
                    case 2500:
                        UpgradesFragment.nextUpgrade("ClickingNumber",2);
                }
                break;
            case R.id.neutral_1:
                MainActivity.neutral1.build();
                updateButton("neutral1");
                break;
            case R.id.neutral_2:
                MainActivity.neutral2.build();
                updateButton("neutral2");
                break;
            case R.id.neutral_3:
                MainActivity.neutral3.build();
                updateButton("neutral3");
                break;
            case R.id.pathos_1:
                if(MainActivity.pathosEnabled){
                    MainActivity.pathos1.build();
                    updateButton("p1");
                }
                break;
            case R.id.pathos_2:
                if(MainActivity.pathosEnabled){
                    MainActivity.pathos2.build();
                    updateButton("p2");
                }
                break;

            case R.id.pathos_3:
                if(MainActivity.pathosEnabled){
                    MainActivity.pathos3.build();
                    updateButton("p3");
                }
                break;
            case R.id.deity:
                if(MainActivity.pathosEnabled){
                    MainActivity.deity.build();
                    updateButton("deity");
                }
                break;
            case R.id.power_1:
                SpellCast.power1();
                break;
            case R.id.power_2:
                if(MainActivity.pathosEnabled){
                    SpellCast.power2();
                }
                break;
            case R.id.power_3:
                if(MainActivity.pathosEnabled){
                    SpellCast.power3();
                }
                break;
        }

    }




    /*
    When called initializes all the button objects via the button
    id's in the primary_activity.xml
     */
    public void initializeButtons(View view){

        /*
        Assign all the XML buttons to java objects
         */
        mainButton = (ImageButton) view.findViewById(R.id.main_button);
        n1 = (Button) view.findViewById(R.id.neutral_1);
        n2 = (Button) view.findViewById(R.id.neutral_2);
        n3 = (Button) view.findViewById(R.id.neutral_3);

        p1 = (Button) view.findViewById(R.id.pathos_1);
        p2 = (Button) view.findViewById(R.id.pathos_2);
        p3 = (Button) view.findViewById(R.id.pathos_3);
        deity = (Button) view.findViewById(R.id.deity);


        coins = new TextView[3];//the coins view is used as an array
        coins[0] = (TextView) view.findViewById(R.id.elf);
        coins[1] = (TextView)view.findViewById(R.id.human);
        coins[2] = (TextView) view.findViewById(R.id.orc);

        updateButton("neutral1");
        updateButton("neutral2");
        updateButton("neutral3");


        mainButton.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        p1.setOnClickListener(this);
        p2.setOnClickListener(this);
        p3.setOnClickListener(this);
        deity.setOnClickListener(this);

        manaBar = (ProgressBar) view.findViewById(R.id.mana_bar);
        manaBar.setMax(900);
        manaBar.setVisibility(View.VISIBLE);

        scoreBox = (TextView) view.findViewById(R.id.score_box);

        //Generates a random number for PathosCoins class
        coinGen = new Random();

        cp1 = (Button) view.findViewById(R.id.power_1);
        cp1.setOnClickListener(this);
        cp2 = (Button) view.findViewById(R.id.power_2);
        cp2.setOnClickListener(this);
        cp3 = (Button) view.findViewById(R.id.power_3);

        clickTest = (TextView) view.findViewById(R.id.click_test);
        passiveTest = (TextView) view.findViewById(R.id.passive_test);
        //testbox = (TextView) view.findViewById(R.id.tester);

        if(MainActivity.pathosEnabled){
            p1.setVisibility(View.VISIBLE);
            p2.setVisibility(View.VISIBLE);
            p3.setVisibility(View.VISIBLE);
            deity.setVisibility(View.VISIBLE);
            cp2.setVisibility(View.VISIBLE);
            cp3.setVisibility(View.VISIBLE);
            p1.setEnabled(true);
            p2.setEnabled(true);
            p3.setEnabled(true);
            deity.setEnabled(true);
            cp2.setEnabled(true);
            cp3.setEnabled(true);

            primary_activity.updateButton("p1");
            primary_activity.updateButton("p2");
            primary_activity.updateButton("p3");
            primary_activity.updateButton("deity");
        }

    }

    /*
    Called on click of the main button. Increments and prints the score the the UI,
    checks if a Pathos Coin is generated (base chance 2%), then randomnly generates
    one of 3 coins.
     */
    public static void incrementScore(){


        MainActivity.currScore += MainActivity.baseClickVal;
        MainActivity.totalClickValue += MainActivity.baseClickVal;
        MainActivity.totalClicks += 1;
        //primary_activity.testbox.setText(Integer.toString(MainActivity.totalClickValue));
        printScore();
        checkUpgrades();

        isCoin = coinGen.nextInt(100);//generate random number < 100

        if(isCoin < coinChance){
            //generate a coin if rand is less than the percentage chance of receiving a coin
            MainActivity.coinCollection.generateCoin(coinGen.nextInt(3));
        }

        MainActivity.checkFunds();


    }

    /*
    Function accepts a string of "good" or "evil", based on user
    in-game choice. Initializes pathos buttons, sets their names,
    and makes them visible to user
     */
    public static void initializePathos(int type){

            if (type == 0) {
                MainActivity.pathos1 = new Building("Speakeasy", 1000, 200);
                MainActivity.pathos2 = new Building("SeaOrg", 15000, 2000);
                MainActivity.pathos3 = new Building("Brothel", 100000, 100000);
            } else {
                MainActivity.pathos1 = new Building("Conduction", 1000, 200);
                MainActivity.pathos2 = new Building("Convection", 15000, 2000);
                MainActivity.pathos3 = new Building("Radiation", 100000, 100000);
            }

            MainActivity.deity = new Building("Mormon Temple",15000000,100000);

            //Set the buttons to visible
            p1.setVisibility(View.VISIBLE);
            p2.setVisibility(View.VISIBLE);
            p3.setVisibility(View.VISIBLE);
            deity.setVisibility(View.VISIBLE);
            cp2.setVisibility(View.VISIBLE);
            cp3.setVisibility(View.VISIBLE);
            p1.setEnabled(true);
            p2.setEnabled(true);
            p3.setEnabled(true);
            deity.setEnabled(true);
            cp2.setEnabled(true);
            cp3.setEnabled(true);

            MainActivity.pathosEnabled = true;
            primary_activity.updateButton("p1");
            primary_activity.updateButton("p2");
            primary_activity.updateButton("p3");
            primary_activity.updateButton("deity");


    }


    public static void printScore(){

            scoreBox.setText("Bounty  " + Digits.format(MainActivity.currScore));
            MainActivity.coinCollection.printCoin();
        primary_activity.clickTest.setText("Clk " + Digits.format(MainActivity.baseClickVal));
        primary_activity.passiveTest.setText("Sec " + Digits.format(MainActivity.currPassive));


    }

    /*
    IN future could add updateButtons plural function, to update all buttons after
    an upgrade affects their total passive (if we add such an upgrade). Hooray for modularization
     */
    public static void updateButton(String btn){


        switch(btn){
            case "neutral1":
                n1.setText(MainActivity.neutral1.printStats());
                break;
            case "neutral2":
                n2.setText(MainActivity.neutral2.printStats());
                break;
            case "neutral3":
                n3.setText(MainActivity.neutral3.printStats());
                break;
            case "p1":
                if(MainActivity.pathosEnabled) {
                    p1.setText(MainActivity.pathos1.printStats());
                }
                break;
            case "p2":
                if(MainActivity.pathosEnabled) {
                    p2.setText(MainActivity.pathos2.printStats());
                }
                break;
            case "p3":
                if(MainActivity.pathosEnabled) {
                    p3.setText(MainActivity.pathos3.printStats());
                }
                break;
            case "deity":
                if(MainActivity.pathosEnabled) {
                    deity.setText(MainActivity.deity.printStats());
                }
                break;

        }



    }


    private static void checkUpgrades(){

        if(MainActivity.totalClickValue > 500 && MainActivity.totalClickValue < 5000000) {
            if (clickCoinsflag == 0) {
                UpgradesFragment.nextUpgrade("ClickingCoins", 0);
                clickCoinsflag++;
            } else if (MainActivity.totalClickValue >= 5000000 && MainActivity.totalClickValue < 1000000000)
                if (clickCoinsflag == 1) {
                    UpgradesFragment.nextUpgrade("ClickingCoins", 1);
                    clickCoinsflag++;
                } else if (MainActivity.totalClickValue == 1000000000)//"Integer number too Large" When using 5Billion
                    if (clickCoinsflag == 2) {
                        UpgradesFragment.nextUpgrade("ClickingCoins", 2);
                        clickCoinsflag++;
                    }
        }

    }


}
