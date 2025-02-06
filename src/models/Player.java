package models;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Player {

    private String name;
    private static int money;
    private int totalFields = 15;
    private static int round = 1;
    private ArrayList<Fields> myFields = new ArrayList<>();

    public Player(int money, String name){
        this.money = money;
        this.name = name;
    }

    public void startFields(){
        for (int i = 0; i < 15; i++) {
            myFields.add(new Fields());
        }
    }

    public int getTotalFields() {
        return totalFields;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public static int getRound() {
        return round;
    }

    public static void setMoney(int money){
        Player.money += money;
    }

    public void setRound(int round) {
        Player.round = round;
    }

    public ArrayList<Fields> myFields(){
        return myFields;
    }
}
