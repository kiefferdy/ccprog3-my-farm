public class Tile {
    private int xPos, yPos;
    private boolean hasRock;
    private boolean isPlowed;
    private Crop crop;
    private ArrayList<Crop> cropList;
    private int daysToHarvest;
    private int timesWatered;
    private int timesFertilized;
    private boolean hasWitheredCrop;
    
    public Tile(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    public void displayStatus() {
        
    }
    
    public ArrayList<Crop> getCropList() {
        return this.cropList;   
    }
    
    public boolean plantCrop(Crop crop) {
        boolean result = false;
        
        return result;
    }
    
    public Crop getCrop() {
        return this.crop;
    }
    
    public boolean hasRock() {
        boolean result = false;
        
        return result;
    }
    
    public void setRock() {
           
    }
    
    public boolean useShovel() {
        boolean result = false;
        
        return result;
    }
    
    public boolean usePickaxe() {
        boolean result = false;
        
        return result;
    }
    
    public boolean Water() {
        boolean result = false;
        
        return result;
    }
    
    public boolean Fertilize() {
        boolean result = false;
        
        return result;
    }
    
    public int getXPos() {
        return this.xPos;   
    }
    
    public int getYPos() {
        return this.yPos;   
    }
}
