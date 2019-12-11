public class Main {
    public static void main(String[] args){
        Factory factory = new Factory();
        Warehouse warehouse = new Warehouse();
        DistributionCenter distributionCenter = new DistributionCenter();
        Manager manager = new Manager(factory,warehouse,distributionCenter);
        while(true){
            manager.displayMainMenu();
        }
    }
}
