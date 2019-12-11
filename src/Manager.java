import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager {
    Scanner keyboard ;
    Factory factory;
    Warehouse warehouse;
    DistributionCenter distributionCenter;



    public Manager( Factory factory, Warehouse warehouse, DistributionCenter distributionCenter) {
        keyboard= new Scanner(System.in);
        this.factory = factory;
        this.warehouse = warehouse;
        this.distributionCenter = distributionCenter;
    }

    public void displayMainMenu() {
        int productID;
        int volume;
        mainMenu();
        int n = getPositiveIntFromUser();
        while(n>4){
            System.out.println("Wrong input");
            mainMenu();
            n=getPositiveIntFromUser();
        }
        switch(n){
            case 1:
                System.out.println("Please select the product which you want to produce");
                productMenu();
                productID = getPositiveIntFromUser();
                while (productID>3){
                    System.out.println("Wrong input");
                    productMenu();
                    productID=getPositiveIntFromUser();
                }
                    switch (productID){
                        case 1:
                            System.out.println("Boxed milk producing");
                            factory.produceBoxedMilk();
                            break;
                        case 2:
                            System.out.println("Chocolate producing");
                            factory.produceChocolate();
                            break;
                        case 3:
                            System.out.println("Yoghurt producing");
                            factory.produceYogurt();
                            break;

                    }
                factory.printFactory();
                break;

            case 2:
                System.out.println("Select ingredient which you want to buy");
                ingredientMenu();
                int ingredientID = getPositiveIntFromUser();
                while (ingredientID>4){
                    System.out.println("Wrong input");
                    ingredientMenu();
                    ingredientID=getPositiveIntFromUser();
                }
                System.out.println("Enter the amount of ingredient");
                volume = getPositiveIntFromUser();
                warehouse.buyIngredient(ingredientID,volume);
                warehouse.printWarehouse();
                break;
            case 3:
                System.out.println("Please select the product which you want to sell");
                productMenu();
                productID = getPositiveIntFromUser();
                while (productID>3){
                    System.out.println("Wrong input");
                    productMenu();
                    productID=getPositiveIntFromUser();
                }
                volume = getPositiveIntFromUser();
                distributionCenter.sellProduct(productID,volume);
                distributionCenter.printDistributionCenter();
                break;
        }

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
    public void productMenu(){
        System.out.println("1-BoxedMilk");
        System.out.println("2-Chocolate");
        System.out.println("3-Yoghurt");
    }
    public void ingredientMenu(){
        System.out.println("1-Milk");
        System.out.println("2-Cream");
        System.out.println("3-Cacao");
        System.out.println("4-Yeast");
    }
    public void mainMenu(){
        System.out.println("Please insert number");
        System.out.println("1-Produce.");
        System.out.println("2-Buy Ingredients");
        System.out.println("3-Sell Product");
        System.out.println("4-Quit");
    }


}
