package MyFarmModel;

/**
 * This class represents the farmer/player and is responsible for storing his/her statistics.
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
     * This constructor sets the initial details of the player.
     * 
     * @param username  is the username of the player
     * @param rank      is the rank of the player
     * @param myFarm    is the farm of the player
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
     * This method displays the current statistics of the player.
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
     * This method registers the player to a certain rank if the conditions are met.
     * 
     * @param rank  is the rank the player wants to register for
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
     * This method lets the player use the plow tool on a tile and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile to be plowed
     * @param yPos  is the column position of the tile to be plowed
     */
    public void usePlow(int tileNumber) {
        boolean result = myFarm.getTile(tileNumber).setPlowed();
        if(result) {
            this.xp += 0.5;
            System.out.printf("Tile %d has been plowed! You gained 0.5 experience.\n", tileNumber);
        }
    }

    /**
     * This method lets the player use the watering can tool on a crop and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile to be watered
     * @param yPos  is the column position of the tile to be watered
     */
    public void useWateringCan(int tileNumber) {
        boolean result = myFarm.getTile(tileNumber).water();
        if(result) {
            this.xp += 0.5;
            System.out.printf("You have watered Tile %d! You gained 0.5 experience.\n", tileNumber);
        }
    }

    /**
     * This method lets the player fertilize a crop if he/she has enough Objectcoins and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile to be fertilized
     * @param yPos  is the column position of the tile to be fertilized
     */
    public void useFertilizer(int tileNumber) {
        if(this.objectcoins < 10) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to fertilize your crop.\n", 10 - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(tileNumber).fertilize();
            if(result) {
                this.objectcoins -= 10;
                this.xp += 4;
                System.out.printf("You have fertilized Tile %d! You gained 4 experience.\n", tileNumber);
            }
        }
    }

    /**
     * This method lets the player use the pickaxe tool on a tile if he/she has enough Objectcoins and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile where the pickaxe will be used
     * @param yPos  is the column position of the tile where the pickaxe will be used
     */
    public void usePickaxe(int tileNumber) {
        if(this.objectcoins < 50) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to use the pickaxe.\n", 50 - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(tileNumber).usePickaxe();
            if(result) {
                this.objectcoins -= 50;
                this.xp += 15;
                System.out.println("Success! You spent 50 Objectcoins and gained 15 experience.");
            }
        }
    }

    /**
     * This method lets the player use the shovel tool on a tile if he/she has enough Objectcoins and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile where the shovel will be used
     * @param yPos  is the column position of the tile where the shovel will be used
     */
    public void useShovel(int tileNumber) {
        if(this.objectcoins < 7) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to use the shovel.\n", 7 - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(tileNumber).useShovel();
            if(result) {
                this.objectcoins -= 7;
                this.xp += 2;
                System.out.println("Success! You spent 7 Objectcoins and gained 2 experience.");
            }
        }
    }

    /**
     * This method lets the player plant a crop on a tile if he/she has enough Objectcoins.
     * 
     * @param crop  is the crop to be planted
     * @param xPos  is the row position of the tile where planting will occur
     * @param yPos  is the column position of the tile where planting will occur
     */
    public void plant(Crop crop, int tileNumber) {
        if(this.objectcoins < crop.getSeedCost()) {
            System.out.printf("Insufficient funds! You need %f more Objectcoins to plant this crop.\n", crop.getSeedCost() - this.objectcoins);
        }
        else {
            boolean result = myFarm.getTile(tileNumber).plantCrop(crop);
            if(result) {
                this.objectcoins -= crop.getSeedCost();
                System.out.printf("You have successfully planted %s on Tile %d!\n", crop.getName(), tileNumber);
            }
        }
    }

    /**
     * This method harvests the crop from a tile and rewards the player with Objectcoins and XP.
     * 
     * @param xPos  is the row position of the tile where harvesting will occur
     * @param yPos  is the column position of the tile where harvesting will occur
     */
    public void harvest(int tileNumber) {
        int produce = myFarm.getTile(tileNumber).harvestCrop();
        if(produce != -1) {
            int harvestTotal = produce * (myFarm.getTile(tileNumber).getCrop().getBaseHarvestPrice() + this.rank.getBonusEarnings());
            double waterBonus = harvestTotal * 0.2 * (myFarm.getTile(tileNumber).getTimesWatered() - 1);
            double fertilizerBonus = harvestTotal * 0.5 * myFarm.getTile(tileNumber).getTimesFertilized();
            double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

            if(myFarm.getTile(tileNumber).getCrop().getType().equals("Flower")) {
                finalHarvestPrice *= 1.1;
            }

            this.objectcoins += finalHarvestPrice;
            this.xp += myFarm.getTile(tileNumber).getCrop().getExpYield();
            System.out.printf("Success! Your crop produced %d products. You earned %f Objectcoins and gained %f experience.\n", produce, finalHarvestPrice, myFarm.getTile(tileNumber).getCrop().getExpYield());
            myFarm.getTile(tileNumber).clearCrop();
        }
    }

    /**
     * This method gets the username of the player.
     * 
     * @return  the username of the player
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This method gets the total experience the player has accumulated.
     * 
     * @return  the current exp count of the player
     */
    public double getXP() {
        return this.xp;
    }

    /**
     * This method gets the current level of the player.
     * 
     * @return  the current level of the player
     */
    public int getLevel() {
        this.level = (int) this.xp / 100;
        return this.level;
    }

    /**
     * This method gets the current rank of the player.
     * 
     * @return  the current rank of the player
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * This method gets the current number of Objectcoins the player has.
     * 
     * @return  the number of Objectcoins the player has
     */
    public double getObjectcoins() {
        return this.objectcoins;
    }

    /**
     * This method checks whether the game is over or not.
     * 
     * @return  true if it is game over, false if not
     */
    public boolean checkGameOver() {
        if((myFarm.getWithered() + myFarm.getRocks() == (myFarm.getTileTotal())) ||
           (myFarm.getCrops() == 0) &&
           (this.objectcoins < 5)) {
            this.isGameOver = true; 
        }
        return this.isGameOver;
    }
    
    /**
     * This method ends the game.
     */
    public void setGameOver() {
        this.isGameOver = true;
    }
}
