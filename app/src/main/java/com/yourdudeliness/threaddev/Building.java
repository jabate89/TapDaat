package com.yourdudeliness.threaddev;

/**
 * Created by Awesomeness on 10/18/15.
 */
public class Building {

    private String buildingType;
    private int totalBuildings;
    private int costOfNext;
    private int BasePassive;
    private int passiveMultiplier;
    private int cumulativePassive;


    public Building(String name, int startCost, int passive){

        buildingType = name;//name is building type, defined on object creation
        costOfNext = startCost;//start cost is cost of the first building, increments with each purchase
        BasePassive = passive;//the passive income produced by the first building
        totalBuildings = 0;//the object is instantiated with 0 building
        cumulativePassive = 0; // the Passive of all buildings of same type
    }


    public void build() {

        if (costOfNext <= MainActivity.currScore) {
            MainActivity.currScore -= costOfNext;//subtracts the cost of the building
            primary_activity.printScore();
            MainActivity.checkFunds();

            totalBuildings += 1;//increments number of buildings
            cumulativePassive = BasePassive * totalBuildings;
            MainActivity.updatePassive();
            //MainActivity.currPassive += BasePassive * passiveMultiplier;//increments passive score in main

            costOfNext *= 1.15; //increments the cost of the next building by 7%
        }
             /*
             Need to create a value to additional passive, figure out how much that should
             increase as we increase number of buildings
              */

        switch (buildingType) {
            case "Farm":
                primary_activity.testbox.setText("Add upgrade");
                switch (totalBuildings) {
                    case 5:
                        primary_activity.testbox.setText("Add upgrade Case 5");
                        UpgradesFragment.nextUpgrade("Farm", 0);
                        break;
                    case 25:
                        UpgradesFragment.nextUpgrade("Farm", 1);
                        primary_activity.testbox.setText("Add upgrade Case 25");
                        break;
                    case 75:
                        UpgradesFragment.nextUpgrade("Farm", 2);
                        break;
                }
                break;

            case "Inn":
                switch (totalBuildings) {
                    case 5:
                        UpgradesFragment.nextUpgrade("Inn", 0);
                        break;
                    case 25:
                        UpgradesFragment.nextUpgrade("Inn", 1);
                        break;
                    case 75:
                        UpgradesFragment.nextUpgrade("Inn", 2);
                        break;
                }
                break;

            case "Blacksmith":
                switch (totalBuildings) {
                    case 5:
                        UpgradesFragment.nextUpgrade(buildingType, 0);
                        break;
                    case 25:
                        UpgradesFragment.nextUpgrade(buildingType, 1);
                        break;
                    case 75:
                        UpgradesFragment.nextUpgrade(buildingType, 2);
                        break;
                }
                break;
        }

    }

    public double getCostOfNext(){
        return costOfNext;
    }

    public double getTnotalBuildigs(){
        return totalBuildings;
    }

    public String getName(){
        return buildingType;
    }

    public void setBasePassive(int multiplier){BasePassive = BasePassive * multiplier;}

    public void updateCumulativePassive(){
        cumulativePassive = BasePassive * totalBuildings;
    }

    public int getCumulativePassive() { return cumulativePassive; }

    public String printStats(){
        return   ( buildingType + "     "
                + (int) totalBuildings
                + "\n Cost " + (int) costOfNext
                + "    Output " + cumulativePassive);
    }
}
