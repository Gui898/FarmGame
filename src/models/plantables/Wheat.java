package models.plantables;

public class Wheat extends Plantables{

    public Wheat(){
        super(2000, 50, 3, 1000, 200);
    }

    @Override
    public String toString() {
        return "Wheat";
    }
}
