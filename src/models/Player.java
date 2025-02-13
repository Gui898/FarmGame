package models;

import models.plantables.Plantables;
import models.plantables.Potato;
import models.plantables.Wheat;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private final String name;
    private static int money;
    private static int round = 1;
    private static final Map<Integer, Fields> myFields = new HashMap<>();
    private static int qtdWheat = 0;
    private static int qtdPotato = 0;

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
        if(money >= plant.getBuyValue()){
            Player.setMoney(Player.getMoney() - plant.getBuyValue());
            Player.myFields().get(key).receive(plant);
        }else {
            System.out.println("You don't have money enough for this");
        }
    }

    public void harvesting(Plantables plant, int key){
        if(money >= plant.getHarvestPrice()){
            Player.setMoney(Player.getMoney() - plant.getHarvestPrice());

            Player.myFields.get(key).remove();
        }else {
            System.out.println("You don't have money enough for this");
        }
    }


    //ARRUMA AQUI OH IMBECIL (ACHO Q O PROBLEMA TA NA VERIFICAÇÃO DA CLASSE)
    public void sellPlants(Object plantType, int price){
        if(plantType.getClass() == Wheat.class){
            money += qtdWheat*price;
            System.out.println("+$" + qtdWheat*price);
            qtdWheat = 0;
        } else if (plantType.getClass() == Potato.class) {
            money += qtdPotato*price;
            System.out.println("+$" + qtdPotato*price);
            qtdPotato = 0;
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

    public int getQtdWheat() {
        return qtdWheat;
    }

    public static void setQtdWheat(int qtdWheat){
        Player.qtdWheat += qtdWheat;
    }

    public int getQtdPotato() {
        return qtdPotato;
    }

    public static void setQtdPotato(int qtdPotato) {
        Player.qtdPotato += qtdPotato;
    }
}
