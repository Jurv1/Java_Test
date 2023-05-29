package src;
import java.util.ArrayList;
import java.util.Scanner;

import src.classes.ProductsImpl;

public class JavaBackTest {
    public static void main(String[] args) {
        final ProductsImpl myInterface = new ProductsImpl();
        try (Scanner myInput = new Scanner(System.in)) {
            enum listOfCommands {
                ADD,
                DELETE,
                GET_NAME,
                GET_IDS
            }

            while (true) {
                System.out.println("What do You want to do with our system? (Print a number)");
                for (int i = 0; i < 4; i++) {
                    System.out.println("" + i + " " + listOfCommands.values()[i]);
                }
                System.out.println();
                int input = myInput.nextInt();

                switch (input) {
                    //Не делаю трим для строки так как по дефолту нельзя вводить пустые строки
                    case 0:
                        System.out.println("To create a new product you need to enter unique id and name");
                        System.out.print("Id: ");
                        String myId = myInput.next();
                        System.out.print("Name: ");
                        String myName = myInput.next();
                        final boolean result = myInterface.addProduct(myId, myName);
                        if (result) {
                            System.out.println("Congrats, you have created new product \n");
                            break;
                        }
                        System.out.println("We guess a product with that id is already already... \n");
                        break;
                    case 1:
                        System.out.println("To delete a product, pass id of this");
                        System.out.print("id: ");
                        String idToDelete = myInput.next();
                        final boolean isProductDeleted = myInterface.deleteProduct(idToDelete);
                        if (isProductDeleted) {
                            System.out.println("The product with id " + idToDelete + " was deleted \n");
                            break;
                        }
                        System.out.println("I guess id we have a product with same id... \n");
                        break;
                    case 2:
                        System.out.println("To get name of the product. enter Id");
                        System.out.print("id: ");
                        String idForName = myInput.next();
                        final String productName = myInterface.getName(idForName);
                        if (productName != "") {
                            System.out.println("The name of the product is " + productName + "\n");
                            break;
                        }
                        System.out.println("We didn't find name of the product" + "\n");
                        break;
                    case 3:
                        System.out.println("To get Ids of products with specific name, enter a name");
                        System.out.print("Name: ");
                        final String specificName = myInput.next();
                        ArrayList<String> resultArr = myInterface.findByName(specificName);
                        if (resultArr.size() != 0) {
                            System.out.println("All products ids with name " + specificName);
                            System.out.println("///////////");
                            for (int i = 0; i < resultArr.size(); i++) {
                                System.out.println(resultArr.get(i));
                            }
                            System.out.println("///////////\n");
                            break;
                        }
                        System.out.println("The are no products with that name... \n");
                        break;
                }
            }
        }
    }
}