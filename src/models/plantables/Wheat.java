package models.plantables;

public class Wheat extends Plantables{

    public Wheat(int buy, int sell, int time, int harvest){
        super(buy, sell, time, harvest);
    }

    @Override
    public String toString() {
        return "Wheat";
    }
}
