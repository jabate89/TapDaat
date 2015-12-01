package com.yourdudeliness.threaddev;

import android.os.CountDownTimer;

/**
 * Created by Awesomeness on 10/20/15.
 */
public class SpellCast {


    public static void power1(){

        MainActivity.currMana -= 350;
        MainActivity.currScore += (MainActivity.currPassive * 10);




    }

    public static void power2(){
        MainActivity.currMana -= 600;
        new CountDownTimer(15000, 200) {

            public void onTick(long millisUntilFinished) {
                primary_activity.cp2.setEnabled(false);
                MainActivity.currClickVal = MainActivity.baseClickVal + (10 * (int)MainActivity.currPassive);



            }

            public void onFinish() {
                MainActivity.currClickVal = MainActivity.baseClickVal;
                primary_activity.cp2.setEnabled(true);

            }
        }.start();

    }

    public static void power3(){

        MainActivity.currMana -= 750;

        new CountDownTimer(15000, 200) {

            public void onTick(long millisUntilFinished) {
                primary_activity.cp3.setEnabled(false);
                MainActivity.currClickVal = MainActivity.baseClickVal + (10 * (int)MainActivity.currPassive);



            }

            public void onFinish() {
                MainActivity.currClickVal = MainActivity.baseClickVal;
                primary_activity.cp3.setEnabled(true);

            }
        }.start();

    }






}
