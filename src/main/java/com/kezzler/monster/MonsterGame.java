package com.kezzler.monster;

import java.util.ArrayList;
import java.util.List;

public class MonsterGame {

    static List<Monster> monsterList = new ArrayList<Monster>();

    public static void main(String args[]) throws Exception {
        for (int i = 0; i < MonsterConstants.monsterSize; i++) {
            monsterList.add(new Monster("Monster " + i ,  MonsterConstants.calories) );
        }
        System.out.println(monsterList);

        boolean isResult = true;
        do {

            if(monsterList.size() > 1) {
                MonsterHelper.initialFooddistributedForMonsters(monsterList);
                List<Monster> ripMonsters = new ArrayList<Monster>();
                for (final Monster monster : monsterList) {
                    monster.setMonsterWakeUp(true);
                    //checking the Monster food stolen or not from Others
                    monster.setFoodServed(true);
                    MonsterHelper.getStolenFoodFromSleepingMonsters(monsterList, monster);
                    if(monster.getCalories() > 0) {
                        new MonsterService(monster).start();
                    }
                    //RIP Monster List
                    if (monster.getCalories() == 0) {
                        System.out.println(monster.getMonsterName() + "  RIP  ");
                        ripMonsters.add(monster);
                    }
                }

                if (ripMonsters.size() > 0) {
                    monsterList.removeAll(ripMonsters);
                }

            }
                if(monsterList.size() ==1) {
                System.out.println("The winner is "+monsterList.get(0).getMonsterName() + " with  "+ monsterList.get(0).getCalories() + "left");
                isResult = false;
             }
        }while (isResult) ;

    }


}

