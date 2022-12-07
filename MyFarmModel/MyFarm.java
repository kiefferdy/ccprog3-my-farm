package MyFarmModel;
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
        this.tileTotal = 50;
        this.land = new Tile[tileTotal];
        this.day = 1;
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
     * @param xPos  is the row position of the tile
     * @param yPos  is the column position of the tile
     * @return      the tile the player chooses
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
     * @return  the number of uncleared rocks present on the farm 
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
     */
    public void nextDay() {
        int i;
        for(i = 0; i < this.tileTotal; i++) {
            if(land[i].getCrop() != null) {
                land[i].ageCrop();
            }
        }
        this.day++;
    }
}
