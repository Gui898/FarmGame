package models;

import models.plantables.Plantables;
import models.plantables.Potato;
import models.plantables.Wheat;

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
            System.out.println("This field has already been filled in!");
        }
    }

    public void remove(){
        if(item.getClass() == Wheat.class){
            Player.setQtdWheat(item.getQtd());
        }else if(item.getClass() == Potato.class){
            Player.setQtdPotato(item.getQtd());
        }
        item = null;
        ableToUse = true;
    }

    public boolean verifyGrowth(){
        if(item != null){
            return Player.getRound() - roundPlanted >= item.getTimeToGrow();
        }
        return false;
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

    public boolean getAbleToUse(){
        return ableToUse;
    }

    public Object getItem(){
        return item.getClass();
    }


}
