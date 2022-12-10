package MyFarmModel;

import java.util.Random;
import java.util.ArrayList;

/**
 * This class represents the entire farm a player owns.
 */
public class MyFarm {
    private int tileTotal;
    private Tile[] land;
    private int day;
    
    /**
     * This constructor declares the size of the player's farm and sets the day to 1.
     */
    public MyFarm() {
        this.tileTotal = 50;                // number of tiles
        this.land = new Tile[tileTotal];    // setting array of tiles in land
        this.day = 1;                       // starting day
    }
    
    /**
     * This method displays an overview of the farm.
     * 
     * @return a string that displays the overview of the farm. 
     */
    public String displayOverview() {   
        return  "Current Day: " + this.day +
                "\nUncleared Rocks: " + this.getRocks() +
                "\nPlanted Crops: " + this.getCrops() +
                "\nHarvestable Crops: " + this.getHarvestable() +
                "\nWithered Crops: " + this.getWithered();
    }

    /**
    * This method instantiates each tile the farm has.
    */
    public void createTiles() {
        for(int i = 0; i < this.tileTotal; i++) {
            land[i] = new Tile(i);
        }
    }

    /**
     * This method gets a specific tile in the farm.
     * 
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return  the tile the player chooses
     */
    public Tile getTile(int tileNumber) {
        return land[tileNumber];
    }

    /**
     * This method gets the total number of tiles in the farm.
     * 
     * @return  the number of tiles in the farm
     */
    public int getTileTotal() {
        return this.tileTotal;
    }
    
    /**
     * This method gets the number of uncleared rocks currently present on the whole farm.
     * 
     * @return  the number of rocks present on the farm 
     */
    public int getRocks() {
        int count = 0;
        for(int i = 0; i < this.tileTotal; i++) {
            if(land[i].hasRock()) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method is responsible for setting the rocks on the farm according to the rocksConfig.txt config file.
     * 
     * @param randomizeScatter represents whether the rock scatter should be done automatically
     * @param minRocks represents the minimum amount of rocks to be scattered automatically
     * @param maxRocks represents the maximum amount of rocks to be scattered automatically
     * @param arrConfig contains the array with the data indicating which tiles should contain a rock
     */
    public void setRocks(boolean randomizeScatter, int minRocks, int maxRocks, int[] arrConfig) {
        Random rand = new Random();
        int nRocks = rand.nextInt(maxRocks - minRocks + 1);
        nRocks += minRocks;

        // Algorithm for randomizing the rock scatter
        int i, probability = nRocks / this.tileTotal;
        if(randomizeScatter) {
            while(this.getRocks() < nRocks) {
                for(i = 0; i < this.tileTotal; i++) {
                    int roll = rand.nextInt(101);
                    // If the random integer generated roll is within the probability, a rock is set on the tile.
                    if(roll <= probability) {
                        land[i].setRock(true);
                    }
                }
                // By the time this process finishes, there's a small chance nRocks has not been satisfied yet.
                // In this case, the algorithm will be ran once more.
            }
        }

        // The setting of rocks according to the user's configuration
        else {
            for(i = 0; i < this.tileTotal; i++) {
                if(arrConfig[i] == 1) {
                    land[i].setRock(true);
                }
            }
        }
    }

    /**
     * This method gets the number of live crops currently present on the whole farm.
     * 
     * @return  the number of live crops present on the farm
     */
    public int getCrops() {
        int i, count = 0;
        for(i = 0; i < this.tileTotal; i++) {
            if(land[i].getCrop() != null && !land[i].getHasWitheredCrop()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method gets the number of harvestable crops currently present on the whole farm.
     * 
     * @return  the number of harvestable crops present on the farm
     */
    public int getHarvestable() {
        int i, count = 0;
        for(i = 0; i < this.tileTotal; i++) {
            if(land[i].getDaysToHarvest() == 0 && !land[i].getHasWitheredCrop()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method gets the number of withered crops currently present on the whole farm.
     * 
     * @return  the number of withered crops present on the farm
     */
    public int getWithered() {
        int i, count = 0;
        for(i = 0; i < this.tileTotal; i++) {
            if(land[i].getHasWitheredCrop()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method gets the current day.
     * 
     * @return  the current day
     */
    public int getDay() {
        return this.day;
    }
    
    /**
     * This method increments the day and ages all crops in the farm. 
     * This method also checks if a crop on a tile has withered due to certain conditions
     * 
     * @return an empty string if no crop has withered, otherwise returns a string containing information about a withered crop
     */
    public String nextDay() {
        String text = "";
        int i;
        for(i = 0; i < this.tileTotal; i++) {
            if(land[i].getCrop() != null) {
                land[i].ageCrop();

                if(land[i].getHasWitheredCrop()) {
                    if(land[i].getDaysToHarvest() == -1) {
                        text = "\nOh no! Your crop on Tile " + (i + 1) + " has withered because you did not harvest it on time!";
                        land[i].removeCrop();
                    }
                    else if(land[i].getDaysToHarvest() == 0) {
                        if(land[i].getTimesWatered() < land[i].getCrop().getWaterNeeds() || land[i].getTimesFertilized() < land[i].getCrop().getFertilizerNeeds())
                        text = "\nOh no! Your crop on Tile " + (i + 1) + " has withered because you did not take care of it properly!";
                        land[i].removeCrop();
                    }
                }
            }
        }
        this.day++;
        return text;
    }

    /**
     * This method checks if the tile is eligible for a crop of the fruit tree type.
     * 
     * @param tileNumber is the current tile being accessed by the program
     * 
     * @return true if all conditions are met for a tree to be planted on the tile, false otherwise
     */
    public boolean checkTreeEligibility(int tileNumber) {
        tileNumber++;
        // Tiles at the edges of the farm are immediately rejected.
        if(tileNumber < 7 || tileNumber > 44) {
            return false;
        }

        int emptyCount = 0;
        ArrayList<Integer> adjacentTiles = new ArrayList<Integer>();
        // Checks whether the adjacent tiles of the selected tile are all empty
        if(tileNumber % 5 == 2 || tileNumber % 5 == 3 || tileNumber % 5 == 4) {
            adjacentTiles.add(tileNumber - 6);
            adjacentTiles.add(tileNumber - 5);
            adjacentTiles.add(tileNumber - 4);
            adjacentTiles.add(tileNumber - 1);
            adjacentTiles.add(tileNumber + 1);
            adjacentTiles.add(tileNumber + 4);
            adjacentTiles.add(tileNumber + 5);
            adjacentTiles.add(tileNumber + 6);

            // The number of adjacent tiles that are empty
            for (Integer i : adjacentTiles) {
                if(!land[i - 1].isOccupied()) {
                    emptyCount++;
                }
            }
        }

        // If all 8 adjacent tiles are empty, the selected tile is flagged as eligible for a tree.
        if(emptyCount == 8) {
            return true;
        }
        return false;
    }

    /**
     * This method sets a chance of a storm that will happen overnight.
     * A storm wipes out all crops on the farm, including withered crops.
     * 
     * @return true if a storm will happen overnight, false otherwise
     */
    public boolean storm() {
        Random rng = new Random();
        int n;
        boolean result = false;

        n = rng.nextInt(50) + 1;

        // This executes if the player was lucky/unlucky enough to get the 2% chance of a storm happening overnight.
        if(n == 1) {
            for(int i = 0; i < tileTotal; i++) {
                land[i].clearCrop();
            }
            result = true;
        }
        return result;
    }
}