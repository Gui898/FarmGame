package models.plantables;

public abstract sealed class Plantables permits Wheat, Potato {

    private int buyValue;
    private int sellValue;
    private final int timeToGrow;
    private final int harvestPrice;
    //private static int inflation = 0;
    private final int qtd;

    public Plantables(int buy, int sell, int time, int harvest, int qtdItem){
        buyValue = buy;
        sellValue = sell;
        timeToGrow = time;
        harvestPrice = harvest;
        qtd = qtdItem;
    }

//    public static void verifyInflation(){
//        if(inflation > 0){
//            sellValue = sellValue - (sellValue*inflation/100);
//        }
//    }

    public int getBuyValue() {
        return buyValue;
    }

    public void setBuyValue(int buyValue) {
        this.buyValue = buyValue;
    }

    public int getSellValue() {
        return sellValue;
    }

    public void setSellValue(int sellValue) {
        this.sellValue = sellValue;
    }

    public int getTimeToGrow() {
        return timeToGrow;
    }

    public int getQtd() {
        return qtd;
    }

//    public static int getInflation() {
//        return inflation;
//    }
//
//    public void setInflation(int inflation) {
//        Plantables.inflation = inflation;
//    }

    public int getHarvestPrice() {
        return harvestPrice;
    }
}
