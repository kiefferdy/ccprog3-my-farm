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
    System.out.printf("Current Day: %d\n", this.day);
    System.out.printf("Land Size: %d x %d\n", landLength, landWidth);
    System.out.printf("Uncleared Rocks: %d\n", this.getRocks());
    System.out.printf("Planted Crops: %d\n", this.getCrops());
    System.out.printf("Harvestable Crops: %d\n", this.getHarvestable());
    System.out.printf("Withered Crops: %d\n", this.getWithered());
  }

  public void createTiles() {
    int i, j;
    for(i = 0; i < this.landLength; i++) {
      for(j = 0; j < this.landWidth; j++) {
        land[i][j] = new Tile(i + 1, j + 1);
      }
    }
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
      for(j = 0; j < this.landWidth; j++) {
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
      for(j = 0; j < this.landWidth; j++) {
        if(land[i][j].getCrop() != null && !land[i][j].getHasWitheredCrop()) {
          count++;
        }
      }
    }
    return count;
  }
  
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
  
  public int getDay() {
    return this.day;
  }
  
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