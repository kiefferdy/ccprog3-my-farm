/**
 * This class represents the entire farm a player owns.
 */
public class MyFarm {
  private int landWidth;
  private int landLength;
  private Tile[][] land;
  private int day;
  
  /**
   * This constructor declares the size of the player's farm and sets the day to 1.
   */
  public MyFarm() {
    this.landWidth = 1;
    this.landLength = 1;
    this.land = new Tile[landLength][landWidth];
    this.day = 1;
  }
  
  /**
   * This method displays an overview of the farm.
   */
  public void displayOverview() {
    System.out.println("");
    System.out.println("Overview of Your Farm");
    System.out.printf("Current Day: %d\n", this.day);
    System.out.printf("Land Size: %d x %d\n", landLength, landWidth);
    System.out.printf("Uncleared Rocks: %d\n", this.getRocks());
    System.out.printf("Planted Crops: %d\n", this.getCrops());
    System.out.printf("Harvestable Crops: %d\n", this.getHarvestable());
    System.out.printf("Withered Crops: %d\n", this.getWithered());
  }

  /**
   * This method instantiates each tile the farm has.
   */
  public void createTiles() {
    int i, j;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        land[i][j] = new Tile(i + 1, j + 1);
      }
    }
  }

  /**
   * This method gets a specific tile in the farm.
   * 
   * @param xPos  is the row position of the tile
   * @param yPos  is the column position of the tile
   * @return      the tile the player chooses
   */
  public Tile getTile(int xPos, int yPos) {
    return land[xPos - 1][yPos - 1];
  }

  /**
   * This method gets the width of the farm which is also the amount of columns it has.
   * 
   * @return  the width of the farm
   */
  public int getLandWidth() {
    return this.landWidth;
  }

  /**
   * This method gets the length of the farm which is also the amount of rows it has.
   * 
   * @return  the length of the farm
   */
  public int getLandLength() {
    return this.landLength;
  }
  
  /**
   * This method gets the number of uncleared rocks currently present on the whole farm.
   * 
   * @return  the number of uncleared rocks present on the farm 
   */
  public int getRocks() {
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        if(land[i][j].hasRock()) {
          count++;
        }
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
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        if(land[i][j].getCrop() != null && !land[i][j].getHasWitheredCrop()) {
          count++;
        }
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
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        if(land[i][j].getDaysToHarvest() == 0 && !land[i][j].getHasWitheredCrop()) {
          count++;
        }
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
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        if(land[i][j].getHasWitheredCrop()) {
          count++;
        }
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
    int i, j;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        if(land[i][j].getCrop() != null) {
          land[i][j].ageCrop();
        }
      }
    }
    this.day++;
  }
}
