/* ###################################
Title: Product Class
Author: Draedn Groves
Date: Mar.21st/2024
Purpose: Products class for all types of products
################################### */

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

        public class Product {

            public static ArrayList<Product> products;
            public static ArrayList<PerishableProduct> perishableProducts;


            // Properties of Products class
            private static String sku;
            private String productName;
            private double unitCost;
            private int inventoryQuantity;
            private int orderQuantity;
            private String specialInstructions;



            // default constructor with meaningful default values
            public Product() {
                this.sku = "000000";
                this.productName = "Default Product";
                this.unitCost = 0.0;
                this.inventoryQuantity = 0;
                this.orderQuantity = 0;
                this.specialInstructions = "None";
            }


            // parameterized constructor
            public Product(String sku, String productName, double unitCost, int inventoryQuantity,
                           int orderQuantity, String specialInstructions) throws Exception {
                setSku(sku);
                setProductName(productName);
                setUnitCost(unitCost);
                setInventoryQuantity(inventoryQuantity);
                setOrderQuantity(orderQuantity);
                setSpecialInstructions(specialInstructions);
            }


            // creating random products
            public static void populateProductList() throws Exception {
                Product.products = new ArrayList<>();
                Product.perishableProducts = new ArrayList<>();


                // Non perishables
                Product.products.add(new Product("123456","Clam Chowder", 4.5,
                        47, 25, "Store at room temperature"));
                Product.products.add(new Product("666999", "Canned Tuna", 1.25,
                        133, 50, "Store at room temperature"));
                Product.products.add(new Product("131313", "Maple Beans", 3.5,
                        86, 40, "Store at room temperature"));

                // perishables
                Product.perishableProducts.add(new PerishableProduct("000717", "Protein Brownie",
                        4.5, 88, 50, "Keep in a cool dry place",
                        "2024-04-14"));
                Product.perishableProducts.add(new PerishableProduct("000313", "Chicken Sandwiches",
                        7.99, 9, 30, "Keep refrigerated",
                        "2024-04-5"));

            }

            public static Product displayProduct() {
                Scanner sc = new Scanner(System.in);

                // Find the product by SKU
                for (Product product : products) {
                    if (product.getSku().equals(sku)) {
                        // Check if the product is perishable
                        if (product instanceof PerishableProduct) {
                            PerishableProduct perishableProduct = (PerishableProduct) product;
                            return perishableProduct;
                        } else {
                            return product;
                        }

                    }
                }
                return null;
            }


            // Adding a product to the Array lists:
            public static void addProduct(ArrayList<Product> products) throws Exception {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter product type (1 for regular, 2 for perishable, 3 to exit): ");
                int choice = sc.nextInt();
                sc.nextLine();  // consume newline left-over


                // prompt user what to enter for the new product
                System.out.println("Enter SKU: ");
                String sku = sc.nextLine();
                System.out.println("Enter product name: ");
                String productName = sc.nextLine();
                System.out.println("Enter unit cost: ");
                double unitCost = sc.nextDouble();
                System.out.println("Enter inventory quantity: ");
                int inventoryQuantity = sc.nextInt();
                System.out.println("Enter order quantity: ");
                int orderQuantity = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter special instructions: ");
                String specialInstructions = sc.nextLine();

                // this needs validation^

                if (choice == 1) {
                    Product product = new Product(sku, productName, unitCost, inventoryQuantity, orderQuantity, specialInstructions);
                    Product.products.add(product);
                } else if (choice == 2) {
                    System.out.println("Enter expiry date in the following format (yyyy-mm-dd): ");
                    String expiryDate = sc.nextLine();
                    PerishableProduct perishableProduct = new PerishableProduct(sku, productName, unitCost, inventoryQuantity, orderQuantity, specialInstructions, expiryDate);
                    perishableProducts.add(perishableProduct);
                } else if (choice == 3) {
                    Main.displayMenu();
                }
                else {
                    System.out.println("Invalid choice. Please enter 1 for regular product or 2 for perishable product.");
                }
            }


            // Sub class PerishableProduct that inherits Product's properties
            public static class PerishableProduct extends Product {

                private Date expiryDate;

                public PerishableProduct() {
                    super();
                    this.expiryDate = new Date();  // default to current date
                }

                public PerishableProduct(String sku, String productName, double unitCost,
                                         int inventoryQuantity, int orderQuantity, String specialInstructions,
                                         String expiryDateString) throws Exception {
                    super(sku, productName, unitCost, inventoryQuantity, orderQuantity, specialInstructions);
                    setExpiryDate(expiryDateString);
                }

                public final Date getExpiryDate() {
                    return expiryDate;
                }

        public final void setExpiryDate(String expiryDateString) throws Exception {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.expiryDate = sdf.parse(expiryDateString);
            } catch (Exception e) {
                throw new Exception("Invalid date. Please enter a date in the format yyyy-MM-dd.");
            }
        }

        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return super.toString() + "\n" +
                    "Expiry Date: " + sdf.format(expiryDate);
        }
    }

    public final String getSku() {
        return sku;
    }

    public final void setSku(String sku) throws Exception {
        if (sku == null || sku.isEmpty()) {
            throw new Exception("SKU cannot be null or empty.");
        }
        this.sku = sku;
    }
    // add validation to make sure SKU's can't be the same as each other ^

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) throws Exception {
        if (productName == null || productName.isEmpty()) {
            throw new Exception("Product name cannot be null or empty.");
        }
        this.productName = productName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) throws Exception {
        if (unitCost < 0) {
            throw new Exception("Unit cost cannot be negative.");
        }
        this.unitCost = unitCost;
    }

    public final int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public final void setInventoryQuantity(int inventoryQuantity) throws Exception {
        if (inventoryQuantity < 0) {
            throw new Exception("Inventory quantity cannot be negative.");
        }
        this.inventoryQuantity = inventoryQuantity;
    }

    public final int getOrderQuantity() {
        return orderQuantity;
    }

    public final void setOrderQuantity(int orderQuantity) throws Exception {
        if (orderQuantity < 0) {
            throw new Exception("Order quantity cannot be negative.");
        }
        this.orderQuantity = orderQuantity;
    }

    public final String getSpecialInstructions() {
        return specialInstructions;
    }

    public final void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + "\n" +
                "Product Name: " + productName + "\n" +
                "Unit Cost: " + unitCost + "\n" +
                "Quantity on hand: " + inventoryQuantity + "\n" +
                "Quantity Needed: " + orderQuantity + "\n" +
                "Special Instructions: " + specialInstructions;
    }
}


