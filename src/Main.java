import models.Fields;
import models.Player;
import models.events.Climate;
import models.plantables.*;

import java.util.ArrayList;
import java.util.Random;
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

        while(true){

            Climate.climateEvent(new Random().nextInt(Climate.getMaxValue())+1);

            int money = Player.getMoney();

            if(money < 500){
                System.out.println("YOU LOST");
                break;
            } else if (Player.myFields().size() >= 100) {
                System.out.println("YOU WON, CONGRATS BRO!!!");
                break;
            }

            //The menu
            System.out.printf("""
              
                    1- Plant;                       Player: %s
                    2- Harvest;                     Money: $%d
                    3- Sell;                        Fields: %d
                    4- Raise 1 field;               Round: %d
                    5- Show fields status.          Wheat: %d
                                                    Potato: %d
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
            int indexKey;

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
                                indexKey = availableFieldsToHarvest.indexOf(keyField);
                                availableFieldsToHarvest.remove(indexKey);
                            }else if(Player.myFields().get(keyField).getItem() == Potato.class){
                                player.harvesting(potatoBase, keyField);
                                indexKey = availableFieldsToHarvest.indexOf(keyField);
                                availableFieldsToHarvest.remove(indexKey);
                            }
                        }else{
                            System.out.println("You can't harvest here!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Which plant do you wanna sell?");
                    System.out.println("1- Wheat | 2- Potato");
                    ansPlant = scan.nextInt();
                    if(ansPlant < 0 || ansPlant > 2){
                        System.out.println("Enter a valid number");
                        ansPlant = scan.nextInt();
                    }
                    switch (ansPlant){
                        case 1:
                            player.sellPlants(wheatBase, wheatBase.getSellValue());
                            break;
                        case 2:
                            player.sellPlants(potatoBase, potatoBase.getSellValue());
                            break;
                        default:
                            break;
                    }
                    break;

                case 4:
                    if(money >= 1000){
                        player.loseMoney(1000);
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
                default:
                    break;
            }

            if(answer != 5){
                round++;
                Player.setRound(round);
            }

            if(round %5 == 0 && round %15 != 0){
                System.out.println("You paid the tax");
                System.out.println("-$2000");
                player.loseMoney(2000);
            } else if (round %15 == 0) {
                System.out.println("The tornado passed here, you need to reconstruct the plantation");
                System.out.println("-$10000");
                player.loseMoney(10000);
            }

        }



    }
}