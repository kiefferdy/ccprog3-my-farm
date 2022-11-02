public class Crop {
    private String name;
    private String type;
    private int harvestTime;
    private int waterNeeds;
    private int waterBonusLimit;
    private int fertilizerNeeds;
    private int fertilizerBonusLimit;
    private int minProduce;
    private int maxProduce;
    private int seedCost;
    private int baseHarvestPrice;
    private double expYield;
    
    public Crop(String name, String type, int harvestTime, int waterNeeds, int waterBonusLimit, int fertilizerNeeds, int fertilizerBonusLimit, int minProduce, int maxProduce, int seedCost, int baseHarvestPrice, double expYield) {
        this.name = name;
        this.type = type;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonusLimit = waterBonusLimit;
        this.fertilizerNeeds = fertilizerNeeds;
        this.fertilizerBonusLimit = fertilizerBonusLimit;
        this.minProduce = minProduce;
        this.maxProduce = maxProduce;
        this.seedCost = seedCost;
        this.baseHarvestPrice = baseHarvestPrice;
        this.expYield = expYield;
    }
    
    public String getName() {
        return this.name;   
    }
    
    public String getType() {
        return this.type;   
    }
    
    public int getHarvestTime() {
        return this.harvestTime;   
    }
    
    public int getWaterNeeds() {
        return this.waterNeeds;   
    }
    
    public int getWaterBonusLimit() {
        return this.waterBonusLimit;   
    }
    
    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;   
    }
    
    public int getFertilizerBonusLimit() {
        return this.fertilizerBonusLimit;   
    }
    
    public int getMinProduce() {
        return this.minProduce;   
    }
    
    public int getMaxProduce() {
        return this.maxProduce;   
    }
    
    public int getSeedCost() {
        return this.seedCost;   
    }
    
    public int getBaseHarvestPrice() {
        return this.baseHarvestPrice;
    }
    
    public double getExpYield() {
        return this.expYield;   
    }
}
