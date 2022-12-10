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
        this.username = username;       // username of the player
        this.objectcoins = 100;         // starting objectcoins of the player
        this.xp = 0;                    // starting XP of the player
        this.level = 0;                 // starting level of the player
        this.rank = rank;               // starting rank of the player
        this.myFarm = myFarm;           // giving the farmer a place to farm
        this.isGameOver = false;        // setting the game to not end at the start of the game
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
     * 
     * @return true if the player was able to register a rank, false otherwise
     */
    public boolean register(Rank rank) {
        boolean b = false;
        
        // this executes if the player reached the minimum level to register for a certain rank
        if(this.getLevel() >= rank.getLevelRequirements()) {
            // this executes if the player has enough objectcoins to register for a certain rank
            if(this.objectcoins >= rank.getRegistrationFee()) {
                this.objectcoins -= rank.getRegistrationFee();
                this.rank = rank;
                System.out.printf("Registration success! You are now a %s.\n", rank.getRank());
                b = true;
            }
            // this executes if the player does not have enough objectcoins to register for a certain rank
            else {
                System.out.printf("You have met the level requirement but you need %f more Objectcoins to cover the registration fee!\n", rank.getRegistrationFee() - this.objectcoins);
            }
        }
        // this executes if the player did not reached the minimum level to register for a certain rank yet
        else {
            System.out.printf("You need to level up %d more times to be eligible for this rank!\n", rank.getLevelRequirements() - this.level);
        }
        return b;
    }

    /**
     * This method lets the player use the plow tool on a tile and rewards the player with XP upon use.
     * 
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if plowing was successful, false otherwise
     */
    public boolean usePlow(int tileNumber) {
        boolean b = false;
        boolean result = myFarm.getTile(tileNumber).setPlowed();

        // this executes if the requirements to plow a tile are met
        if(result) {
            this.xp += 0.5;
            b = true;
        }
        return b;
    }

    /**
     * This method lets the player use the watering can tool on a crop and rewards the player with XP upon use.
     * 
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if watering was successful, false otherwise
     */
    public boolean useWateringCan(int tileNumber) {
        boolean b = false;

        // this executes if the requirements to water a tile are met
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
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if fertilizing was successful, false otherwise
     */
    public boolean useFertilizer(int tileNumber) {
        boolean b = false;

        // this executes if the player does not have enough objectcoins to buy the fertilizer
        if(this.objectcoins < 10) {
            b = false;
        }
        // this executes if the player has enough objectcoins to buy the fertilizer
        else {
            boolean result = myFarm.getTile(tileNumber).fertilize();

            // this executes if the requirements to fertilize a tile are met
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
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if the pickaxe was used successfully, false otherwise
     */
    public boolean usePickaxe(int tileNumber) {
        boolean b = false;

        // this executes if the player does not have enough objectcoins to use the pickaxe
        if(this.objectcoins < 50) {
            b = false;
        }
        // this executes if the player has enough objectcoins to use the pickaxe
        else {
            boolean result = myFarm.getTile(tileNumber).usePickaxe();

            // this executes if the requirements to use a pickaxe are met
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
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if the shovel was used successfully, false otherwise
     */
    public boolean useShovel(int tileNumber) {
        boolean b = false;

        // this executes if the player does not have enough objectcoins to use the shovel
        if(this.objectcoins < 7) {
            b = false;
        }
        // this executes if the player has enough objectcoins to use the shovel
        else {
            boolean result = myFarm.getTile(tileNumber).useShovel();
            // this executes if the requirements to use the shovel are met
            if(result) {
                this.objectcoins -= 7;
                this.xp += 2;
                b = true;
            }
        }
        return b;
    }

    /**
     * This method lets the player plant a crop on a tile if he/she has enough Objectcoins and other certain conditions.
     * 
     * @param crop  is the crop to be planted
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if seed planting was successful, false otherwise
     */
    public boolean plant(Crop crop, int tileNumber) {
        // this executes if the player does not have enough objectcoins to plant the seed
        if(this.objectcoins < crop.getSeedCost()) {
            return false;
        }
        // this executes if the player has enough objectcoins to plant the seed
        else {
            // this executes if the type of seed to be planted is a fruit tree
            if(crop.getType().equals("Fruit tree")) {
                // this executes if the tile is not eligible for tree planting
                if(!myFarm.checkTreeEligibility(tileNumber)) {
                    return false;
                }
            }
            // this executes if the tile is already occupied or the tile has not yet been plowed
            if(myFarm.getTile(tileNumber).isOccupied() || !myFarm.getTile(tileNumber).isPlowed()) {
                return false;
            }
        }

        myFarm.getTile(tileNumber).plantCrop(crop);     // plants the crop
        this.objectcoins -= crop.getSeedCost();         // subtracts the cost 
        return true;
    }

    /**
     * This method harvests the crop from a tile and rewards the player with Objectcoins and XP.
     * 
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return a string that 
     */
    public String harvest(int tileNumber) {
        String display = "";

        // produce takes the number of produce harvested if the harvest was successful
        int produce = myFarm.getTile(tileNumber).harvestCrop(); 

        // this executes if produce is not -1
        if(produce != -1) {
            // calculates the initial harvest price
            int harvestTotal = produce * (myFarm.getTile(tileNumber).getCrop().getBaseHarvestPrice() + this.rank.getBonusEarnings());
            
            // calculates the water bonus
            double waterBonus = harvestTotal * 0.2 * (myFarm.getTile(tileNumber).getTimesWatered() - 1);

            // calculates the fertilizer bonus
            double fertilizerBonus = harvestTotal * 0.5 * myFarm.getTile(tileNumber).getTimesFertilized();

            // calculates the final harvest price
            double finalHarvestPrice = harvestTotal + waterBonus + fertilizerBonus;

            // this executes if the type of crop being harvested is a flower
            if(myFarm.getTile(tileNumber).getCrop().getType().equals("Flower")) {
                finalHarvestPrice *= 1.1;
            }

            // adds the final harvest price to the player's objectcoin amount
            this.objectcoins += finalHarvestPrice;
            // adds the XP gained from harvesting the crop to the player
            this.xp += myFarm.getTile(tileNumber).getCrop().getExpYield();
            display = "Success! Your crop produced " + produce +" products. You earned " + finalHarvestPrice + " Objectcoins and gained " + myFarm.getTile(tileNumber).getCrop().getExpYield() + " experience.";
            // clears the crop
            myFarm.getTile(tileNumber).clearCrop();
        }
        // this executes if produce is -1
        else {
            // this executes if there is no crop in the first place
            if(myFarm.getTile(tileNumber).getCrop() == null) {
                display = "You cannot harvest a non-existent crop!";
            }
            // this executes if there is a withered crop
            else if(myFarm.getTile(tileNumber).getHasWitheredCrop()) {
                display = "You cannot harvest a withered crop!";
            }
            // this executes if the crop has not reached its harvest date yet
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