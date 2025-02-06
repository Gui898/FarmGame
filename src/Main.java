import models.Fields;
import models.Player;
import models.plantables.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Player player = new Player(20000, "Guilherme");
        player.startFields();
        Wheat wheatBase = new Wheat(2000,150,3, 500);
        Potato potatoBase = new Potato(1000, 200, 2, 1000);

        int round = player.getRound();

        String menu = String.format("""
                
                1- Plant Wheat;                 Player: %s
                3- Harvest Wheat;               Money: $%d
                2- Plant Potatoes;              Inflation: %d%%
                5- Sell Wheat;                  Fields: %d
                4- Harvest Potatoes;            Round: %d
                6- Sell Potatoes;
                7- Raise 1 field.
                """,
                player.getName(),
                player.getMoney(),
                Plantables.getInflation(),
                player.getTotalFields(),
                round
        );

        while(true){
            System.out.println(menu);
            System.out.println("Select a number to do the action");
            int answer = scan.nextInt();

            switch (answer){
                case 1:
                    int count = 1;
                    for(Fields a : player.myFields()){
                        System.out.println(count + " " + a.toString());
                        count++;
                    }
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