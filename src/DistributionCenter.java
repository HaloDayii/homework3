import java.util.*;

public class DistributionCenter {
    private StorageArea<Chocolate> chocolateStorageArea;
    private StorageArea<Yogurt>    yogurtStorageArea;
    private StorageArea<BoxedMilk> boxedMilkStorageArea;
    private Scanner keyboard;

    public DistributionCenter(){
        chocolateStorageArea = new StorageArea<>();
        yogurtStorageArea    = new StorageArea<>();
        boxedMilkStorageArea = new StorageArea<>();
        keyboard             = new Scanner(System.in);
    }

    public void sellProduct(int x,int amount){
        switch (x){
            case 1:
                boxedMilkStorageArea.drainStorage(amount);
                break;
            case 2:
                chocolateStorageArea.drainStorage(amount);
                break;
            case 3:
                yogurtStorageArea.drainStorage(amount);
                break;
        }
    }

    public void printDistributionCenter(){
        chocolateStorageArea.printStorage();
        yogurtStorageArea.printStorage();
        boxedMilkStorageArea.printStorage();
    }

    private int getPositiveIntFromUser(){
        int result = 0;
        boolean done = false;
        while (! done) {
            try {
                System.out.println("Enter a whole number:");
                result = keyboard.nextInt();
                if (result>0) done = true;

            } catch (InputMismatchException e) {
                keyboard.nextLine();
                System.out.println("Not a correctly written whole number.");
                System.out.println("Try again.");
            }

        }
        return result;
    }
}
