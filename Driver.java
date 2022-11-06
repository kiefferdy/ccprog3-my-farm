import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // Instantiating the farmer ranks
        Rank farmer = new Rank("Farmer", 0, 0, 0, 0, 0, 0);
        Rank registered = new Rank("Registered Farmer", 5, 1, 1, 0, 0, 200);
        Rank distinguished = new Rank("Distinguished Farmer", 10, 2, 2, 1, 0, 300);
        Rank legendary = new Rank("Legendary Farmer", 15, 4, 3, 2, 1, 400);

        // Storing all farmer ranks into an ArrayList
        ArrayList<Rank> rankList = new ArrayList<Rank>();
        rankList.add(farmer);
        rankList.add(registered);
        rankList.add(distinguished);
        rankList.add(legendary);

        // Instantiating the crops
        Crop turnip = new Crop("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5);
        Crop carrot = new Crop("Carrot", "Root crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5);
        Crop potato = new Crop("Potato", "Root crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5);
        Crop rose = new Crop("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5);
        Crop tulips = new Crop("Tulips", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5);
        Crop sunflower = new Crop("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5);
        Crop mango = new Crop("Mango", "Fruit tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25);
        Crop apple = new Crop("Apple", "Fruit tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25);
        
        // Storing all crops into an ArrayList
        ArrayList<Crop> cropList = new ArrayList<Crop>();
        cropList.add(turnip);
        cropList.add(carrot);
        cropList.add(potato);
        cropList.add(rose);
        cropList.add(tulips);
        cropList.add(sunflower);
        cropList.add(mango);
        cropList.add(apple);

        Scanner sc = new Scanner(System.in);
        System.out.printf("Please enter your character name: ");
        String username = sc.next();
        MyFarm myFarm = new MyFarm();
        myFarm.createTiles();
        Farmer player = new Farmer(username, farmer, myFarm);

        // Welcome message
        System.out.printf("\nWelcome to MyFarm, %s!\n", player.getUsername());
        System.out.println("Your goal is to get rich by planting all sorts of crops.");
        System.out.println("Don't forget to water and harvest your crops to prevent them from withering!");

        player.displayStats();
        myFarm.displayOverview();

        // Game run
        do {
            int menuChoice = 0;
            do {
                System.out.println("");
                System.out.println("What would you like to do?");
                System.out.println("1 - Display my character's statistics");
                System.out.println("2 - Display an overview of my whole farm");
                System.out.println("3 - Display the status of my tile");
                System.out.println("4 - Use a tool");
                System.out.println("5 - Plant a crop");
                System.out.println("6 - Harvest a crop");
                System.out.println("7 - Sleep and advance to the next day");
                System.out.println("8 - Register for a rank");
                System.out.println("9 - End the game");
                System.out.print("Enter your choice: ");
                menuChoice = sc.nextInt();
            } while(menuChoice < 1 || menuChoice > 9);

            switch(menuChoice) {
                case 1:
                    player.displayStats();
                    break;
                case 2:
                    myFarm.displayOverview();
                    break;
                case 3:
                    myFarm.getTile(1, 1).displayStatus();
                    break;
                case 4:
                    int toolChoice = 0;
                    do {
                        System.out.println("");
                        System.out.println("Choose a tool to use.");
                        System.out.println("1 - Plow (Cost: FREE)");
                        System.out.println("2 - Watering Can (Cost: FREE)");
                        System.out.println("3 - Fertilizer (Cost: 10 Objectcoins)");
                        System.out.println("4 - Pickaxe (Cost: 50 Objectcoins)");
                        System.out.println("5 - Shovel (Cost: 7 Objectcoins)");

                        System.out.print("Enter your choice: ");
                        toolChoice = sc.nextInt();
                    } while(toolChoice < 1 || toolChoice > 5);

                    switch(toolChoice) {
                        case 1:
                            player.usePlow(1, 1);
                            break;
                        case 2:
                            player.useWateringCan(1, 1);
                            break;
                        case 3:
                            player.useFertilizer(1, 1);
                            break;
                        case 4:
                            player.usePickaxe(1, 1);
                            break;
                        case 5:
                            player.useShovel(1, 1);
                            break;
                    }
                    break;
                case 5:
                    int i, cropChoice = 0;
                    do {
                        System.out.printf("\nChoose a crop to plant.\n");

                        i = 0;
                        for (Crop crop : cropList) {
                            System.out.printf("%d - %s (Cost: %d Objectcoins)\n", i + 1, crop.getName(), crop.getSeedCost());
                            i++;
                        }

                        System.out.print("Enter your choice: ");
                        cropChoice = sc.nextInt();
                    } while(cropChoice < 1 || cropChoice > 8);

                    player.plant(cropList.get(cropChoice - 1), 1, 1);
                    break;
                case 6:
                    player.harvest(1, 1);
                    break;
                case 7:
                    System.out.println("Sleeping...");
                    myFarm.nextDay();
                    break;
                case 8:
                    int rankChoice = 0;
                    do {
                        System.out.printf("\nChoose the rank you would like to register for.\n\n");

                        i = 0;
                        for(Rank rank : rankList) {
                            System.out.printf("%d - %s\n", i + 1, rank.getRank());
                            System.out.printf("\tLevel Required: %d\n", rank.getLevelRequirements());
                            System.out.printf("\tRegistration Fee: %d Objectcoins\n\n", rank.getRegistrationFee());
                            i++;
                        }

                        System.out.print("Enter your choice: ");
                        rankChoice = sc.nextInt();
                    } while(rankChoice < 1 || rankChoice > 4);

                    player.register(rankList.get(rankChoice - 1));
                    break;
                case 9:
                    player.setGameOver();
                    break;
            }
        } while(!player.checkGameOver());

        System.out.println("");
        System.out.println("GAME OVER! Here are some of your game statistics...");
        player.displayStats();
        myFarm.displayOverview();
        System.out.printf("\nThanks for playing, %s!", player.getUsername());

        sc.close();
    }
}
