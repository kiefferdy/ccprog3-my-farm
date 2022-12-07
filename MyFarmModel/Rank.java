/**
 * This class stores the parameters that define each rank.
 */
public class Rank {
    private String name;
    private int levelRequirements;
    private int bonusEarnings;
    private int costReduction;
    private int bonusWaterLimit;
    private int bonusFertilizerLimit;
    private int registrationFee;
    
    /**
     * This constructor shows the rank, the perks associated with it, as well as any requirements for signing up for it.
     * 
     * @param name                  is the name of the rank
     * @param levelRequirements     is the level needed for the player to reach the rank
     * @param bonusEarnings         is the bonus earnings that the player will get when reaching the rank
     * @param costReduction         is the cost reduction that the player will get when reaching the rank
     * @param bonusWaterLimit       is the bonus water limit that the player will get when reaching the rank
     * @param bonusFertilizerLimit  is the bonus fertilizer limit that the player will get when reaching the rank
     * @param registrationFee       is the registration fee the player needs to get the rank
     */
    public Rank(String name, int levelRequirements, int bonusEarnings, int costReduction, int bonusWaterLimit, int bonusFertilizerLimit, int registrationFee) {
        this.name = name;
        this.levelRequirements = levelRequirements;
        this.bonusEarnings = bonusEarnings;
        this.costReduction = costReduction;
        this.bonusWaterLimit = bonusWaterLimit;
        this.bonusFertilizerLimit = bonusFertilizerLimit;
        this.registrationFee = registrationFee;
    }
    
    /**
     * This method gets the name of the rank.
     * 
     * @return  the name of the rank
     */
    public String getRank() {
        return this.name;   
    }
    
    /**
     * This method gets the level needed for the player to be able to register for the rank.
     * 
     * @return  the level requirement for the player to be able to register for the rank
     */
    public int getLevelRequirements() {
        return this.levelRequirements;   
    }
    
     /**
     * This method gets the bonus earnings that the player will get in the case that he/she successfully registers for the rank.
     * 
     * @return  the bonus earnings the player will get
     */
    public int getBonusEarnings() {
        return this.bonusEarnings;   
    }
    
    /**
     * This method gets the cost reduction that the player will get in the case that he/she successfully registers for the rank.
     * 
     * @return  the cost reduction the player will get
     */
    public int getCostReduction() {
        return this.costReduction;   
    }
    
     /**
     * This method gets the bonus water limit that the player will get in the case that he/she successfully registers for the rank.
     * 
     * @return  the bonus water limit the player will get
     */
    public int getBonusWaterLimit() {
        return this.bonusWaterLimit;   
    }
    
    /**
     * This method gets the bonus fertilizer limit that the player will get in the case that he/she successfully registers for the rank.
     * 
     * @return  the bonus fertilizer limit the player will get when reaching the rank
     */
    public int getBonusFertilizerLimit() {
        return this.bonusFertilizerLimit;   
    }
    
    /**
     * This method gets the registration fee the player must shoulder to be able to register for the rank.
     * 
     * @return  the registration fee the player needs to shoulder to get the rank
     */
    public int getRegistrationFee() {
        return this.registrationFee;   
    }
}
