package com.yourdudeliness.threaddev;

/**
 * Created by Awesomeness on 10/19/15.
 */
public class PathosCoins {

    public int [] coins;

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

    public void printCoin(){
        for(int i = 0; i < 3; i ++){
            primary_activity.coins[i].setText(coins[i] + "");
        }
    }
}
