/**
 * This class stores the parameters that define each crop.
 */
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
    
    /**
     * This constructor shows the details of a crop.
     * 
     * @param name                  is the name of the crop
     * @param type                  is the type of the crop
     * @param harvestTime           is the harvest time (in days) of the crop
     * @param waterNeeds            is the number of times the crop needs to be watered
     * @param waterBonusLimit       is the bonus gained for watering the crop
     * @param fertilizerNeeds       is the number of times the crop needs to be fertilized
     * @param fertilizerBonusLimit  is the bonus gained for fertilizing the crop
     * @param minProduce            is the minimum produce of the crop
     * @param maxProduce            is the maximum produce of the crop
     * @param seedCost              is the cost of the seed of the crop
     * @param baseHarvestPrice      is the base harvest price of the crop
     * @param expYield              is the exp that the player will gain after harvesting the crop
     */
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
    
    /** 
     * This method gets the name of the crop.
     * 
     * @return  the name of the crop
     */
    public String getName() {
        return this.name;   
    }
    
    /** 
     * This method gets the type of the crop.
     * 
     * @return  the type of the crop
     */
    public String getType() {
        return this.type;   
    }
    
    /** 
     * This method gets the harvest time of the crop in days.
     * 
     * @return  the harvest time of the crop in days
     */
    public int getHarvestTime() {
        return this.harvestTime;   
    }
    
    /** 
     * This method gets the number of times the crop needs to be watered.
     * 
     * @return  the water needs of the crop
     */
    public int getWaterNeeds() {
        return this.waterNeeds;   
    }
    
    /** 
     * This method gets the water bonus limit of the crop.
     * 
     * @return  the water bonus limit of the crop
     */
    public int getWaterBonusLimit() {
        return this.waterBonusLimit;   
    }
    
    /** 
     * This method gets the number of times the crop needs to be fertilized.
     * 
     * @return  the fertilizer needs of the crop
     */
    public int getFertilizerNeeds() {
        return this.fertilizerNeeds;   
    }
    
    /** 
     * This method gets the fertilizer bonus limit of the crop.
     * 
     * @return  the fertilizer bonus limit of the crop
     */
    public int getFertilizerBonusLimit() {
        return this.fertilizerBonusLimit;   
    }
    
    /** 
     * This method returns the minimum number of produce the crop can produce.
     * 
     * @return  the minimum produce of the crop upon harvest
     */
    public int getMinProduce() {
        return this.minProduce;   
    }
    
    /** 
     * This method return the maximum number of produce the crop can produce.
     * 
     * @return  the maximum produce of the crop upon harvest
     */
    public int getMaxProduce() {
        return this.maxProduce;   
    }
    
    /** 
     * This method returns the seed cost of the crop.
     * 
     * @return  the seed cost of the crop
     */
    public int getSeedCost() {
        return this.seedCost;   
    }
    
    /** 
     * This method returns the base harvest price of the crop.
     * 
     * @return  the base harvest price of the crop
     */
    public int getBaseHarvestPrice() {
        return this.baseHarvestPrice;
    }
    
    /** 
     * This method returns the experience a player can gain by harvesting the crop.
     * 
     * @return  the experience yield of a crop
     */
    public double getExpYield() {
        return this.expYield;   
    }
}
