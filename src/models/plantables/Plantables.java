package models.plantables;

public abstract class Plantables {

    private static int buyValue;
    private static int sellValue;
    private static int timeToGrow;
    private static int harvestPrice;
    private static int qtd;

    public Plantables(int buy, int sell, int time, int harvest){
        this.buyValue = buy;
        this.sellValue = sell;
        this.timeToGrow = time;
        this.harvestPrice = harvest;
    }

    public static int getBuyValue() {
        return buyValue;
    }

    public static void setBuyValue(int buyValue) {
        Plantables.buyValue = buyValue;
    }

    public static int getSellValue() {
        return sellValue;
    }

    public static void setSellValue(int sellValue) {
        Plantables.sellValue = sellValue;
    }

    public static int getTimeToGrow() {
        return timeToGrow;
    }

    public static int getQtd() {
        return qtd;
    }

    public static void setQtd(int qtd) {
        Plantables.qtd = qtd;
    }
}
