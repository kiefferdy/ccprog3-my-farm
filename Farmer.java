public class Farmer {
    private String username;
    private int objectCoins;
    private int xp;
    private int level;
    private Rank rank;

    public Farmer(String username) {
        this.username = username;
        this.objectCoins = 100;
        this.xp = 0;
        this.level = 0;
        this.rank = new Rank();
    }

    public void displayStats() {
        System.out.println("Name: " + this.username);
        System.out.println("Level: " + this.level);
        System.out.println("Current XP: " + this.xp);
        System.out.println("Object Coins : " + this.objectCoins);
        System.out.println("Rank: " + this.rank.getRank());
    }

    public String getUsername() {
        return this.username;
    }

    public int getXP() {
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

    public int getObjectCoins() {
        return this.objectCoins;
    }

    public void addObjectCoins(int amount) {
        this.objectCoins += amount;
    }

    public void deductObjectCoins(int amount) {
        this.objectCoins -= amount;
    }

    public boolean register(Rank rank) {
        boolean result = false;

        return result;
    }
}
