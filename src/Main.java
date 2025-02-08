import models.Fields;
import models.Player;
import models.plantables.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Player player = new Player(20000, "Guilherme");
        int money = Player.getMoney();
        player.startFields();
        Wheat wheatBase = new Wheat(2000,150,3, 500);
        Potato potatoBase = new Potato(1000, 200, 2, 1000);
        ArrayList<Integer> availableFields = new ArrayList<>();

        int round = Player.getRound();


        while(true){
            System.out.printf("""
              
                    1- Plant;                       Player: %s
                    2- Harvest;                     Money: $%d
                    3- Sell;                        Inflation: %d%%
                    4- Raise 1 field.               Fields: %d
                    5- Show fields status           Round: %d
                    %n""",
                    player.getName(),
                    money,
                    Plantables.getInflation(),
                    player.getTotalFields(),
                    round);

            System.out.println("Select a number to do the action");
            int answer = scan.nextInt();
            int ansPlant;
            int ansField;

            switch (answer){
                case 1:
                    System.out.println("Available fields:");
                    for(int key : player.myFields().keySet()){
                        if(player.myFields().get(key).getAbleToUse()){
                            System.out.print(key + ", ");
                            availableFields.add(key);
                        }
                    }

                    System.out.println("Enter the field you choose");
                    ansField = scan.nextInt();
                    boolean thereIs = false;
                    int keyField = 0;
                    for(int a : availableFields){
                        if(ansField == a){
                            thereIs = true;
                            keyField = a;
                        }
                    }
                    if(thereIs){
                        System.out.println("\nWhat do you wanna plant?");
                        System.out.println("1- Wheat | 2- Potato");
                        ansPlant = scan.nextInt();
                        switch (ansPlant){
                            case 1:
                                Player.setMoney(money - wheatBase.getBuyValue());
                                player.myFields().get(keyField).receive(wheatBase);
                                break;

                            case 2:
                                Player.setMoney(money - potatoBase.getBuyValue());
                                player.myFields().get(keyField).receive(potatoBase);
                                break;
                            default:
                                break;
                        }
                    }else{
                        System.out.println("You can't plant there!");
                    }
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    if(money >= 1000){
                        Player.setMoney(money - 1000);
                        player.myFields().put(player.myFields().size()+1, new Fields());
                        System.out.println("One more field for you!");
                    }else {
                        System.out.println("You don't have money to buy this!");
                    }
                    break;

                case 5:
                    for(int key : player.myFields().keySet()){
                        System.out.print(key + " - " + player.myFields().get(key));
                    }
                    break;
                default:
                    break;
            }

            round++;
            Player.setRound(round);
        }



    }
}