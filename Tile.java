import java.util.Random;

public class Tile {
    private int xPos, yPos;
    private boolean isPlowed;
    private boolean hasRock;
    private Crop crop;
    private int daysToHarvest;
    private int timesWatered;
    private int timesFertilized;
    private boolean hasWitheredCrop;
    
    public Tile(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.isPlowed = false;
        this.hasRock = false;
        this.daysToHarvest = -1;
    }
    
    public void displayStatus() {
        System.out.printf("\nStatus of Tile %d, %d", this.xPos, this.yPos);
        System.out.printf("\n\tHas Been Plowed: %s", this.isPlowed ? "Yes" : "No");
        System.out.printf("\n\tContains Rock: %s", this.hasRock ? "Yes" : "No");
        System.out.printf("\n\tContains Withered Crop: %s", this.hasWitheredCrop ? "Yes" : "No");
        System.out.printf("\n\tCrop Planted: %s", this.crop != null ? this.crop.getName() : "N/A");
        System.out.printf("\n\tTime Until Harvest: %s", this.crop != null ? Integer.toString(this.daysToHarvest) : "N/A");
        System.out.printf("\n\tRemaining Water Needs: %s", this.crop != null ? Integer.toString(this.crop.getWaterNeeds() - this.timesWatered) : "N/A");
        System.out.printf("\n\tRemaining Fertilizer Needs: %s\n", this.crop != null ? Integer.toString(this.crop.getFertilizerNeeds() - this.timesFertilized) : "N/A");
    }
    
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
    
    public void ageCrop() {
        if(daysToHarvest <= 0) {
            this.hasWitheredCrop = true;
        }
        else if(daysToHarvest == 1) {
            if(timesWatered < crop.getWaterNeeds() || timesFertilized < crop.getFertilizerNeeds()) {
                this.hasWitheredCrop = true;
            }
        }
        this.daysToHarvest--;
    }

    public boolean getHasWitheredCrop() {
        return this.hasWitheredCrop;
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

    public boolean setPlowed() {
        if(this.isPlowed) {
            System.out.println("You cannot plow a tile that is already plowed!");
            return false;
        }
        this.isPlowed = true;
        return true;
    }
    
    public boolean useShovel() {
        if(!this.hasWitheredCrop) {
            System.out.println("You cannot use your shovel on a tile that does not contain a withered crop!");
            return false;
        }
        this.hasWitheredCrop = false;
        this.crop = null;
        this.timesWatered = 0;
        this.timesFertilized = 0;
        return true;
    }
    
    public boolean usePickaxe() {
        if(!this.hasRock) {
            System.out.println("You cannot use your pickaxe on a tile that does not contain a rock!");
            return false;
        }
        this.hasRock = false;
        return true;
    }
    
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

    public int getTimesWatered() {
        return this.timesWatered;
    }
    
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

    public int getTimesFertilized() {
        return this.timesFertilized;
    }
    
    public int harvestCrop() {
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

    public int getDaysToHarvest() {
        return this.daysToHarvest;
    }
    
    public int getXPos() {
        return this.xPos;   
    }
    
    public int getYPos() {
        return this.yPos;   
    }
}
