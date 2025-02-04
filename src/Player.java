import models.Fields;
import java.util.ArrayList;

public class Player {

    public Player(int money){
        this.money = money;
    }

    private int money;
    private static int totalFields = 15;
    private static ArrayList<Fields> myFields = new ArrayList<>();

    public static void startFields(){
        for (int i = 0; i < 15; i++) {
            myFields.add(new Fields());
        }
    }

    public static int getTotalFields() {
        return totalFields;
    }

    public static void setTotalFields(int totalFields) {
        Player.totalFields = totalFields;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
