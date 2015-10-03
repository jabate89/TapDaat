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

    protected Button mainButton;
    protected static TextView scoreBox;
    protected static int currScore = 0;
    protected static int currPassive = 10;
    protected static int currClickValue = 1;
    private final static int SECOND = 1000;
    protected final Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primary_activity);

        mainButton = (Button) findViewById(R.id.main_button);
        scoreBox = (TextView) findViewById(R.id.score_box);

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
                    currScore += currPassive;
                    scoreBox.setText("" + currScore);
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

    private void incrementScore(){

        currScore += currPassive;
        scoreBox.setText("" + currScore);
    }

    @Override
    public void onClick(View v) {

        currScore += currClickValue;//increment the score by click value
        scoreBox.setText("" + currScore);//print the score to the UI
    }









}
