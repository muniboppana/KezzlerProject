package com.kezzler.monster;

public class MonsterService extends Thread {

    private Monster monster;

    MonsterService(Monster monster) {
        this.monster = monster;
    }

    public void run() {
        if (this.monster.getCalories() > 0) {

            if (this.monster.isFoodStolen()) {
                System.out.println(this.monster.getMonsterName() + "    stole  food from   " + this.monster.getFoodGivenMonsterName());
                if (this.monster.isStolenPacketFoodPoisned()) {
                    this.monster.setCalories(this.monster.getCalories() + this.monster.getRandomPacketCalories() - this.monster.getStolenFoodCalories() - MonsterConstants.burnCalories);
                    System.out.println("Oh no " + this.monster.getMonsterName() + " was poisoned     " + this.monster.getCalories() + "   left");
                } else {
                    this.monster.setCalories(this.monster.getCalories() + this.monster.getRandomPacketCalories() + this.monster.getStolenFoodCalories() - MonsterConstants.burnCalories);
                }
            } else {
                this.monster.setCalories(this.monster.getCalories() + this.monster.getRandomPacketCalories() - MonsterConstants.burnCalories);
                System.out.println(this.monster.getMonsterName() + "   not stolen  food from  any monster " + this.monster.getCalories() + " left");
            }

        }
    }


}
