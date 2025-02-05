package models;

import models.plantables.Plantables;

public class Fields {

    private static boolean ableToUse = true;
    private static Plantables item;
    private static int qtdItem = item.getQtd();

    public void receive(Plantables plant){
        if(ableToUse){
            this.item = plant;
        }else{
            System.out.println("This field has already been filled in");
        }
    }

    public Plantables getItem() {
        return item;
    }


}
