/* ###################################
Title: Main Class
Author: Draedn Groves
Date: Mar.21st/2024
Purpose: Main class where the program will run.
################################### */

import java.util.Scanner;

public class Main {

    // main program
    public static void main(String[] args) throws Exception {
        displayMenu();
    }

    // The display menu which will immediately prompt the user when the program is run
    public static void displayMenu() throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;

        do { // Display menu options
            System.out.println("""
                    *********************************************
                    |            Draedn's Grocery Store         |
                    *********************************************
                    Please select one of the following options:
                    1.	Populate Product List
                    2.	Display Product
                    3.	Add new Product
                    4.	Exit the Program
                    -----------------------
                    Enter your choice below.""");

            // Error handling
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter an option from the menu please. ");
                sc.next();
            }

            // Set choice = the next int it finds.
            choice = sc.nextInt();

            // Perform service based on selection
            switch (choice) {
                case 1: // Populate Product List
                    System.out.println("You chose option 1. Let's populate the product list!");
                    // call method to populate the product list from Product class
                    Product.populateProductList();
                    Tools.pauseProgram();
                    break;
                case 2: // Display Product
                    System.out.println("You chose option 2. Let's display a product!");
                    // call method to display a product from Product class
                    Product.displayProduct();
                    Tools.pauseProgram();
                    break;
                case 3: // Add new Product
                    System.out.println("You chose option 3. Let's add a new product!");
                    // call method to add new product to the product list in Product class
                    Product.addProduct(Product.products);
                    Tools.pauseProgram();
                    break;
                case 4: // Exit program
                    System.out.println("You chose option 4. Exiting the Program.");
                    Tools.endProgram();
                    break;
                default: // Otherwise, tell them this.
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        sc.close();
    }
}
