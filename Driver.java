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
        Farmer player = new Farmer(username, farmer, myFarm);

        // Welcome message
        System.out.printf("\nWelcome to MyFarm, %s!\n", player.getUsername());
        System.out.println("Your goal is to get rich by planting all sorts of crops.");
        System.out.println("Don't forget to water and harvest your crops to prevent them from withering!");

        // Game run
        do {
            player.displayStats();
            myFarm.displayOverview();
            
            int menuChoice = 0;
            do {
                System.out.println("What would you like to do?");
                System.out.println("1 - Display my character's statistics");
                System.out.println("2 - Display an overview of my whole farm");
                System.out.println("3 - Display the status of my tile");
                System.out.println("4 - Plant a crop");
                System.out.println("5 - Harvest a crop");
                System.out.println("6 - Use a tool");
                System.out.println("7 - Sleep and advance to the next day");
                System.out.print("Enter your choice: ");
                menuChoice = sc.nextInt();
            } while(menuChoice < 1 || menuChoice > 7);

            if(menuChoice == 1) {
                player.displayStats();
            }
            else if(menuChoice == 2) {
                myFarm.displayOverview();
            }
            else if(menuChoice == 3) {
                myFarm.getTile(1, 1).displayStatus();
            }
            else if(menuChoice == 4) {
                int cropChoice = 0;
                do {
                    System.out.println("");
                    System.out.println("Choose a crop to plant.");
                    System.out.println("1 - Turnip");
                    System.out.println("2 - Carrot");
                    System.out.println("3 - Potato");
                    System.out.println("4 - Rose");
                    System.out.println("5 - Tulips");
                    System.out.println("6 - Sunflower");
                    System.out.println("7 - Mango");
                    System.out.println("8 - Apple");
                    System.out.print("Enter your choice: ");
                    cropChoice = sc.nextInt();
                } while(cropChoice < 1 || cropChoice > 8);

                switch(cropChoice) {
                    case 1:
                        myFarm.getTile(1, 1).plantCrop(turnip);
                        break;
                    case 2:
                        myFarm.getTile(1, 1).plantCrop(carrot);
                        break;
                    case 3:
                        myFarm.getTile(1, 1).plantCrop(potato);
                        break;
                    case 4:
                        myFarm.getTile(1, 1).plantCrop(rose);
                        break;
                    case 5:
                        myFarm.getTile(1, 1).plantCrop(tulips);
                        break;
                    case 6:
                        myFarm.getTile(1, 1).plantCrop(sunflower);
                        break;
                    case 7:
                        myFarm.getTile(1, 1).plantCrop(mango);
                        break;
                    case 8:
                        myFarm.getTile(1, 1).plantCrop(apple);
                        break;
                }
            }
        } while(!myFarm.checkGameOver());

        sc.close();
    }
}