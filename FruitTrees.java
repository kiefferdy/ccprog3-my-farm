public class FruitTrees {
    private int mango;
    private int apple;
    private int mangoSellPrice = 8;
    private int appleSellPrice = 5;
    private int mangoBuyPrice = 100;
    private int appleBuyPrice = 200;

    public FruitTrees() {
        this.mango = 0;
        this.apple = 0;
    }

    public int getMango() {
        return this.mango;
    }

    public void setMango(int amount) {
        this.mango += amount;
    }

    public int getApple() {
        return this.apple;
    }

    public void setApple(int amount) {
        this.apple += amount;
    }

    public int getMangoSellPrice() {
        return this.mangoSellPrice;
    }

    public int getAppleSellPrice() {
        return this.appleSellPrice;
    }

    public int getMangoBuyPrice() {
        return this.mangoBuyPrice;
    }

    public int getAppleBuyPrice() {
        return this.appleBuyPrice;
    }
}
