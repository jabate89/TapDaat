package com.yourdudeliness.threaddev;

import android.os.CountDownTimer;

/**
 * Created by Awesomeness on 10/20/15.
 */
public class SpellCast {


    public static void testUpgradeBonus(){


        new CountDownTimer(15000, 200) {

            public void onTick(long millisUntilFinished) {
                    primary_activity.cp1.setEnabled(false);
                    MainActivity.currClickVal = MainActivity.baseClickVal + (10 * (int)MainActivity.currPassive);
                    MainActivity.currMana = 0;



                }

            public void onFinish() {
        MainActivity.currClickVal = MainActivity.baseClickVal;
                primary_activity.cp1.setEnabled(true);

            }
        }.start();




    }






}
