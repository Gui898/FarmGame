package models;

import models.plantables.Plantables;
import models.Player;

public class Fields {

    private static boolean ableToUse = true;
    private static Plantables item;
    private static int qtdItem = item.getQtd();
    private static int roundPlanted = item.getTimePlanted();

    public void receive(Plantables plant){
        if(ableToUse){
            this.item = plant;
            ableToUse = false;
        }else{
            System.out.println("This field has already been filled in");
        }
    }

    public static void sellPlants(){
        if(item.getTimeToGrow() >= Player.getRound() - roundPlanted){
            Player.setMoney(qtdItem*item.getSellValue());
        }
    }

    @Override
    public String toString(){
        return String.format("""
                plant: %s
                planted time: %d
                """, item, Player.getRound() - roundPlanted);
    }

    public Plantables getItem() {
        return item;
    }


}
