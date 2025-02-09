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
        Wheat wheatBase = new Wheat(2000,150,3, 500);
        Potato potatoBase = new Potato(1000, 200, 2, 1000);
        ArrayList<Integer> availableFields = new ArrayList<>();

        int round = Player.getRound();


        while(true){
            int money = Player.getMoney();
            System.out.printf("""
              
                    1- Plant;                       Player: %s
                    2- Harvest;                     Money: $%d
                    3- Sell;                        Fields: %d
                    4- Raise 1 field;               Round: %d
                    5- Show fields status.
                    %n""",
                    player.getName(),
                    money,
                    player.getTotalFields(),
                    round);

            System.out.println("Select a number to do the action");
            int answer = scan.nextInt();
            int ansPlant;
            int ansField;

            switch (answer){
                case 1:
                    System.out.println("Available fields:");
                    for(int key : Player.myFields().keySet()){
                        if(Player.myFields().get(key).getAbleToUse()){
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
                                player.planting(wheatBase, keyField);
                                break;

                            case 2:
                                player.planting(potatoBase, keyField);
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

            round++;
            Player.setRound(round);
        }



    }
}