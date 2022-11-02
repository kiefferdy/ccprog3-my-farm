public class Farmer {
    private String username;
    private int objectcoins;
    private double xp;
    private int level;
    private Rank rank;

    public Farmer(String username, Rank rank) {
        this.username = username;
        this.objectcoins = 100;
        this.xp = 0;
        this.level = 0;
        this.rank = rank;
    }

    public void displayStats() {
        System.out.println("Character Statistics");
        System.out.println("Name: " + this.username);
        System.out.println("Rank: " + this.rank);
        System.out.println("Level: " + this.level);
        System.out.println("Total XP: " + this.xp);
        System.out.println("Object Coins : " + this.objectcoins);
    }

    public String getUsername() {
        return this.username;
    }

    public double getXP() {
        return this.xp;
    }

    public int getLevel() {
        return this.level;
    }

    public Rank getRank() {
        return this.rank;
    }

    public void addXP(int amount) {
        this.xp += amount;
    }

    public int getObjectcoins() {
        return this.objectcoins;
    }

    public void addObjectCoins(int amount) {
        this.objectcoins += amount;
    }

    public void deductObjectCoins(int amount) {
        this.objectcoins -= amount;
    }

    public boolean register(Rank rank) {
        boolean result = false;

        return result;
    }
}
