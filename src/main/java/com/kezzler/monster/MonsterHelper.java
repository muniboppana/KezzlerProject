package com.kezzler.monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonsterHelper {
    static Random random = new Random();

    public static void getStolenFoodFromSleepingMonsters(List<Monster> monsterList, Monster stolenMonster) {

        if(monsterList.size()>1) {

            //cheking already food stolen one monster then no need to stolen any one second time
            boolean isFoodStolenAlready = false;
            for (Monster monster : monsterList) {
                if (monster.isFoodStolen()) {
                    isFoodStolenAlready = true;
                    break;
                }
            }

            if (!isFoodStolenAlready) {
                //stole food from sleeping monsters
                List<Monster> sleePingMonsters = new ArrayList<Monster>();
                for(Monster monster:monsterList) {
                    if(!monster.isMonsterWakeUp()) {
                        sleePingMonsters.add(monster);
                    }
                }
                Monster foodGivingMonster = getRandomStolenMonster(sleePingMonsters);
                for (Monster monster : monsterList) {

                    if (monster.getMonsterName().equalsIgnoreCase(foodGivingMonster.getMonsterName())) {
                        monster.setFoodGiven(true);
                        if (monster.isStolenPacketFoodPoisned()) {
                            stolenMonster.setStolenPacketFoodPoisned(true);
                        } else {
                            stolenMonster.setStolenPacketFoodPoisned(false);
                        }
                        stolenMonster.setFoodStolen(true);
                        stolenMonster.setStolenFoodCalories(monster.getRandomPacketCalories());
                        stolenMonster.setFoodGivenMonsterName(monster.getMonsterName());
                        break;
                    }
                }

                //updating total monster values with stolen info
                for (Monster monster : monsterList) {
                    if (monster.getMonsterName().equalsIgnoreCase(stolenMonster.getMonsterName())) {
                        monster.setStolenPacketFoodPoisned(stolenMonster.isStolenPacketFoodPoisned());
                        monster.setFoodStolen(stolenMonster.isFoodStolen());
                        monster.setStolenFoodCalories(stolenMonster.getStolenFoodCalories());
                        monster.setFoodGivenMonsterName(stolenMonster.getFoodGivenMonsterName());
                    }
                }
            }
        }
    }

    public static Monster getRandomStolenMonster(List<Monster> monsterList) {
        return getStolenFoodFromSleepingMonsterList(monsterList);

    }

    /**
     *
     * @param monsterList
     */
    public static void initialFooddistributedForMonsters(List<Monster> monsterList) {

        Monster staticPoisnedFoodPkt =  getstaticllyPoisonedFoodPacketFromList(monsterList);
        for(Monster monster: monsterList) {
            monster.setStolenPacketFoodPoisned(false);
            monster.setMonsterWakeUp(false);
            monster.setFoodStolen(false);
            monster.setFoodServed(false);
            monster.setFoodGiven(false);
            monster.setStolenFoodCalories(0);
            monster.setRandomPacketCalories(getRandomCaloriesFood());
            if(staticPoisnedFoodPkt.getMonsterName().equalsIgnoreCase(monster.getMonsterName())) {
                int position = noofPosionpacketsInList(monsterList.size());
                if (position > 0 ) {
                    monster.setStolenPacketFoodPoisned(true);
                }
            }
        }

    }

    public static int noofPosionpacketsInList(int monsterListSize) {
        return (int) Math.round (monsterListSize*MonsterConstants.poisnedFoodPackets);
    }

    public static Monster getstaticllyPoisonedFoodPacketFromList(List<Monster> monsterList) {
        int position= getRandomPosineAssignment(monsterList.size());
        return monsterList.get(position);
    }

    public static int getRandomPosineAssignment(int size) {
        return random.nextInt(size);
    }

    public static int getRandomCaloriesFood () {
        return random.nextInt(MonsterConstants.foodPacketRandomCalories);
    }

    public static Monster getStolenFoodFromSleepingMonsterList(List<Monster> monsterList) {
        int position= getRandomPosineAssignment(monsterList.size());
        return monsterList.get(position);
    }

}
