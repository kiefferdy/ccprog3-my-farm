import java.util.Random;

/**
 * This class represents each tile in the farm and stores all the necessary information that define it.
 */
public class Tile {
    private int xPos, yPos;
    private boolean isPlowed;
    private boolean hasRock;
    private Crop crop;
    private int daysToHarvest;
    private int timesWatered;
    private int timesFertilized;
    private boolean hasWitheredCrop;
    
    /**
     * This constructor defines and sets the tile to its default conditions.
     * 
     * @param xPos  the row position of the tile in the farm
     * @param yPos  the column position of the tile in the farm
     */
    public Tile(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isPlowed = false;
        this.hasRock = false;
        this.daysToHarvest = -1;
    }
    
    /**
     * This method displays the status of a tile.
     */
    public void displayStatus() {
        System.out.printf("\nStatus of Tile %d, %d", this.xPos, this.yPos);
        System.out.printf("\n\tHas Been Plowed: %s", this.isPlowed ? "Yes" : "No");
        System.out.printf("\n\tContains Rock: %s", this.hasRock ? "Yes" : "No");
        System.out.printf("\n\tContains Withered Crop: %s", this.hasWitheredCrop ? "Yes" : "No");
        System.out.printf("\n\tCrop Planted: %s", this.crop != null ? this.crop.getName() : "N/A");
        System.out.printf("\n\tTime Until Harvest: %s", this.crop != null ? Integer.toString(this.daysToHarvest) + " day(s)" : "N/A");
        System.out.printf("\n\tRemaining Water Needs: %s", this.crop != null ? Integer.toString(this.crop.getWaterNeeds() - this.timesWatered) : "N/A");
        System.out.printf("\n\tRemaining Fertilizer Needs: %s\n", this.crop != null ? Integer.toString(this.crop.getFertilizerNeeds() - this.timesFertilized) : "N/A");
    }
    
    /**
     * This method attempts to plant a crop on the tile.
     * 
     * @param crop  is the crop to be planted
     * @return      true if crop was planted successfully, false if unsuccessful
     */
    public boolean plantCrop(Crop crop) {
        if(this.crop != null || !this.isPlowed) {
            System.out.println("You may not plant on this tile!");
            return false;
        }
        this.crop = crop;
        this.daysToHarvest = crop.getHarvestTime();
        this.timesWatered = 0;
        this.timesFertilized = 0;

        return true;
    }
    
    /**
     * This method ages the crop and sets the crop as withered if it was not harvested in time or its needs were not met.
     */
    public void ageCrop() {
        if(daysToHarvest <= 0) {
            this.hasWitheredCrop = true;
            System.out.printf("\nALERT: Your %s crop on Tile (%d, %d) has withered because you failed to harvest it in time!\n", this.crop.getName(), this.xPos, this.yPos);
        }
        else if(daysToHarvest == 1) {
            if(timesWatered < crop.getWaterNeeds() || timesFertilized < crop.getFertilizerNeeds()) {
                System.out.printf("\nALERT: Your %s crop on Tile (%d, %d) has withered because you failed to meet its needs in time!\n", this.crop.getName(), this.xPos, this.yPos);
                this.hasWitheredCrop = true;
            }
        }
        this.daysToHarvest--;
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
     * This method plows a tile in the case that it has not yet been plowed.
     * 
     * @return  true if plow is successful, false if not
     */
    public boolean setPlowed() {
        if(this.isPlowed) {
            System.out.println("You cannot plow a tile that is already plowed!");
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
        if(!this.hasWitheredCrop) {
            System.out.println("You cannot use your shovel on a tile that does not contain a withered crop!");
            return false;
        }
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
            System.out.println("You cannot use your pickaxe on a tile that does not contain a rock!");
            return false;
        }
        this.hasRock = false;
        return true;
    }
    
    /**
     * This method increments the water count of a tile in the case that it contains a live crop.
     * 
     * @return  true if crop watering is successful, false if not
     */
    public boolean water() {
        if(this.hasWitheredCrop) {
            System.out.println("You cannot water a withered crop!");
            return false;
        }
        if(this.crop == null) {
            System.out.println("You cannot water an empty tile!");
            return false;
        }
        this.timesWatered++;
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
     *  This method adds to the fertilize count of a tile in the case that it contains a live crop.
     * 
     * @return  true if crop fertilization is successful, false if not
     */
    public boolean fertilize() {
        if(this.hasWitheredCrop) {
            System.out.println("You cannot fertilize a withered crop!");
            return false;
        }
        if(this.crop == null) {
            System.out.println("You cannot fertilize an empty tile!");
            return false;
        }
        this.timesFertilized++;
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
            System.out.println("You cannot harvest a non-existent crop!");
            return -1;
        }
        if(this.hasWitheredCrop) {
            System.out.println("You cannot harvest a withered crop!");
            return -1;
        }
        if(this.daysToHarvest > 0) {
            System.out.printf("You need to wait %d more day(s) to harvest this crop.\n", this.daysToHarvest);
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
        this.timesWatered = 0;
        this.timesFertilized = 0;
        this.daysToHarvest = -1;
        this.isPlowed = false;
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
     * This method gets the row position of the tile.
     * 
     * @return  the row position of the tile
     */
    public int getXPos() {
        return this.xPos;   
    }
    
    /**
     * This method gets the column position of the tile.
     * 
     * @return  the column position of the tile
     */
    public int getYPos() {
        return this.yPos;   
    }
}