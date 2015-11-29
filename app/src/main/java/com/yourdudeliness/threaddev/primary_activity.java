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
                    case 10:
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
                    updateButton("pathos1");
                }
                break;
            case R.id.pathos_2:
                if(MainActivity.pathosEnabled){
                    MainActivity.pathos2.build();
                    updateButton("pathos2");
                }
                break;

            case R.id.pathos_3:
                if(MainActivity.pathosEnabled){
                    MainActivity.pathos3.build();
                    updateButton("pathos3");
                }
                break;
            case R.id.power_1:
                SpellCast.testUpgradeBonus();//DELETE ###############
                //DELETE ############################
                break;
        }

    }




    /*
    When called initializes all the button objects via the button
    id's in the primary_activity.xml
     */
    public void initializeButtons(View view){

        format = new DecimalFormat("0.##E0");
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
        updateButton("p1");
        updateButton("p2");
        updateButton("p3");
        updateButton("deity");


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


        coinGen = new Random();

        //DELETE   #########################   TESTING STUFF
        cp1 = (Button) view.findViewById(R.id.power_1);
        cp1.setOnClickListener(this);

        clickTest = (TextView) view.findViewById(R.id.click_test);
        passiveTest = (TextView) view.findViewById(R.id.passive_test);
        //testbox = (TextView) view.findViewById(R.id.tester);

        //DELETE ###########################  TESTING STUFF
    }

    /*
    Called on click of the main button. Increments and prints the score the the UI,
    checks if a Pathos Coin is generated (base chance 2%), then randomnly generates
    one of 3 coins.
     */
    public static void incrementScore(){

        MainActivity.currScore += MainActivity.currClickVal;
        MainActivity.totalClickValue += MainActivity.currClickVal;
        //primary_activity.testbox.setText(Integer.toString(MainActivity.totalClickValue));
        printScore();
        if(MainActivity.totalClickValue > 499 && MainActivity.totalClickValue < 5000000)
            if(clickCoinsflag == 0) {
                UpgradesFragment.nextUpgrade("ClickingCoins", 0);
                clickCoinsflag++;
            }
        else if(MainActivity.totalClickValue == 5000000)
                if(clickCoinsflag == 1) {
                    UpgradesFragment.nextUpgrade("ClickingCoins", 1);
                    clickCoinsflag++;
                }

        else if(MainActivity.totalClickValue == 1000000000)//"Integer numner too Large" When using 5Billion
                if(clickCoinsflag == 2) {
                    UpgradesFragment.nextUpgrade("ClickingCoins", 2);
                    clickCoinsflag++;
                }

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
    public void initializePathos(String type){

        if(type == "good"){
            MainActivity.pathos1 = new Building("Bank", 55000, 200);
            MainActivity.pathos2 = new Building("Good 2", 450000, 2000);
            MainActivity.pathos3 = new Building("Good 3", 145000000, 100000);
        }else {
            MainActivity.pathos1 = new Building("Prison", 5500, 200);
            MainActivity.pathos2 = new Building("Evil 2", 450000, 2000);
            MainActivity.pathos3 = new Building("Evil 3", 145000000, 100000);
        }

        p1.setVisibility(View.VISIBLE);
        p2.setVisibility(View.VISIBLE);
        p3.setVisibility(View.VISIBLE);//make the buttons visible
        MainActivity.pathosEnabled = true;

    }


    public static void printScore(){

            scoreBox.setText("Bounty  " + (int)MainActivity.currScore);
            MainActivity.coinCollection.printCoin();
        primary_activity.clickTest.setText("Clk " + MainActivity.currClickVal);
        primary_activity.passiveTest.setText("Sec " + MainActivity.currPassive);


    }

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





}
