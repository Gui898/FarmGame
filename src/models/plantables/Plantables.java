package models.plantables;

public abstract class Plantables {

    private static int buyValue;
    private static int sellValue;
    private static int timeToGrow;
    private static int harvestPrice;
    private static int inflation = 0;
    private static int qtd;
    private static int timePlanted;

    public Plantables(int buy, int sell, int time, int harvest){
        buyValue = buy;
        sellValue = sell;
        timeToGrow = time;
        harvestPrice = harvest;
    }

//    public static void verifyInflation(){
//        if(inflation > 0){
//            sellValue = sellValue - (sellValue*inflation/100);
//        }
//    }

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

    public static int getInflation() {
        return inflation;
    }

    public static void setInflation(int inflation) {
        Plantables.inflation = inflation;
    }

    public static int getTimePlanted() {
        return timePlanted;
    }

    public static void setTimePlanted(int timePlanted) {
        Plantables.timePlanted = timePlanted;
    }
}
