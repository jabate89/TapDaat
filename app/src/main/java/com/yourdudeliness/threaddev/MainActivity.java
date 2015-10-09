package com.yourdudeliness.threaddev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button mainButton, n1, n2, n3, p1, p2, p3, deity, cp1, cp2, cp3;
    protected static TextView scoreBox;
    protected static int currScore = 0;
    protected static int currPassive = 10;
    protected static int currClickValue = 1;
    private final static int SECOND = 1000;
    protected final Handler mHandler = new Handler();
    private Building neutral1, neutral2, neutral3, pathos1, pathos2, pathos3, pathos4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_activity);





        mainButton = (Button) findViewById(R.id.main_button);
        scoreBox = (TextView) findViewById(R.id.score_box);

        initializeButtons();

        mainButton.setOnClickListener(this);//looks for OnClick() function in this class




        /*
        Increments the player's score once every second, printing that score
        to the screen.
         */
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (true) {
                    //whatever you want to do if
                    incrementScorePassive();
                }
                mHandler.postDelayed(this, 1000);
            }
        },1000); // tells it to run itself again in 1 second



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void incrementScorePassive(){

        currScore += currPassive;
        scoreBox.setText("" + currScore);
    }


    /*
    Function is automatically passed the view when a button is clicked/pressed,
    the switch statement checks the id of the pressed button and calls the appropriate function
     */
    @Override
    public void onClick(View v) {

        //switch statement which button was pressed
        switch(v.getId()) {

            case R.id.main_button:
                currScore += currClickValue;//increment the score by click value
                scoreBox.setText("" + currScore);//print the score to the UI
            break;
            case R.id.neutral_1:
                neutral1.build();
                break;
            case R.id.neutral_2:
                neutral2.build();
                break;
            case R.id.neutral_3:
                neutral3.build();
                break;
            case R.id.pathos_1:
                break;
            case R.id.pathos_2:
                break;
            case R.id.pathos_3:
                break;
        }
    }


    /*
    When called initializes all the button objects via the button
    id's in the primary_activity.xml
     */
    public void initializeButtons(){

        neutral1 = new Building("Farm", 10, 1);
        neutral2 = new Building("Blacksmith", 30, 2);
        neutral3 = new Building("Barracks", 50, 5);


        n1 = (Button) findViewById(R.id.neutral_1);
        n2 = (Button) findViewById(R.id.neutral_2);
        n3 = (Button) findViewById(R.id.neutral_3);

        p1 = (Button) findViewById(R.id.pathos_1);
        p2 = (Button) findViewById(R.id.pathos_2);
        p3 = (Button) findViewById(R.id.pathos_3);
        deity = (Button) findViewById(R.id.deity);
    }



    /*
    Function accepts a string of "good" or "evil", and initializeds the
    pathos buttons and their names accordingly
     */
    public void initializePathos(String type){

        if(type == "good"){
            pathos1 = new Building("Good 1", 100, 50);
            pathos2 = new Building("Good 2", 300, 80);
            pathos3 = new Building("Good 3", 1000, 200);
        }else {
            pathos1 = new Building("Evil 1", 100, 50);
            pathos2 = new Building("Evil 2", 300, 80);
            pathos3 = new Building("Evil 3", 1000, 200);
        }

        p1.setVisibility(View.VISIBLE);
        p2.setVisibility(View.VISIBLE);
        p3.setVisibility(View.VISIBLE);//make the buttons visible

    }



}
