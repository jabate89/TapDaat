package com.yourdudeliness.threaddev;

public class Up_Holder {
    private String name;
    private int cost;
    private int iconID;
    private String bonus;

    public Up_Holder(String name, int cost, int iconID, String bonus) {
        this.name = name;
        this.cost = cost;
        this.iconID = iconID;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getIconID() {
        return iconID;
    }

    public String getBonus() {
        return bonus;
    }


}
