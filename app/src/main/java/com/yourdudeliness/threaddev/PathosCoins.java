package com.yourdudeliness.threaddev;

/**
 * Created by Awesomeness on 10/19/15.
 */
public class PathosCoins {

    public static int [] coins;

    public PathosCoins(){

        coins = new int[3];

    }


    public void generateCoin(int coin){

        switch(coin){
            case 0:
                coins[coin] += 1;
                primary_activity.coins[coin].setText(coins[coin] + "");
                break;
            case 1:
                coins[coin] += 1;
                primary_activity.coins[coin].setText(coins[coin] + "");
                break;
            case 2:
                coins[coin] += 1;
                primary_activity.coins[coin].setText(coins[coin] + "");
                break;
        }
    }
}
