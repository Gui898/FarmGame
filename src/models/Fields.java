package models;

import models.plantables.Plantables;

public class Fields {

    private boolean ableToUse = true;
    private Plantables item;
    private int roundPlanted = -1;

    public void receive(Plantables plant){
        if(ableToUse){
            item = plant;
            roundPlanted = Player.getRound();
            ableToUse = false;
        }else{
            System.out.println("This field has already been filled in");
        }
    }

    public void sellPlants(){
        if(item.getTimeToGrow() >= Player.getRound() - roundPlanted){
            Player.setMoney(item.getQtd()*item.getSellValue());
        }
    }

    @Override
    public String toString(){
        if (roundPlanted == -1 || item == null) {
            return "No plant in this field.\n";
        }else{
        return String.format("""
            Plant: %s
            Planted time: %d
            """, item, Player.getRound() - roundPlanted);
        }
    }

    public Plantables getItem() {
        return item;
    }

    public boolean getAbleToUse(){
        return ableToUse;
    }

    public void setAbleToUse(boolean ans){
        ableToUse = ans;
    }

}
