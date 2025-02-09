package models;

import models.plantables.Plantables;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private static int money;
    private static int round = 1;
    private static Map<Integer, Fields> myFields = new HashMap<>();

    public Player(int money, String name){
        Player.money = money;
        this.name = name;
    }

    public void startFields(){
        for (int i = 1; i <= 15; i++) {
            myFields.put(i ,new Fields());
        }
    }

    public void planting(Plantables plant, int key){
        if(Player.getMoney() >= plant.getBuyValue()){
            Player.setMoney(Player.getMoney() - plant.getBuyValue());
            Player.myFields().get(key).receive(plant);
        }else {
            System.out.println("You don't have money enough for this");
        }
    }

    public int getTotalFields() {
        return myFields().size();
    }

    public static int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public static int getRound() {
        return round;
    }

    public static void setMoney(int money){
        Player.money = money;
    }

    public static void setRound(int round) {
        Player.round = round;
    }

    public static Map<Integer, Fields> myFields(){
        return myFields;
    }

}
