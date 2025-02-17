package MyFarmModel;

import java.util.Random;

/**
 * This class represents each tile in the farm and stores all the necessary information that define it.
 */
public class Tile {
    private int tileNumber;
    private boolean isPlowed;
    private boolean hasRock;
    private Crop crop;
    private int daysToHarvest;
    private int timesWatered;
    private int timesFertilized;
    private int waterBonus;
    private int fertilizerBonus;
    private int waterNeeds;
    private int fertilizerNeeds;
    private boolean hasWitheredCrop;
    
    /**
     * This constructor defines and sets the tile to its default conditions.
     * 
     * @param tileNumber is the current tile being accessed by the program
     */
    public Tile(int tileNumber) {
        this.tileNumber = tileNumber;
        this.isPlowed = false;
        this.hasRock = false;
        this.daysToHarvest = -1;
    }
    
    /**
     * This method displays the status of a tile.
     */
    public String displayStatus() {
        return  "Has Been Plowed: " + (this.isPlowed ? "Yes" : "No") +
                "\nContains Rock: " + (this.hasRock ? "Yes" : "No") + 
                "\nContains Withered Crop: " + (this.hasWitheredCrop ? "Yes" : "No") +
                "\nCrop Planted: " + (this.crop != null ? this.crop.getName() : "N/A") + 
                "\nTime Until Harvest: " + (this.crop != null && !this.hasWitheredCrop && this.daysToHarvest >= 0 ? Integer.toString(this.daysToHarvest) + " day(s)" : "N/A") +
                "\nRemaining Water Needs: " + (this.crop != null && !this.hasWitheredCrop ? Integer.toString(this.waterNeeds) : "N/A") +
                "\nRemaining Fertilizer Needs: " + (this.crop != null && !this.hasWitheredCrop ? Integer.toString(this.fertilizerNeeds) : "N/A") +
                "\nWater Bonus: " + (this.crop != null && !this.hasWitheredCrop ? Integer.toString(this.waterBonus) : "N/A") +
                "\nFertilizer Bonus: " + (this.crop != null && !this.hasWitheredCrop ? Integer.toString(this.fertilizerBonus) : "N/A");
    }
    
    /**
     * This method attempts to plant a crop on the tile.
     * 
     * @param crop  is the crop to be planted
     *
     */
    public void plantCrop(Crop crop) {
        this.crop = crop;
        this.daysToHarvest = this.crop.getHarvestTime();
        this.timesWatered = 0;
        this.timesFertilized = 0;
        this.waterNeeds = this.crop.getWaterNeeds();
        this.fertilizerNeeds = this.crop.getFertilizerNeeds();
    }
    
    /**
     * This method ages the crop and sets the crop as withered if it was not harvested in time or its needs were not met.
     */
    public void ageCrop() {
        this.daysToHarvest--;
        if(daysToHarvest == -1) {
            this.hasWitheredCrop = true;
        }
        else if(daysToHarvest == 0) {
            if(timesWatered < crop.getWaterNeeds() || timesFertilized < crop.getFertilizerNeeds()) {
                this.hasWitheredCrop = true;
            }
        }
    }

    /**
     * This method checks if the tile contains a withered crop.
     * 
     * @return  true if there is a withered crop, false if none
     */
    public boolean getHasWitheredCrop() {
        return this.hasWitheredCrop;
    }
    
    /**
     * This method checks if there is a crop on the tile.
     * 
     * @return  true if there is a crop, false if none
     */
    public Crop getCrop() {
        return this.crop;
    }
    
    /**
     * This method checks if the tile is occupied by any entity
     * 
     * @return  true if there is an entity on the crop, false if none
     */
    public boolean isOccupied() {
        if(this.hasRock || this.hasWitheredCrop || this.crop != null) {
            return true;
        }
        return false;
    }

    /**
     * This method checks if there is a rock on the tile.
     * 
     * @return  true if there is a rock, false if none
     */
    public boolean hasRock() {
        return this.hasRock;
    }
    
    /**
     * This method either sets a rock on the tile or clears the rock from the tile.
     * 
     * @param hasRock   specifies whether the tile has a rock or not
     */
    public void setRock(boolean hasRock) {
        this.hasRock = hasRock;
    }

    /**
     * This method checks if the tile has been plowed
     * 
     * @return true if the tile is plowed, false if not
     */
    public boolean isPlowed() {
        return this.isPlowed;
    }

