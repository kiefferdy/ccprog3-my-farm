public class Farmer {
    private String username;
    private double objectcoins;
    private double xp;
    private int level;
    private Rank rank;
    private MyFarm myFarm;
    private boolean isGameOver;

    public Farmer(String username, Rank rank, MyFarm myFarm) {
        this.username = username;
        this.objectcoins = 100;
        this.xp = 0;
        this.level = 0;
        this.rank = rank;
        this.myFarm = myFarm;
        this.isGameOver = false;
    }

    public void displayStats() {
        System.out.println("");
        System.out.println("Character Statistics");
        System.out.println("Name: " + this.username);
        System.out.println("Rank: " + this.rank.getRank());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Total XP: " + this.xp);
        System.out.println("Objectcoins : " + this.objectcoins);
    }

    public void register(Rank rank) {
        if(this.rank == rank) {
            System.out.println("The rank you are attempting to register for is already your rank!");
        }
        else {
            if(this.getLevel() >= rank.getLevelRequirements()) {
                if(this.objectcoins >= rank.getRegistrationFee()) {
                    this.rank = rank;
                    System.out.printf("Registration success! You are now a %s.\n", rank.getRank());
                }
                else {
                    System.out.printf("You have met the level requirement but you need %f more Objectcoins to cover the registration fee!\n", rank.getRegistrationFee() - this.objectcoins);
                }
            }
            else {
                System.out.printf("You need to level up %d more times to be eligible for this rank!\n", rank.getLevelRequirements() - this.level);
            }
        }
    }

    public void usePlow(int xPos, int yPos) {
        boolean result = myFarm.getTile(xPos, yPos).setPlowed();
        if(result) {
            this.xp += 0.5;
            System.out.printf("Tile (%d, %d) has been plowed! You gained 0.5 experience.\n", xPos, yPos);
        }
    }

    public void useWateringCan(int xPos, int yPos) {
        boolean result = myFarm.getTile(xPos, yPos).water();
        if(result) {
            this.xp += 0.5;
            System.out.printf("You have watered Tile (%d, %d)! You gained 0.5 experience.\n", xPos, yPos);
        }
    }

    public void useFertilizer(int xPos, int yPos) {
        if(this.objectcoins < 10) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to fertilize your crop.\n", 10 - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(xPos, yPos).fertilize();
            if(result) {
                this.objectcoins -= 10;
                this.xp += 4;
                System.out.printf("You have fertilized Tile (%d, %d)! You gained 4 experience.\n", xPos, yPos);
            }
        }
    }

    public void usePickaxe(int xPos, int yPos) {
        if(this.objectcoins < 50) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to use the pickaxe.\n", 50 - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(xPos, yPos).usePickaxe();
            if(result) {
                this.objectcoins -= 50;
                this.xp += 15;
                System.out.println("Success! You spent 50 Objectcoins and gained 15 experience.");
            }
        }
    }

    public void useShovel(int xPos, int yPos) {
        if(this.objectcoins < 7) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to use the shovel.\n", 7 - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(xPos, yPos).useShovel();
            if(result) {
                this.objectcoins -= 7;
                this.xp += 2;
                System.out.println("Success! You spent 7 Objectcoins and gained 2 experience.");
            }
        }
    }

    public void plant(Crop crop, int xPos, int yPos) {
        if(this.objectcoins < crop.getSeedCost()) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to plant this crop.\n", crop.getSeedCost() - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(xPos, yPos).plantCrop(crop);
            if(result) {
                this.objectcoins -= crop.getSeedCost();
                System.out.printf("You have successfully planted %s on Tile (%d, %d)!\n", crop.getName(), xPos, yPos);
            }
        }
    }

    public void harvest(int xPos, int yPos) {
        int produce = myFarm.getTile(xPos, yPos).harvestCrop();
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
            System.out.printf("Success! Your crop produced %d products. You earned %f Objectcoins and gained %f experience.\n", produce, finalHarvestPrice, myFarm.getTile(xPos, yPos).getCrop().getExpYield());
            myFarm.getTile(xPos, yPos).clearCrop();
        }
    }

    public String getUsername() {
        return this.username;
    }

    public double getXP() {
        return this.xp;
    }

    public int getLevel() {
        this.level = (int) this.xp / 100;
        return this.level;
    }

    public Rank getRank() {
        return this.rank;
    }

    public double getObjectcoins() {
        return this.objectcoins;
    }

    public boolean checkGameOver() {
        if((myFarm.getWithered() + myFarm.getRocks() == (myFarm.getLandLength() * myFarm.getLandWidth())) ||
           (myFarm.getCrops() == 0) &&
           (this.objectcoins < 5)) {
            this.isGameOver = true; 
        }
        return this.isGameOver;
    }
    
    public void setGameOver() {
        this.isGameOver = true;
    }
}
