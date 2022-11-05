public class MyFarm {
  private int landWidth;
  private int landLength;
  private Tile[][] land;
  private int day;
  
  public MyFarm() {
    this.landWidth = 1;
    this.landLength = 1;
    this.land = new Tile[landLength][landWidth];
    this.day = 1;
  }
  
  public void displayOverview() {
    System.out.println("");
    System.out.println("Overview of Your Farm");
    System.out.printf("Current Day: %d", this.day);
    System.out.printf("Land Size: %d x %d", landLength, landWidth);
    System.out.printf("Uncleared Rocks: %d", this.getRocks());
    System.out.printf("Planted Crops: %d", this.getCrops());
    System.out.printf("Harvestable Crops: %d", this.getHarvestable());
    System.out.printf("Withered Crops: %d", this.getWithered());
  }

  public Tile getTile(int xPos, int yPos) {
    return land[xPos - 1][yPos - 1];
  }

  public int getLandWidth() {
    return this.landWidth;
  }

  public int getLandLength() {
    return this.landLength;
  }
  
  public int getRocks() {
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; i++) {
        if(land[i][j].hasRock()) {
          count++;
        }
      }
    }
    return count;
  }

  public int getCrops() {
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; i++) {
        if(land[i][j].getCrop() != null) {
          count++;
        }
      }
    }
    return count;
  }
  
  public int getHarvestable() {
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; i++) {
        if(land[i][j].getDaysToHarvest() == 0 && !land[i][j].getHasWitheredCrop()) {
          count++;
        }
      }
    }
    return count;
  }
  
  public int getWithered() {
    int i, j, count = 0;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; i++) {
        if(land[i][j].getHasWitheredCrop()) {
          count++;
        }
      }
    }
    return count;
  }
  
  public int getDay() {
    return this.day;
  }
  
  public void nextDay() {
    this.day++; 
  }
}
