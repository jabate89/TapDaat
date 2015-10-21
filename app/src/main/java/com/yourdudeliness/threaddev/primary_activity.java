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
    /*
    CAN pass anything desired to newInstance() method, similar to a constructor.
    Can be used for passing data to a fragment
     */
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
                MainActivity.testUpgradeBonus();//DELETE ###############
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


        coins = new TextView[3];
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

        //DELETE ###########################  TESTING STUFF
    }

    public static void incrementScore(){

        MainActivity.currScore += MainActivity.currClickVal;
        printScore();
        isCoin = coinGen.nextInt(100);
        if(isCoin == 69 || isCoin == 41){

            coinCollection.generateCoin(coinGen.nextInt(3));
        }
        MainActivity.checkFunds();



    }

    /*
    Function accepts a string of "good" or "evil", and initializeds the
    pathos buttons and their names accordingly
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
                n1.setText(MainActivity.neutral1.getName() +  "     "
                        + (int)MainActivity.neutral1.getTotalBuildings()
                        + "\n Cost " + (int)MainActivity.neutral1.getCostOfNext()
                        + "    Output " + MainActivity.neutral1.getCumulativePassive());
                break;
            case "n2":
                n2.setText(MainActivity.neutral2.getName() +  "     "
                        + (int)MainActivity.neutral2.getTotalBuildings()
                        + "\n Cost " + (int)MainActivity.neutral2.getCostOfNext()
                        + "    Output " + MainActivity.neutral2.getCumulativePassive());
                break;
            case "n3":
                n3.setText(MainActivity.neutral3.getName() +  "     "
                        + (int)MainActivity.neutral3.getTotalBuildings()
                        + "\n Cost " + (int)MainActivity.neutral3.getCostOfNext()
                        + "    Output " + MainActivity.neutral3.getCumulativePassive());
                break;
            case "p1":
                if(MainActivity.pathosEnabled) {
                    p1.setText(MainActivity.pathos1.getName() + "     "
                            + (int) MainActivity.pathos1.getTotalBuildings()
                            + "\n Cost " + (int) MainActivity.pathos1.getCostOfNext()
                            + "    Output " + MainActivity.pathos1.getCumulativePassive());
                }
                break;
            case "p2":
                if(MainActivity.pathosEnabled) {
                    p2.setText(MainActivity.pathos2.getName() + "     "
                            + (int) MainActivity.pathos2.getTotalBuildings()
                            + "\n Cost " + (int) MainActivity.pathos2.getCostOfNext()
                            + "    Output " + MainActivity.pathos2.getCumulativePassive());
                }
                break;
            case "p3":
                if(MainActivity.pathosEnabled) {
                    p2.setText(MainActivity.pathos2.getName() + "     "
                            + (int) MainActivity.pathos2.getTotalBuildings()
                            + "\n Cost " + (int) MainActivity.pathos2.getCostOfNext()
                            + "    Output " + MainActivity.pathos2.getCumulativePassive());
                }
                break;
            case "deity":
                if(MainActivity.pathosEnabled) {
                    deity.setText(MainActivity.deity.getName() + "     "
                            + (int) MainActivity.deity.getTotalBuildings()
                            + "\n Cost " + (int) MainActivity.deity.getCostOfNext()
                            + "    Output " + MainActivity.deity.getCumulativePassive());
                }
                break;

        }



    }



}
