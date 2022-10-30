public class Rank {
    private String name;
    private int levelRequirements;
    private int bonusEarnings;
    private int costReduction;
    private int bonusWaterLimit;
    private int bonusFertilizerLimit;
    private int registrationFee;
    
    public Rank(String name, int levelRequirements, int bonusEarnings, int costReduction, int bonusWaterLimit, int bonusFertilizerLimit, int registrationFee) {
        this.name = name;
        this.levelRequirements = levelRequirements;
        this.bonusEarnings = bonusEarnings;
        this.costReduction = costReduction;
        this.bonusWaterLimit = bonusWaterLimit;
        this.bonusFertilizerLimit = bonusFertilizerLimit;
        this.registrationFee = registrationFee;
    }
    
    public String getRank() {
        return this.name;   
    }
    
    public int getLevelRequirements() {
        return this.levelRequirements;   
    }
    
    public int getBonusEarnings() {
        return this.bonusEarnings;   
    }
    
    public int getCostReduction() {
        return this.costReduction;   
    }
        
    public int getBonusWaterLimit() {
        return this.bonusWaterLimit;   
    }
    
    public int getBonusFertilizerLimit() {
        return this.bonusFertilizerLimit;   
    }
    
    public int getRegistrationFee() {
        return this.registrationFee;   
    }
}
