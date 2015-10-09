package com.yourdudeliness.threaddev;

/**
 * Created by Awesomeness on 10/7/15.
 */
public class Building {

    private String buildingType;
    private double totalBuildings;
    private double costOfNext;
    private double additionalPassive;

    public Building(String name, double startCost, double passive){

        buildingType = name;//name is building type, defined on object creation
        costOfNext = startCost;//start cost is cost of the first building, increments with each purchase
        additionalPassive = passive;//the passive income produced by the first building
        totalBuildings = 0;//the object is instantiated with 0 buildings
    }


    public void build(){

        MainActivity.currScore -= costOfNext;//subtracts the cost of the building

        totalBuildings += 1;//increments number of buildings
        MainActivity.currPassive += additionalPassive;//increments passive score in main

        costOfNext *= 1.07; //increments the cost of the next building by 7%
         /*
         Need to create a value to additional passive, figure out how much that should
         increase as we increase number of buildings
          */

    }
}
