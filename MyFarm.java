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
    this.land = new Tile[landLength][landWidth];
    this.rocks = 0;
    this.days = 1;
    this.harvestable = 0;
    this.withered = 0;
  }
  
  public void displayLand() {
    
  }
  
  public int getRocks() {
    
  }
  
  public int getHarvestable() {
    
  }
  
  public int getWithered() {
    
  }
  
  public int checkDay() {
    return this.day; 
  }
  
  public void nextDay() {
    this.day++; 
  }
  
  public boolean checkGameOver() {
    boolean result = false;
    
    if(getWithered() + getRocks() == 50) {
      result = true; 
    }
    
    return result;
  }
}
