public class RootCrops {
    private int turnip;
    private int carrot;
    private int potato;
    private int turnipSellPrice = 6;
    private int carrotSellPrice = 9;
    private int potatoSellPrice = 3;
    private int turnipBuyPrice = 5;
    private int carrotBuyPrice = 10;
    private int potatoBuyPrice = 20;

    public RootCrops() {
        this.turnip = 0;
        this.carrot = 0;
        this.potato = 0;
    }

    public int getTurnip() {
        return this.turnip;
    }

    public void setTurnip(int amount) {
        this.turnip += amount;
    }

    public int getCarrot() {
        return this.carrot;
    }

    public void setCarrot(int amount) {
        this.carrot += amount;
    }

    public int getPotato() {
        return this.potato;
    }

    public void setPotato(int amount) {
        this.potato += amount;
    }

    public int getTurnipSellPrice() {
        return this.turnipSellPrice;
    }

    public int getCarrotSellPrice() {
        return this.carrotSellPrice;
    }

    public int getPotatoSellPrice() {
        return this.potatoSellPrice;
    }

    public int getTurnipBuyPrice() {
        return this.turnipBuyPrice;
    }

    public int getCarrotBuyPrice() {
        return this.carrotBuyPrice;
    }

    public int getPotatoBuyPrice() {
        return this.potatoBuyPrice;
    }
}
