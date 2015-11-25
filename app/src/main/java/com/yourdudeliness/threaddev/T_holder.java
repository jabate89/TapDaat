package com.yourdudeliness.threaddev;

/**
 * Created by edincristofi on 11/19/15.
 */
public class T_holder {

    private String name;
    private int tier;
    private int required;
    private int iconid;
    private String bonus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public int getRequired() {
        return required;
    }

    public void setRequired(int required) {
        this.required = required;
    }

    public int getIconid() {
        return iconid;
    }

    public void setIconid(int iconid) {
        this.iconid = iconid;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public T_holder(String name, int tier, int required, int iconid, String bonus) {

        this.name = name;
        this.tier = tier;
        this.required = required;
        this.iconid = iconid;
        this.bonus = bonus;
    }
}
