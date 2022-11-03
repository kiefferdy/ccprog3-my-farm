public class Farmer {
    private String username;
    private double objectcoins;
    private double xp;
    private int level;
    private Rank rank;
    private MyFarm myFarm;

    public Farmer(String username, Rank rank, MyFarm myFarm) {
        this.username = username;
        this.objectcoins = 100;
        this.xp = 0;
        this.level = 0;
        this.rank = rank;
        this.myFarm = myFarm;
    }

    public void displayStats() {
        System.out.println("");
        System.out.println("Character Statistics");
        System.out.println("Name: " + this.username);
        System.out.println("Rank: " + this.rank);
        System.out.println("Level: " + this.level);
        System.out.println("Total XP: " + this.xp);
        System.out.println("Objectcoins : " + this.objectcoins);
    }

    public void register(Rank rank) {
        if(this.level >= rank.getLevelRequirements()) {
            if(this.objectcoins >= rank.getRegistrationFee()) {
                this.rank = rank;
                System.out.printf("Registration success! You are now a %s.\n", rank.getRank());
            }
            else {
                System.out.printf("You have met the level requirement but you need %d more Objectcoins to cover the registration fee!\n", rank.getRegistrationFee() - this.objectcoins);
            }
        }
        else {
            System.out.printf("You need to level up %d more times to be eligible for this rank!\n", rank.getLevelRequirements() - this.level);
        }
    }

    public void usePickaxe(int xPos, int yPos) {
        if(this.objectcoins < 50) {
            System.out.printf("Insufficient funds! You need %d more Objectcoins to use the pickaxe.\n", 50 - this.objectcoins);
        }
        else {
            this.objectcoins -= 50;
            this.xp += 15;
            myFarm.getTile(xPos, yPos).usePickaxe();
            System.out.println("Success! You spent 50 Objectcoins and gained 15 experience.");
        }
    }

    public void useShovel(int xPos, int yPos) {
        if(this.objectcoins < 7) {
            System.out.printf("Insufficient funds! You need %d more Objectcoins to use the shovel.\n", 7 - this.objectcoins);
        }
        else {
            this.objectcoins -= 7;
            this.xp += 2;
            myFarm.getTile(xPos, yPos).useShovel();
            System.out.println("Success! You spent 7 Objectcoins and gained 2 experience.");
        }
    }

    public void plant(Crop crop, int xPos, int yPos) {
        if(this.objectcoins < crop.getSeedCost()) {
            System.out.printf("Insufficient funds! You need %d more Objectcoins to plant this crop.\n", crop.getSeedCost() - this.objectcoins);
        }
        else {
            if(myFarm.getTile(xPos, yPos).plantCrop(crop)) {
                this.objectcoins -= crop.getSeedCost();
                System.out.printf("You have successfully planted %s on Tile (%d, %d)!\n", crop.getName(), xPos, yPos);
            }
        }
    }

    public void harvest(int xPos, int yPos) {
        int produce = myFarm.getTile(xPos, yPos).harvest();
        if(produce != -1) {
            int harvestTotal = produce * (myFarm.getTile(xPos, yPos).getCrop().getBaseHarvestPrice() + this.rank.getBonusEarnings());
            double waterBonus = harvestTotal * 0.2 * (myFarm.getTile(xPos, yPos).getTimesWatered() - 1);
            double fertilizerBonus = harvestTotal * 0.5 * myFarm.getTile(xPos, yPos).getTimesFertilized();
            double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

            if(myFarm.getTile(xPos, yPos).getCrop().getType().equals("Flower")) {
                finalHarvestPrice *= 1.1;
            }

            this.objectcoins += finalHarvestPrice;
            this.xp += myFarm.getTile(xPos, yPos).getCrop().getExpYield();
            System.out.printf("Success! Your crop produced %d products. You earned %lf Objectcoins and gained %lf experience.\n", produce, finalHarvestPrice, myFarm.getTile(xPos, yPos).getCrop().getExpYield());
        }
    }

    public String getUsername() {
        return this.username;
    }

    public double getXP() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void addXP(int amount) {
        this.xp += amount;
    }

    public double getObjectcoins() {
        return this.objectcoins;
    }

    public void addObjectCoins(int amount) {
        this.objectcoins += amount;
    }

    public void deductObjectCoins(int amount) {
        this.objectcoins -= amount;
    }
}
