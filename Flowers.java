public class Flowers { 
    private int turnips;
    private int rose;
    private int sunflower;
    private int turnipsSellPrice = 5;
    private int roseSellPrice = 9;
    private int sunflowerSellPrice = 19;
    private int turnipsBuyPrice = 5;
    private int roseBuyPrice = 10;
    private int sunflowerBuyPrice = 20;

    public Flowers() {
        this.turnips = 0;
        this.rose = 0;
        this.sunflower = 0;
    }

    public int getTurnips() {
        return this.turnips;
    }

    public void setTurnips(int amount) {
        this.turnips += amount;
    }

    public int getRose() {
        return this.rose;
    }

    public void setRose(int amount) {
        this.rose += amount;
    }

    public int getSunflower() {
        return this.sunflower;
    }

    public void setSunflower(int amount) {
        this.sunflower += amount;
    }

    public int getTurnipsSellPrice() {
        return this.turnipsSellPrice;
    }

    public int getSunflowerSellPrice() {
        return this.sunflowerSellPrice;
    }

    public int getRoseSellPrice() {
        return this.roseSellPrice;
    }

    public int getTurnipsBuyPrice() {
        return this.turnipsBuyPrice;
    }

    public int getSunflowerBuyPrice() {
        return this.sunflowerBuyPrice;
    }

    public int getRoseBuyPrice() {
        return this.roseBuyPrice;
    }
}
