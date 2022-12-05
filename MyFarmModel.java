import java.util.ArrayList;

public class MyFarmModel {
    private ArrayList<Rank> rankList;
    private Rank farmer, registered, distinguished, legendary;
    private ArrayList<Crop> cropList;
    private Farmer user;
    private MyFarm farm;

    public MyFarmModel() {
        this.rankList = new ArrayList<Rank>();
        this.farmer = new Rank("Farmer", 0, 0, 0, 0, 0, 0);
        this.registered = new Rank("Registered Farmer", 5, 1, 1, 0, 0, 200);
        this.distinguished = new Rank("Distinguished Farmer", 10, 2, 2, 1, 0, 300);
        this.legendary = new Rank("Legendary Farmer", 15, 4, 3, 2, 1, 400);
        rankList.add(this.farmer);
        rankList.add(this.registered);
        rankList.add(this.distinguished);
        rankList.add(this.legendary);

        this.cropList = new ArrayList<Crop>();
        Crop turnip = new Crop("Turnip", "Root crop", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5);
        Crop carrot = new Crop("Carrot", "Root crop", 3, 1, 2, 0, 1, 1, 2, 10, 9, 7.5);
        Crop potato = new Crop("Potato", "Root crop", 5, 3, 4, 1, 2, 1, 10, 20, 3, 12.5);
        Crop rose = new Crop("Rose", "Flower", 1, 1, 2, 0, 1, 1, 1, 5, 5, 2.5);
        Crop tulips = new Crop("Tulips", "Flower", 2, 2, 3, 0, 1, 1, 1, 10, 9, 5);
        Crop sunflower = new Crop("Sunflower", "Flower", 3, 2, 3, 1, 2, 1, 1, 20, 19, 7.5);
        Crop mango = new Crop("Mango", "Fruit tree", 10, 7, 7, 4, 4, 5, 15, 100, 8, 25);
        Crop apple = new Crop("Apple", "Fruit tree", 10, 7, 7, 5, 5, 10, 15, 200, 5, 25);
        cropList.add(turnip);
        cropList.add(carrot);
        cropList.add(potato);
        cropList.add(rose);
        cropList.add(tulips);
        cropList.add(sunflower);
        cropList.add(mango);
        cropList.add(apple);
    }

    public void createFarmer(String name) {
        this.farm = new MyFarm();
        this.user = new Farmer(name, farmer, farm);
    }
}
