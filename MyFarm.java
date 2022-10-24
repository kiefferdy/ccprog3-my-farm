public class MyFarm {
  private Farmer farmer;
  private int landWidth;
  private int landLength;
  private Tile[][] land;
  private int rocks;
  private int days;
  private int harvestable;
  private int withered;
  
  public MyFarm() {
    this.farmer = new Farmer();
    this.landWidth = 1;
    this.landLength = 1;
    this.land = new Tile[landWidth][landLength];
    this.rocks = 0;
    this.days = 1;
    this.harvestable = 0;
    this.withered = 0;
  }
  
  
}
