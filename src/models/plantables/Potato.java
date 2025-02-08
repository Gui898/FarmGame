package models.plantables;

public class Potato extends Plantables {

    public Potato(int buy, int sell, int time, int harvest) {
        super(buy, sell, time, harvest);
    }

    @Override
    public String toString() {
        return "Potato";
    }
}
