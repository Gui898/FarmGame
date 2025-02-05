import models.plantables.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Player player = new Player(20000, "Guilherme");
        Wheat wheatBase = new Wheat(2000,150,3, 500);
        Potato potatoBase = new Potato(1000, 200, 2, 1000);

        int round = 1;
        int priceDecay = 0;

        String menu = String.format("""
                
                1- Plant Wheat;                 Player: %s
                3- Harvest Wheat;               Money: $%d
                2- Plant Potatoes;              Price Decay: %d%%
                5- Sell Wheat;                  Fields: %d
                4- Harvest Potatoes;            Round: %d
                6- Sell Potatoes;
                7- Raise 1 field.
                """,
                player.getName(),
                player.getMoney(),
                priceDecay,
                player.getTotalFields(),
                round
        );

        while(true){
            System.out.println(menu);
            System.out.println("Select a number to do the action");
            int answer = scan.nextInt();

            switch (answer){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }



    }
}