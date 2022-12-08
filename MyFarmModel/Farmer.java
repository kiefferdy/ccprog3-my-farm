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
     * 
     * @return string of text that displays the statistics of the player
     */
    public String displayStats() {
        return  "Character Statistics" + 
                "\nName: " + this.username +
                "\nRank: " + this.rank.getRank() +
                "\nLevel: " + this.getLevel() + 
                "\nTotal XP: " + this.xp +
                "\nObjectcoins : " + this.objectcoins + "\n\n";
    }

    /**
     * This method registers the player to a certain rank if the conditions are met.
     * 
     * @param rank  is the rank the player wants to register for
     */
    public boolean register(Rank rank) {
        boolean b = false;
        
        if(this.getLevel() >= rank.getLevelRequirements()) {
            if(this.objectcoins >= rank.getRegistrationFee()) {
                this.objectcoins -= rank.getRegistrationFee();
                this.rank = rank;
                System.out.printf("Registration success! You are now a %s.\n", rank.getRank());
                b = true;
            }
            else {
                System.out.printf("You have met the level requirement but you need %f more Objectcoins to cover the registration fee!\n", rank.getRegistrationFee() - this.objectcoins);
            }
        }
        else {
            System.out.printf("You need to level up %d more times to be eligible for this rank!\n", rank.getLevelRequirements() - this.level);
        }
        return b;
    }

    /**
     * This method lets the player use the plow tool on a tile and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile to be plowed
     * @param yPos  is the column position of the tile to be plowed
     */
    public boolean usePlow(int tileNumber) {
        boolean b = false;
        boolean result = myFarm.getTile(tileNumber).setPlowed();
        if(result) {
            this.xp += 0.5;
            b = true;
        }
        return b;
    }

    /**
     * This method lets the player use the watering can tool on a crop and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile to be watered
     * @param yPos  is the column position of the tile to be watered
     */
    public boolean useWateringCan(int tileNumber) {
        boolean b = false;
        boolean result = myFarm.getTile(tileNumber).water();
        if(result) {
            this.xp += 0.5;
            b = true;
        }
        return b;
    }

    /**
     * This method lets the player fertilize a crop if he/she has enough Objectcoins and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile to be fertilized
     * @param yPos  is the column position of the tile to be fertilized
     */
    public boolean useFertilizer(int tileNumber) {
        boolean b = false;
        if(this.objectcoins < 10) {
            b = false;
        }
        else {
            boolean result = myFarm.getTile(tileNumber).fertilize();
            if(result) {
                this.objectcoins -= 10;
                this.xp += 4;
                b = true;
            }
        }
        return b;
    }

    /**
     * This method lets the player use the pickaxe tool on a tile if he/she has enough Objectcoins and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile where the pickaxe will be used
     * @param yPos  is the column position of the tile where the pickaxe will be used
     */
    public boolean usePickaxe(int tileNumber) {
        boolean b = false;
        if(this.objectcoins < 50) {
            b = false;
        }
        else {
            boolean result = myFarm.getTile(tileNumber).usePickaxe();
            if(result) {
                this.objectcoins -= 50;
                this.xp += 15;
                b = true;
            }
        }
        return b;
    }

    /**
     * This method lets the player use the shovel tool on a tile if he/she has enough Objectcoins and rewards the player with XP upon use.
     * 
     * @param xPos  is the row position of the tile where the shovel will be used
     * @param yPos  is the column position of the tile where the shovel will be used
     */
    public boolean useShovel(int tileNumber) {
        boolean b = false;
        if(this.objectcoins < 7) {
            b = false;
        }
        else {
            boolean result = myFarm.getTile(tileNumber).useShovel();
            if(result) {
                this.objectcoins -= 7;
                this.xp += 2;
                b = true;
            }
        }
        return b;
    }

    /**
     * This method lets the player plant a crop on a tile if he/she has enough Objectcoins.
     * 
     * @param crop  is the crop to be planted
     * @param xPos  is the row position of the tile where planting will occur
     * @param yPos  is the column position of the tile where planting will occur
     */
    public boolean plant(Crop crop, int tileNumber) {
        boolean b = false;
        if(this.objectcoins < crop.getSeedCost()) {
            b = false;
        }
        else {
            boolean result = myFarm.getTile(tileNumber).plantCrop(crop);
            if(result) {
                this.objectcoins -= crop.getSeedCost();
                b = true;
            }
        }
        return b;
    }

    /**
     * This method harvests the crop from a tile and rewards the player with Objectcoins and XP.
     * 
     * @param xPos  is the row position of the tile where harvesting will occur
     * @param yPos  is the column position of the tile where harvesting will occur
     */
    public String harvest(int tileNumber) {
        String display = "";
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
            display = "Success! Your crop produced " + produce +" products. You earned " + finalHarvestPrice + " Objectcoins and gained " + myFarm.getTile(tileNumber).getCrop().getExpYield() + " experience.";
            myFarm.getTile(tileNumber).clearCrop();
        }
        else {
            if(myFarm.getTile(tileNumber).getCrop() == null) {
                display = "You cannot harvest a non-existent crop!";
            }
            else if(myFarm.getTile(tileNumber).getHasWitheredCrop()) {
                display = "You cannot harvest a withered crop!";
            }
            else if(myFarm.getTile(tileNumber).getDaysToHarvest() > 0) {
                display = "You need to wait " + myFarm.getTile(tileNumber).getDaysToHarvest() + " more day(s) to harvest this crop.";
            }
        }
        return display;
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