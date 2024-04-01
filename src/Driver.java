/* ###################################
Title: Driver Class
Author: Draedn Groves
Date: Mar.21st/2024
Purpose: Driver class to test the aspects of other classes
################################### */

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        // Create multiple Products with valid data of your choice (at least 3).
        try {
            Product product1 = new Product("123", "Milk", 4.59, 23, 77, "Keep Refrigerated");
            Product product2 = new Product("456", "Bread", 2.99, 30, 70, "Keep in a cool, dry place");
            Product product3 = new Product("789", "Eggs", 3.49, 12, 88, "Keep Refrigerated");

            // Create multiple Perishable Products with valid data of your choice (at least 2).
            // Assuming PerishableProduct is a subclass of Product
            /*PerishableProduct perishableProduct1 = new PerishableProduct("321", "Chicken", 9.99, 10, 90, "Keep Refrigerated", "2024-05-23");
            PerishableProduct perishableProduct2 = new PerishableProduct("654", "Cheese", 5.99, 15, 85, "Keep Refrigerated", "2024-04-20");
*/
            // Put all the products you created (perishable and non-perishable) in ArrayLists
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            products.add(product3);
            /*products.add(perishableProduct1);
            products.add(perishableProduct2);*/

            // Utilize your collection to display all the details of its contents.
            for (Product product : products) {
                System.out.println(product.toString());
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

// randomly testing things here.
