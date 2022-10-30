import java.util.ArrayList;
import java.util.Random;

public class Tile {
    private int xPos, yPos;
    private boolean isPlowed;
    private boolean hasRock;
    private boolean hasCrop;
    private Crop crop;
    private ArrayList<Crop> cropList;
    private int daysToHarvest;
    private int timesWatered;
    private int timesFertilized;
    private boolean hasWitheredCrop;
    
    public Tile(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isPlowed = false;
        this.hasCrop = false;
    }
    
    public void displayStatus() {
        System.out.printf("Status of Tile %d, %d", this.xPos, this.yPos);
        System.out.printf("\n\tHas Been Plowed: %s", this.isPlowed ? "Yes" : "No");
        System.out.printf("\n\tContains Rock: %s", this.hasRock ? "Yes" : "No");
        System.out.printf("\n\tContains Withered Crop: %s", this.hasWitheredCrop ? "Yes" : "No");
        System.out.printf("\n\tCrop Planted: %s", this.hasCrop ? this.crop.getName() : "N/A");
        System.out.printf("\n\tTime Until Harvest: %d", this.hasCrop ? this.daysToHarvest : "N/A");
        System.out.printf("\n\tRemaining Water Needs: %d", this.hasCrop ? this.crop.getWaterNeeds() - this.timesWatered : "N/A");
    }
    
    public void addToCropList(Crop crop) {
        int count;
        for(Crop existingCrop : cropList) {
            if(existingCrop.getName().equals(crop.getName())) {
                return false;
            }
        }
        cropList.add(crop);
        return true;
    }
    
    public ArrayList<Crop> getCropList() {
        return this.cropList;   
    }
    
    public boolean plantCrop(Crop crop) {
        if(this.crop != null) {
            return false;
        }
        this.crop = crop;
        this.daysToHarvest = crop.getHarvestTime();
        this.timesWatered = 0;
        this.timesFertilized = 0;
        return true;
    }
    
    public void ageCrop() {
        if(daysToHarvest <= 0) {
            this.hasWitheredCrop = true;
        }
        this.daysToHarvest--;
    }
    
    public Crop getCrop() {
        return this.crop;
    }
    
    public boolean hasRock() {
        return this.hasRock;
    }
    
    public void setRock(boolean hasRock) {
        this.hasRock = hasRock;
    }
    
    public void useShovel() {
        this.hasWitheredCrop = false;
        this.crop = null;
        this.timesWatered = 0;
        this.timesFertilized = 0;
    }
    
    public void usePickaxe() {
        this.hasRock = false;
    }
    
    public boolean Water() {
        if(this.hasWitheredCrop) {
            System.out.println("You cannot water a withered crop!");
            return false;
        }
        this.timesWatered++;
        return true;
    }
    
    public boolean Fertilize() {
        if(this.hasWitheredCrop) {
            System.out.println("You cannot fertilize a withered crop!");
            return false;
        }
        this.timesFertilized++;
        return true;
    }
    
    public int Harvest() {
        if(this.hasWitheredCrop) {
            System.out.println("You cannot harvest a withered crop!");
            return -1;
        }
        if(this.daysToHarvest > 0) {
            System.out.printf("You need to wait %d day(s) to harvest this crop.\n", this.daysToHarvest);
            return -1;
        }
        
        Random rand = new Random();
        int produce = rand.nextInt(crop.getMaxProduce() - crop.getMinProduce() + 1);
        produce += crop.getMinProduce();
        return produce;
    }
    
    public int getXPos() {
        return this.xPos;   
    }
    
    public int getYPos() {
        return this.yPos;   
    }
}