    /**
     * This method plows a tile in the case that it has not yet been plowed.
     * 
     * @return  true if plow is successful, false if not
     */
    public boolean setPlowed() {
        if(this.isPlowed) {
            return false;
        }
        this.isPlowed = true;
        return true;
    }
    
    /**
     * This method simulates shoveling the tile which removes the withered crop in the case that there is one.
     * 
     * @return  true if using the shovel is successful, false if not
     */
    public boolean useShovel() {
        this.hasWitheredCrop = false;
        this.clearCrop();
        return true;
    }
    
    /**
     * This method simulates using a pickaxe on the tile which clears the rock on it, if it has one.
     * 
     * @return  true if using the pickaxe is successful, false if not
     */
    public boolean usePickaxe() {
        if(!this.hasRock) {
            return false;
        }
        this.hasRock = false;
        return true;
    }
    
    /**
     * This method increments the water count of a tile in the case that it contains a live crop.
     * This method also adjusts the water needs of the crop after watering it
     * 
     * @return  true if crop watering is successful, false if not
     */
    public boolean water() {
        if(this.hasWitheredCrop) {
            return false;
        }
        if(this.crop == null) {
            return false;
        }

        this.timesWatered++;
        this.waterNeeds = this.crop.getWaterNeeds() - this.timesWatered;
        if(this.waterNeeds < 0) {
            this.waterNeeds = 0;
            this.waterBonus++;
        }
        return true;
    }

    /**
     * This method gets the number of times the crop has been watered.
     * 
     * @return  the number of times the crop has been watered
     */
    public int getTimesWatered() {
        return this.timesWatered;
    }
    
    /**
     * This method adds to the fertilize count of a tile in the case that it contains a live crop.
     * This method also adjusts the fertilizer needs of the crop after fertilizing it
     * 
     * @return  true if crop fertilization is successful, false if not
     */
    public boolean fertilize() {
        if(this.hasWitheredCrop) {
            return false;
        }
        if(this.crop == null) {
            return false;
        }

        this.timesFertilized++;
        this.fertilizerNeeds = this.crop.getFertilizerNeeds() - this.timesFertilized;
        if(this.fertilizerNeeds < 0) {
            this.fertilizerNeeds = 0;
            this.fertilizerBonus++;
        }
        return true;
    }

    /**
     * This method gets the number of times the crop has been fertilized.
     * 
     * @return  the number of times the crop has been fertilized
     */
    public int getTimesFertilized() {
        return this.timesFertilized;
    }
    
    /**
     * This method harvests the crop on the tile in the case that the crop is ready for harvest.
     * 
     * @return  the number of produce the crop produced, otherwise -1 if the harvest was unsuccessful
     */
    public int harvestCrop() {
        if(this.crop == null) {
            return -1;
        }
        if(this.hasWitheredCrop) {
            return -1;
        }
        if(this.daysToHarvest > 0) {
            return -1;
        }
        
        Random rand = new Random();
        int produce = rand.nextInt(crop.getMaxProduce() - crop.getMinProduce() + 1);
        produce += crop.getMinProduce();
        return produce;
    }

    /**
     * This method resets the tile and clears any crop that was previously planted on it.
     */
    public void clearCrop() {
        this.crop = null;
        this.hasWitheredCrop = false;
        this.isPlowed = false;
        this.timesWatered = 0;
        this.timesFertilized = 0;
        this.waterBonus = 0;
        this.fertilizerBonus = 0;
        this.waterNeeds = 0;
        this.fertilizerNeeds = 0;
        this.daysToHarvest = -1;
    }

    /**
     * This method clears any crop details but retains a withered crop if there is one present
     */
    public void removeCrop() {
        this.isPlowed = false;
        this.timesWatered = 0;
        this.timesFertilized = 0;
        this.waterBonus = 0;
        this.fertilizerBonus = 0;
        this.waterNeeds = 0;
        this.fertilizerNeeds = 0;
        this.daysToHarvest = -1;
    }

    /**
     * This method gets the number of days before a crop can be harvested.
     * 
     * @return  the number of days before a crop can be harvested
     */
    public int getDaysToHarvest() {
        return this.daysToHarvest;
    }
    
    /**
     * This method gets the number of the tile.
     * 
     * @return  the number of the tile
     */
    public int getTileNumber() {
        return this.tileNumber;   
    }
}