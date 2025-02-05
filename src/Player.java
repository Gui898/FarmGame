import models.Fields;
import java.util.ArrayList;

public class Player {

    private String name;
    private int money;
    private int totalFields = 15;
    private static ArrayList<Fields> myFields = new ArrayList<>();

    public Player(int money, String name){
        this.money = money;
        this.name = name;
    }

    public static void startFields(){
        for (int i = 0; i < 15; i++) {
            myFields.add(new Fields());
        }
    }

    public int getTotalFields() {
        return totalFields;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
}
