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

    /*
    Increase the value per click by 5 * currentPassive, for a duration of 15 seconds
     */
    public static void power2(){
        MainActivity.currMana -= 600;
        final double valHolder = MainActivity.baseClickVal; //holds the original click value to be reset at the end
        new CountDownTimer(15000, 200) {

            public void onTick(long millisUntilFinished) {
                primary_activity.cp2.setEnabled(false);//disable the button so spell cannot run twice at once
                MainActivity.baseClickVal += (5 * (int)MainActivity.currPassive);



            }

            public void onFinish() {
                MainActivity.baseClickVal = valHolder;
                primary_activity.cp2.setEnabled(true);

            }
        }.start();

    }

    public static void power3(){

        MainActivity.currMana -= 750;
        final double valHolder = MainActivity.currPassive;
        new CountDownTimer(10000, 200) {

            public void onTick(long millisUntilFinished) {
                primary_activity.cp3.setEnabled(false);
                MainActivity.currPassive *= 15;



            }

            public void onFinish() {
                MainActivity.currPassive = valHolder;
                primary_activity.cp3.setEnabled(true);

            }
        }.start();

    }






}
