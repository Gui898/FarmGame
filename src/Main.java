import models.Fields;
import models.Player;
import models.plantables.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Player player = new Player(20000, "Guilherme");
        player.startFields();
        Wheat wheatBase = new Wheat();
        Potato potatoBase = new Potato();
        ArrayList<Integer> availableFieldsToPlant = new ArrayList<>();
        ArrayList<Integer> availableFieldsToHarvest = new ArrayList<>();

        int round = Player.getRound();
        boolean end = true;

        while(end){
            int money = Player.getMoney();

            //The menu
            System.out.printf("""
              
                    1- Plant;                       Player: %s
                    2- Harvest;                     Money: $%d
                    3- Sell;                        Fields: %d
                    4- Raise 1 field;               Round: %d
                    5- Show fields status.          Wheat: %d
                    6- Exit                         Potato: %d
                    %n""",
                    player.getName(),
                    money,
                    player.getTotalFields(),
                    round,
                    player.getQtdWheat(),
                    player.getQtdPotato());

            System.out.println("Select a number to do the action");
            int answer = scan.nextInt();
            int ansPlant;
            int ansField;
            boolean thereIs = false;
            int keyField = 0;
            int indexKey = 0;

            switch (answer){
                case 1:

                    //Take all fields that we can plant in, and show too.
                    System.out.println("Available fields:");
                    for(int key : Player.myFields().keySet()){
                        if(Player.myFields().get(key).getAbleToUse()){
                            System.out.print(key + ", ");
                            availableFieldsToPlant.add(key);
                        }
                    }

                    //Verify if the field we chose exist in availableFieldsToPlant.
                    System.out.println("Enter the field you choose");
                    ansField = scan.nextInt();

                    for(int a : availableFieldsToPlant){
                        if(ansField == a){
                            thereIs = true;
                            keyField = a;
                        }
                    }

                    // If it exists, we select and plant in.
                    if(thereIs){
                        System.out.println("\nWhat do you wanna plant?");
                        System.out.println("1- Wheat | 2- Potato");
                        ansPlant = scan.nextInt();
                        switch (ansPlant){
                            case 1:
                                player.planting(wheatBase, keyField);
                                indexKey = availableFieldsToPlant.indexOf(keyField);
                                availableFieldsToPlant.remove(indexKey);
                                break;

                            case 2:
                                player.planting(potatoBase, keyField);
                                indexKey = availableFieldsToPlant.indexOf(keyField);
                                availableFieldsToPlant.remove(indexKey);
                                break;
                            default:
                                break;
                        }
                    }else{
                        System.out.println("You can't plant here!");
                    }
                    break;

                case 2:

                    //Take all fields that we can harvest in, and show too.
                    System.out.println("\nAvailable fields to harvest:");
                    for (int key : Player.myFields().keySet()){
                        if(Player.myFields().get(key).verifyGrowth()){
                            System.out.print(key + ", ");
                            availableFieldsToHarvest.add(key);
                        }
                    }
                    // If it exists, we select and harvest in.
                    if(availableFieldsToHarvest.isEmpty()){
                        System.out.println("There aren't plants to collect");
                    }else{
                        System.out.println("Enter the field you choose");
                        ansField = scan.nextInt();
                        for(int a : availableFieldsToHarvest){
                            if(ansField == a){
                                thereIs = true;
                                keyField = a;
                            }
                        }

                        if(thereIs){
                            if(Player.myFields().get(keyField).getItem() == Wheat.class){
                                player.harvesting(wheatBase, keyField);
                            }else if(Player.myFields().get(keyField).getItem() == Potato.class){
                                player.harvesting(potatoBase, keyField);
                            }
                        }else{
                            System.out.println("You can't harvest here!");
                        }
                    }


                    break;

                case 3:
                    break;

                case 4:
                    if(money >= 1000){
                        Player.setMoney(money - 1000);
                        Player.myFields().put(Player.myFields().size()+1, new Fields());
                        System.out.println("One more field for you!");
                    }else {
                        System.out.println("You don't have money to buy this!");
                    }
                    break;

                case 5:
                    for(int key : Player.myFields().keySet()){
                        System.out.print(key + " - " + Player.myFields().get(key));
                    }
                    break;
                case 6:
                    end = false;
                    break;
                default:
                    break;
            }

            if(answer != 5){
                round++;
                Player.setRound(round);
            }
        }



    }
}