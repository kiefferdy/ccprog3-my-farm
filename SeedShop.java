import java.util.Scanner;

public class SeedShop {
    private Seeds seeds;
    private Farmer farmer;

    public SeedShop() {
        this.seeds = new Seeds();
    }

    public void displaySeedShop() {
        System.out.println("SEED SHOP\n");
        System.out.println("A. ROOT CROPS");
        System.out.println("    1. Turnip: " + this.seeds.getRootCrops().getTurnipBuyPrice() + " Object Coins");
        System.out.println("    2. Carrot: " + this.seeds.getRootCrops().getCarrotBuyPrice() + " Object Coins");
        System.out.println("    3. Potato: " + this.seeds.getRootCrops().getPotatoBuyPrice() + " Object Coins");
        System.out.println("B. FLOWERS");
        System.out.println("    4. Turnips: " + this.seeds.getFlowers().getTurnipsBuyPrice() + " Object Coins");
        System.out.println("    5. Rose: " + this.seeds.getFlowers().getRoseBuyPrice() + " Object Coins");
        System.out.println("    6. Sunflower: " + this.seeds.getFlowers().getSunflowerBuyPrice() + " Object Coins");
        System.out.println("C. FRUIT TREES");
        System.out.println("    7. Mango: " + this.seeds.getFruitTrees().getMangoBuyPrice() + " Object Coins");
        System.out.println("    8. Apple: " + this.seeds.getFruitTrees().getAppleBuyPrice() + " Object Coins");
    }

    public void buySeeds() {
        int amount, choice;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("Would you like to buy seeds? (Enter the number of your choice; enter 0 if you will not buy seeds)");
            choice = sc.nextInt();
            if(choice > 0 && choice < 9) {
                System.out.println("Enter the amount of seeds that you want to buy.");
                amount = sc.nextInt();

                switch(choice) {
                    case 1:
                        buyTurnipCrop(amount);
                        break;
                    case 2:
                        buyCarrot(amount);
                        break;
                    case 3:
                        buyPotato(amount);
                        break;
                    case 4:
                        buyTurnipFlower(amount);
                        break;
                    case 5:
                        buyRose(amount);
                        break;
                    case 6:
                        buySunflower(amount);
                        break;
                    case 7:
                        buyMango(amount);
                        break;
                    case 8:
                        buyApple(amount);
                        break;
                }
            }
            else if(choice == 0) {
                System.out.println("Returning to farm...");
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }while(choice != 0);

        sc.close();
    }

    public boolean buyTurnipCrop(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getRootCrops().getTurnipBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getRootCrops().getTurnipBuyPrice());
                System.out.println("Bought " + amount + " Turnip Crop seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buyCarrot(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getRootCrops().getCarrotBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getRootCrops().getCarrotBuyPrice());
                System.out.println("Bought " + amount + " Carrot seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buyPotato(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getRootCrops().getPotatoBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getRootCrops().getPotatoBuyPrice());
                System.out.println("Bought " + amount + " Potato seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buyTurnipFlower(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getFlowers().getTurnipsBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getFlowers().getTurnipsBuyPrice());
                System.out.println("Bought " + amount + " Turnip Flower seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buyRose(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getFlowers().getRoseBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getFlowers().getRoseBuyPrice());
                System.out.println("Bought " + amount + " Rose seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buySunflower(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getFlowers().getSunflowerBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getFlowers().getSunflowerBuyPrice());
                System.out.println("Bought " + amount + " Sunflower seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buyMango(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getFruitTrees().getMangoBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(amount * this.seeds.getFruitTrees().getMangoBuyPrice());
                System.out.println("Bought " + amount + " Mango seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }

    public boolean buyApple(int amount) {
        boolean result = false;
        if(amount > 0) {
            if(amount * this.seeds.getFruitTrees().getAppleBuyPrice() <= farmer.getObjectCoins()) {
                farmer.deductObjectCoins(- amount * this.seeds.getFruitTrees().getAppleBuyPrice());

                System.out.println("Bought " + amount + " Apple seeds!");
                System.out.println("You have " + farmer.getObjectCoins() + " Object Coins left.");
                result = true;
            }
        }

        if(result == false) {
            System.out.println("An error occured. Please try again.");
        }
        return result;
    }
}
