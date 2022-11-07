/**
 * This class represents the farmer (player)
 */
public class Farmer {
    private String username;
    private double objectcoins;
    private double xp;
    private int level;
    private Rank rank;
    private MyFarm myFarm;
    private boolean isGameOver;

    /**
     * This constructor sets the initial details of the player
     * @param username is the username of the player
     * @param rank is the rank of the player
     * @param myFarm is the farm of the player
     */
    public Farmer(String username, Rank rank, MyFarm myFarm) {
        this.username = username;
        this.objectcoins = 100;
        this.xp = 0;
        this.level = 0;
        this.rank = rank;
        this.myFarm = myFarm;
        this.isGameOver = false;
    }

    /**
     * This method displays the current stats of the player
     */
    public void displayStats() {
        System.out.println("");
        System.out.println("Character Statistics");
        System.out.println("Name: " + this.username);
        System.out.println("Rank: " + this.rank.getRank());
        System.out.println("Level: " + this.getLevel());
        System.out.println("Total XP: " + this.xp);
        System.out.println("Objectcoins : " + this.objectcoins);
    }

    /**
     * This method attempts to register the player to a certain rank
     * @param rank is the rank the player wants to register for
     */
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

    /**
     * This method lets the player use the plow tool on a tile
     * @param xPos is the row position of the tile to be plowed
     * @param yPos is the column position of the tile to be plowed
     */
    public void usePlow(int xPos, int yPos) {
        boolean result = myFarm.getTile(xPos, yPos).setPlowed();
        if(result) {
            this.xp += 0.5;
            System.out.printf("Tile (%d, %d) has been plowed! You gained 0.5 experience.\n", xPos, yPos);
        }
    }

    /**
     * This method lets the player use the watering can tool on a crop
     * @param xPos is the row position of the tile to be watered
     * @param yPos is the column position of the tile to be watered
     */
    public void useWateringCan(int xPos, int yPos) {
        boolean result = myFarm.getTile(xPos, yPos).water();
        if(result) {
            this.xp += 0.5;
            System.out.printf("You have watered Tile (%d, %d)! You gained 0.5 experience.\n", xPos, yPos);
        }
    }

    /**
     * This method attempts to let the player fertilize a crop
     * @param xPos is the row position of the tile to be fertilized
     * @param yPos is the column position of the tile to be fertilized
     */
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

    /**
     * This method attempts to let the player use the pickaxe tool on a tile
     * @param xPos is the row position of the tile where the pickaxe will be used
     * @param yPos is the column position of the tile where the pickaxe will be used
     */
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

    /**
     * This method attempts to let the player use the shovel tool on a tile
     * @param xPos is the row position of the tile where the shovel will be used
     * @param yPos is the column position of the tile where the shovel will be used
     */
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

    /**
     * This method attempts to let the player plant a crop on a tile
     * @param crop is the crop to be planted
     * @param xPos is the row position of the tile where planting will occur
     * @param yPos is the column position of the tile where planting will occur
     */
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

    /**
     * This method harvests the crop from a tile
     * @param xPos is the row position of the tile where harvesting will occur
     * @param yPos is the column position of the tile where harvesting will occur
     */
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

    /**
     * This method gets the username of the player
     * @return the username of the player
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This method gets the current exp count of the player
     * @return the current exp count of the player
     */
    public double getXP() {
        return this.xp;
    }

    /**
     * This method gets the current level of the player
     * @return the current level of the player
     */
    public int getLevel() {
        this.level = (int) this.xp / 100;
        return this.level;
    }

    /**
     * This method gets the current rank of the player
     * @return the current rank of the player
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * This method gets the current number of Objectcoins the player has
     * @return the number of Objectcoins the player has
     */
    public double getObjectcoins() {
        return this.objectcoins;
    }

    /**
     * This method checks for game over conditions
     * @return true if it is game over, false if not
     */
    public boolean checkGameOver() {
        if((myFarm.getWithered() + myFarm.getRocks() == (myFarm.getLandLength() * myFarm.getLandWidth())) ||
           (myFarm.getCrops() == 0) &&
           (this.objectcoins < 5)) {
            this.isGameOver = true; 
        }
        return this.isGameOver;
    }
    
    /**
     * This method sets the game to be over
     */
    public void setGameOver() {
        this.isGameOver = true;
    }
}
