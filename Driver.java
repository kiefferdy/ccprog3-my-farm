import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        // Instantiating the farmer ranks
        Rank farmer = new Rank("Farmer", 0, 0, 0, 0, 0, 0);
        Rank registered = new Rank("Registered Farmer", 5, 1, 1, 0, 0, 200);
        Rank distinguished = new Rank("Distinguished Farmer", 10, 2, 2, 1, 0, 300);
        Rank legendary = new Rank("Legendary Farmer", 15, 4, 3, 2, 1, 400);

        // Instantiating the crops
        Crop turnip = new Crop("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5);
        Crop carrot = new Crop("Carrot", "Root crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5);
        Crop potato = new Crop("Potato", "Root crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5);
        Crop rose = new Crop("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5);
        Crop tulips = new Crop("Tulips", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5);
        Crop sunflower = new Crop("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5);
        Crop mango = new Crop("Mango", "Fruit tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25);
        Crop apple = new Crop("Apple", "Fruit tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25);

        Scanner sc = new Scanner(System.in);
        System.out.printf("Please enter your character name: ");
        String username = sc.next();
        Farmer player = new Farmer(username, farmer);
        MyFarm myFarm = new MyFarm(player);

        // Welcome message
        System.out.printf("\nWelcome to MyFarm, %s!\n", player.getUsername());
        System.out.println("Your goal is to get rich by planting all sorts of crops.");
        System.out.println("Don't forget to water and harvest your crops to prevent them from withering!");

        do {
            player.displayStats();
            myFarm.displayOverview();
        } while(!myFarm.checkGameOver());

        sc.close();
    }
}