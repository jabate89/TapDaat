package com.yourdudeliness.threaddev;


import android.view.View.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link primary_activity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class primary_activity extends Fragment implements OnClickListener {

    protected static Button mainButton, n1, n2, n3, p1, p2, p3, deity, cp1, cp2, cp3;
    public static ProgressBar manaBar;
    public static TextView scoreBox;
    public static TextView [] coins;
    public static Random coinGen;
    public static int isCoin;
    public static PathosCoins coinCollection;


    //TEST#########################################
    public static TextView clickTest, passiveTest;
    //TEST########################################





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
                break;
            case R.id.neutral_1:
                MainActivity.neutral1.build();
                updateButton("n1");
                break;
            case R.id.neutral_2:
                MainActivity.neutral2.build();
                updateButton("n2");
                break;
            case R.id.neutral_3:
                MainActivity.neutral3.build();
                updateButton("n3");
                break;
            case R.id.pathos_1:
                if(MainActivity.pathosEnabled){

                }
                break;
            case R.id.pathos_2:
                if(MainActivity.pathosEnabled){

                }
                break;

            case R.id.pathos_3:
                if(MainActivity.pathosEnabled){

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



        /*
        Assign all the XML buttons to java objects
         */
        mainButton = (Button) view.findViewById(R.id.main_button);
        n1 = (Button) view.findViewById(R.id.neutral_1);
        n2 = (Button) view.findViewById(R.id.neutral_2);
        n3 = (Button) view.findViewById(R.id.neutral_3);

        p1 = (Button) view.findViewById(R.id.pathos_1);
        p2 = (Button) view.findViewById(R.id.pathos_2);
        p3 = (Button) view.findViewById(R.id.pathos_3);
        deity = (Button) view.findViewById(R.id.deity);


        coins = new TextView[3];//the coins view is used as an array
        coins[0] = (TextView) view.findViewById(R.id.coin_0);
        coins[1] = (TextView)view.findViewById(R.id.coin_1);
        coins[2] = (TextView) view.findViewById(R.id.coin_2);

        updateButton("n1");
        updateButton("n2");
        updateButton("n3");
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
        coinCollection = new PathosCoins();

        //DELETE   #########################   TESTING STUFF
        cp1 = (Button) view.findViewById(R.id.power_1);
        cp1.setOnClickListener(this);

        clickTest = (TextView) view.findViewById(R.id.click_test);
        passiveTest = (TextView) view.findViewById(R.id.passive_test);

        //DELETE ###########################  TESTING STUFF
    }

    /*
    Called on click of the main button. Increments and prints the score the the UI,
    checks if a Pathos Coin is generated (base chance 2%), then randomnly generates
    one of 3 coins.
     */
    public static void incrementScore(){

        MainActivity.currScore += MainActivity.currClickVal;
        printScore();


        isCoin = coinGen.nextInt(100);//generate random number < 100

        if(isCoin == 69 || isCoin == 41){
            //generate a coin if 69 or 41 is generated
            coinCollection.generateCoin(coinGen.nextInt(3));
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
            MainActivity.pathos1 = new Building("Good 1", 100, 50);
            MainActivity.pathos2 = new Building("Good 2", 300, 80);
            MainActivity.pathos3 = new Building("Good 3", 1000, 200);
        }else {
            MainActivity.pathos1 = new Building("Evil 1", 100, 50);
            MainActivity.pathos2 = new Building("Evil 2", 300, 80);
            MainActivity.pathos3 = new Building("Evil 3", 1000, 200);
        }

        p1.setVisibility(View.VISIBLE);
        p2.setVisibility(View.VISIBLE);
        p3.setVisibility(View.VISIBLE);//make the buttons visible
        MainActivity.pathosEnabled = true;

    }


    public static void printScore(){

        scoreBox.setText((int)MainActivity.currScore + "");
    }

    public static void updateButton(String btn){

        switch(btn){
            case "n1":
                n1.setText(MainActivity.neutral1.printStats());
                break;
            case "n2":
                n2.setText(MainActivity.neutral2.printStats());
                break;
            case "n3":
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
