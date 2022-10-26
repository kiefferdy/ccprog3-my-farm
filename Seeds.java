public class Seeds {
    private Flowers flowers;
    private FruitTrees fruitTrees;
    private RootCrops rootCrops;

    public Seeds() {
        this.flowers = new Flowers();
        this.fruitTrees = new FruitTrees();
        this.rootCrops = new RootCrops();
    }

    public RootCrops getRootCrops() {
        return this.rootCrops;
    }

    public FruitTrees getFruitTrees() {
        return this.fruitTrees;
    }

    public Flowers getFlowers() {
        return this.flowers;
    }
}
