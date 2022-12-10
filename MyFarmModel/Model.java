package MyFarmModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Model {
    private ArrayList<Rank> rankList;
    private Rank farmer, registered, distinguished, legendary;
    private ArrayList<Crop> cropList;
    private Farmer user;
    private MyFarm farm;

    /**
     * This constructor instantiates all ranks and crops in the game
     */
    public Model() {
        // Instatiating the farmer ranks
        this.rankList = new ArrayList<Rank>();
        this.farmer = new Rank("Farmer", 0, 0, 0, 0, 0, 0);
        this.registered = new Rank("Registered Farmer", 5, 1, 1, 0, 0, 200);
        this.distinguished = new Rank("Distinguished Farmer", 10, 2, 2, 1, 0, 300);
        this.legendary = new Rank("Legendary Farmer", 15, 4, 3, 2, 1, 400);
        
        // Adding the ranks to the rank list
        rankList.add(this.farmer);
        rankList.add(this.registered);
        rankList.add(this.distinguished);
        rankList.add(this.legendary);

        // Instantiating the crops
        this.cropList = new ArrayList<Crop>();
        Crop turnip = new Crop("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5);
        Crop carrot = new Crop("Carrot", "Root crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5);
        Crop potato = new Crop("Potato", "Root crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5);
        Crop rose = new Crop("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5);
        Crop tulips = new Crop("Tulips", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5);
        Crop sunflower = new Crop("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5);
        Crop mango = new Crop("Mango", "Fruit tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25);
        Crop apple = new Crop("Apple", "Fruit tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25);
        
        // Adding the crops to the crop list
        cropList.add(turnip);
        cropList.add(carrot);
        cropList.add(potato);
        cropList.add(rose);
        cropList.add(tulips);
        cropList.add(sunflower);
        cropList.add(mango);
        cropList.add(apple);
    }

    /**
     * This method reads the rock configuration file and passes the data read to setRocks() in the MyFarm class
     */
    public void initializeRocks() {
        boolean randomizeScatter = true;
        boolean useRecommendedValues = true;
        int i, minRocks = 10, maxRocks = 30;
        int arr[] = new int[farm.getTileTotal()];

        try {
            Scanner fileReader = new Scanner(new File("rocksConfig.txt"));

            // Reads the boolean values indicating how the scatter should be done
            randomizeScatter = fileReader.nextBoolean();
            useRecommendedValues = fileReader.nextBoolean();

            // Reads the min and max values the user has inputted if useRecommendedValues is set to false
            if(randomizeScatter && !useRecommendedValues) {
                minRocks = fileReader.nextInt();
                maxRocks = fileReader.nextInt();
            }
            else {
                fileReader.nextInt();
                fileReader.nextInt();
            }

            // In the case that the user decides to manually set exactly which tiles have rocks in them
            if(!randomizeScatter) {
                for(i = 0; i < farm.getTileTotal(); i++) {
                    arr[i] = fileReader.nextInt();
                }
            }

            fileReader.close();
        }
        // Displays an error when the file cannot be read
        catch(FileNotFoundException e) {
            System.out.println("An error occurred with reading the rocksConfig.txt file!");
            e.printStackTrace();
        }

        this.farm.setRocks(randomizeScatter, minRocks, maxRocks, arr);
    }

    /**
     * This method creates a new farm and a new farmer 
     * 
     * @param name is the name of the player
     */
    public void createFarmer(String name) {
        this.farm = new MyFarm();
        this.user = new Farmer(name, this.getRankList().get(0), farm);
    }

    /**
     * This method gets the farmer/player
     * 
     * @return the farmer/player
     */
    public Farmer getFarmer() {
        return this.user;
    }

    /**
     * This method gets the farm
     * 
     * @return the farm
     */
    public MyFarm getMyFarm() {
        return this.farm;
    }

    /**
     * This method gets the list of crops
     * 
     * @return the crop list
     */
    public ArrayList<Crop> getCropList() {
        return this.cropList;
    }

    /**
     * This method gets the list of ranks
     * 
     * @return the rank list
     */
    public ArrayList<Rank> getRankList() {
        return this.rankList;
    }
}
