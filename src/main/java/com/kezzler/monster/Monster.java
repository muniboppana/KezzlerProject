package com.kezzler.monster;

public class Monster  {

    private String monsterName;
    private int calories;
    private int randomPacketCalories;
    private int poisnedFoodPocket;
    private boolean foodServed = false;
    private boolean foodStolen = false;
    private boolean foodGiven = false;
    private boolean stolenPacketFoodPoisned;
    private boolean monsterWakeUp = false;    
    private int stolenFoodCalories ;
    private String foodGivenMonsterName;

    /**
     *
     * @param monsterName
     * @param calories
     */
    public Monster(String monsterName,  int calories) {
        this.monsterName = monsterName;
        this.calories = calories;
    }


    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getRandomPacketCalories() {
        return randomPacketCalories;
    }

    public void setRandomPacketCalories(int randomPacketCalories) {
        this.randomPacketCalories = randomPacketCalories;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getCalories() {
        return calories;
    }
    public int getPoisnedFoodPocket() {
        return poisnedFoodPocket;
    }

    public void setPoisnedFoodPocket(int poisnedFoodPocket) {
        this.poisnedFoodPocket = poisnedFoodPocket;
    }
    public boolean isFoodServed() {
        return foodServed;
    }

    public void setFoodServed(boolean foodServed) {
        this.foodServed = foodServed;
    }

    public boolean isFoodStolen() {
        return foodStolen;
    }

    public void setFoodStolen(boolean foodStolen) {
        this.foodStolen = foodStolen;
    }

    public boolean isFoodGiven() {
        return foodGiven;
    }

    public void setFoodGiven(boolean foodGiven) {
        this.foodGiven = foodGiven;
    }
    public boolean isStolenPacketFoodPoisned() {
        return stolenPacketFoodPoisned;
    }

    public void setStolenPacketFoodPoisned(boolean stolenPacketFoodPoisned) {
        this.stolenPacketFoodPoisned = stolenPacketFoodPoisned;
    }
    public boolean isMonsterWakeUp() {
        return monsterWakeUp;
    }

    public void setMonsterWakeUp(boolean monsterWakeUp) {
        this.monsterWakeUp = monsterWakeUp;
    }
    public int getStolenFoodCalories() {
        return stolenFoodCalories;
    }

    public void setStolenFoodCalories(int stolenFoodCalories) {
        this.stolenFoodCalories = stolenFoodCalories;
    }

    public String getFoodGivenMonsterName() {
        return foodGivenMonsterName;
    }

    public void setFoodGivenMonsterName(String foodGivenMonsterName) {
        this.foodGivenMonsterName = foodGivenMonsterName;
    }

    /**
     *
     * @return
     */
    public String toString() {
        return  "Monster Name: "+  this.monsterName  +   "  "   +  "  Calories  :  ( "+ this.calories+  " )    "+ " food packet Calories: " + this.randomPacketCalories;
    }


}
