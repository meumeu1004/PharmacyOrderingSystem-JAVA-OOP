/************************************************************************************************
 * ADVINCULA, Aliyah V.
 * BSIT 2-1
 * 
 * PharmacyOrderingSystem.java
 * 
 * A console-based ordering system for the neighborhood pharmacy, Botika ni Sinta.
 * Intended user: Pharmacy Clerk
 * 
 * Features: Listing & Searching Products, Adding & Viewing Cart, Checkout, Reporting & Restocking 
 ************************************************************************************************/

import java.util.Scanner;

public class PharmacyOrderingSystem {

    //=================== PRODUCT DATA ===================
    // Seeded or pre-filled parallel array containing the information of each product
    // Each index represents the same product across arrays.
    static String[] productCodes = {"PAR500", "CET05", "LOP02", "IBF400", "ANTI4", "CAR500", "LOZ03", "LOS50"};
    static String[] productNames = {"Paracetamol 500mg", "Cetirizine 5mg", "Loperamide 2mg", "Ibuprofen 400mg",
                                    "Antacids", "Carbocisteine 500mg", "Lozenge 3s", "Losartan 50mg"};
    static double[] productPrices = {4.50, 2.50, 3.00, 10.75, 15.35, 7.00, 12.00, 25.00};
    static int[] productStock = {20, 50, 100, 10, 20, 45, 30, 25};
    static int[] cartQuantity = {0, 0, 0, 0, 0, 0, 0, 0};

    //=================== MAIN METHOD ===================
    // This method will continue to run until the user selects 0
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String menuChoice;

        while (true) {
            System.out.println("\n-----BOTIKA NI SINTA ORDERING SYSTEM-----");
            System.out.print("""
                1) List Products
                2) Search Product
                3) Add to Cart
                4) View Cart
                5) Checkout
                6) Reports and Restock
                0) Exit 
                """);
            System.out.print("Select an Operation: ");
            menuChoice = stdIn.nextLine().trim();

            switch (menuChoice) {
                case "1": listProducts(); break;
                case "2": searchProduct(); break;
                case "3": addToCart(); break;
                case "4": viewCart(); break;
                case "5": checkout(); break;
                case "6": reportsAndRestock(); break;
                case "0": System.out.println("Exiting Program..."); System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.\n");
                    break;
            }
        }
    }
    
//=================== STATIC METHODS ===================

    //=================== TABLE HEADERS ===================

    // For List & Search Tables
    static void tableHeader(String title) {
        System.out.printf("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n");
        System.out.printf("%60s %n", title);
        System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n");
        System.out.printf("%-10s %-15s %-25s %20s %20s %n", "IDX", "CODE", "NAME", "PRICE", "STOCK");
        System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n");
    }
    // For View Cart & Checkout Tables
    static void cartHeader(String title) {
        System.out.printf("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n");
        System.out.printf("%55s %n", title);
        System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n");
        System.out.printf("%-10s %-25s %32s %17s %15s %n", "CODE", "NAME", "PRICE", "QUANTITY", "TOTAL");
        System.out.printf("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━%n");
    }

    //=================== LIST PRODUCT ===================
    static void listProducts() {
        tableHeader("LIST OF PRODUCTS");
        for (int i = 0; i < productCodes.length; i++) {
            System.out.printf("%-10d %-15s %-25s %20.2f %20d %n", (i + 1), productCodes[i], productNames[i], productPrices[i], productStock[i]);
            System.out.printf("───────────────────────────────────────────────────────────────────────────────────────────────────────\n %n");
        } // %-10s %-10s %21.2f %5d %16.2f %n ; real: %-10d %-10s %-25s %-10.2f %-10d %n
    }

    //=================== SEARCH PRODUCT ===================
    static void searchProduct() {
        Scanner stdIn = new Scanner(System.in);
        System.out.printf("%30s %n", "\n ═══ PRODUCT SEARCH ═══");
        System.out.println("Enter a keyword to search: ");
        String keyword = stdIn.nextLine().toLowerCase();

        tableHeader("SEARCH RESULTS");

        int found = 0;
        for (int i = 0; i < productNames.length; i++) {
            if (productNames[i].toLowerCase().contains(keyword)) {
                found++;
                System.out.printf("%-10d %-15s %-25s %20.2f %20d %n",
                        (i + 1), productCodes[i], productNames[i], productPrices[i], productStock[i]);
                System.out.printf("─────────────────────────────────────────────────────────────────────────────────────────────────────── %n" );
            }
        }

        if (found == 0) {
            System.out.println("No matching items found. \n");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        }
    }

    //=================== HELPER METHOD FOR ADD TO CART ===================

    // Returns the index of a product based on its code
    // Returns -1 if the product code is not found
    static int indexOfCode(String code) {
        for (int i = 0; i < productCodes.length; i++) {
            if (productCodes[i].equals(code)) return i;
        }
        return -1;
    }

    //=================== ADD TO CART ===================
    static void addToCart() {
        Scanner stdIn = new Scanner(System.in);
        System.out.printf("%30s %n", "\n═══ ADDING TO CART ═══");
        System.out.print("Enter the product code: ");
        String searchCode = stdIn.nextLine().toUpperCase().trim(); 

        int itemIndex = indexOfCode(searchCode);
        if (itemIndex == -1) {
            System.out.println("Product Code not found.");
            System.out.printf("═══════════════════════\n");
            return;
        }

        int remaining = productStock[itemIndex] - cartQuantity[itemIndex]; // Calculate remaining stock
        if (remaining <= 0) { // User already has max stock in cart
            System.out.println("You already have the maximum available stock of this product in your cart.");
            return;
        }

        int quantity;
        while (true) {
            System.out.printf("Enter quantity (max %d): ", remaining); // Show remaining stock to user

            if (!stdIn.hasNextInt()) { // Check if input is NOT a number
                System.out.println("Invalid input. Please enter a number.");
                stdIn.nextLine(); // 
                continue;
            }

            quantity = stdIn.nextInt();
            stdIn.nextLine(); 

            if (quantity <= 0) {
                System.out.println("Invalid. Quantity must be at least 1."); // Input validation
            } else if (quantity > remaining) { // Ensures requested quantity does not exceed remaining stock
                System.out.printf("Quantity exceeds available stock (%d).\n", remaining);
            } else {
                cartQuantity[itemIndex] += quantity; // Updates the product's quantity in the array cartQuantity
                System.out.println("[" + searchCode + " - Qty: " + quantity + "] has been successfully added to cart!\n");
                break; // 
            }
        }
    }
   
    //=================== SUBTOTAL COMPUTATION FOR VIEW CART & RECEIPT ===================
    // Computes the subtotal of all items currently in the cart.
    static double computeSubtotal() {
        double subtotal = 0;

        for (int i = 0; i < productCodes.length; i++) {
            if (cartQuantity[i] > 0) {
                subtotal += productPrices[i] * cartQuantity[i];
            }
        }

        return subtotal;
    }

    //=================== CART CHECKER FOR VIEW CART & RECEIPT ===================
    // Checks if the shopping cart has no items
    static boolean isCartEmpty() {
        for (int i = 0; i < cartQuantity.length; i++) {
            if (cartQuantity[i] > 0) {
                return false;
            }
        }
        return true;
    }

    // Printed out when the cart is empty
    static void emptyCartPrint(){
        System.out.println("═══════════════════════════");
        System.out.println("═══ Your cart is empty. ═══");
        System.out.println("═══════════════════════════\n");
    }

    //=================== CART PRINTING FOR VIEW CART & RECEIPT ===================
    // Prints all items currently inside the cart
    static void printCartRows() {

        for (int i = 0; i < productCodes.length; i++) {
            if (cartQuantity[i] > 0) {

                double lineTotal = productPrices[i] * cartQuantity[i];

                System.out.printf("%-10s %-35s %23.2f %15d %15.2f %n",
                        productCodes[i],
                        productNames[i],
                        productPrices[i],
                        cartQuantity[i],
                        lineTotal);
                System.out.printf("─────────────────────────────────────────────────────────────────────────────────────────────────────── %n" );
            }
        }

    }

    //=================== VIEW CART ===================
    static void viewCart() {

        if (isCartEmpty()) {
            emptyCartPrint();
            return;
        }

        cartHeader("YOUR CART");

        printCartRows();

        double subtotal = computeSubtotal();

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %.2f%n\n", "Subtotal:", subtotal);
    }


    //=================== CHECKOUT & RECEIPT===================
    static void checkout() {

        Scanner stdIn = new Scanner(System.in);

        if (isCartEmpty()) {    // It will first check if the cart is empty
            emptyCartPrint();
            return;
        }

        double discountPercent = 0;

        while (true) {
            System.out.print("Enter discount code (SENIOR20 / PWD15 / NONE): ");    // If not empty, it will proceed to ask for the discount code
            code = stdIn.nextLine().trim().toUpperCase();                           // the code must not have any whitespace in the middle,   
                                                                                    // because only the TRIM operation is applied
            if (code.equals("SENIOR20")) {
                discountPercent = 20;
                break;
            } else if (code.equals("PWD15")) {
                discountPercent = 15;
                break;
            } else if (code.equals("NONE")) {
                discountPercent = 0;
                break;
            } else {
                System.out.println("Invalid discount code. Please enter a valid code.");    // blanks, spaces, or wrong codes are all rejected
            }
        }

        // The receipt will be printed after the discount has been determined
        cartHeader("RECEIPT");      
        printCartRows();

        // Computation of subtotal, discount, and total amount
        double subtotal = computeSubtotal();
        double discountAmount = subtotal * (discountPercent / 100);
        double total = subtotal - discountAmount;

        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("%-25s %.2f%n", "Subtotal:", subtotal);
        System.out.printf("%-25s %.2f%n", "Discount (" + discountPercent + "%):", discountAmount);
        System.out.printf("%-25s %.2f%n", "Total:", total);

        // Gets final verification from user to proceed with checkout
        System.out.print("\nProceed with purchase? (Y/N): ");
        String proceed = stdIn.nextLine().trim().toUpperCase();

        while (!proceed.equals("Y") && !proceed.equals("N")) {  // Input validation, to ensure user only responds with Y or N 
            System.out.print("Invalid input. Enter Y or N only: ");
            proceed = stdIn.nextLine().trim().toUpperCase();
        }

        if (proceed.equals("Y")) {
            for (int i = 0; i < cartQuantity.length; i++) {
                productStock[i] -= cartQuantity[i];
                cartQuantity[i] = 0;
            }
            System.out.println("\n・・・・・ Purchase successful! Thank you. ・・・・・\n");
        } else {
            System.out.println("Purchase canceled.\n");
        }

    }

    //=================== REPORTS & RESTOCK ===================
    static void reportsAndRestock() {
        Scanner stdIn = new Scanner(System.in);
        int choice;

        // This loop will continue to run unless user selects 0
        do {
            System.out.println("\n=== Reports & Restock ===");
            System.out.println("1) Low stock report (<5)");
            System.out.println("2) Restock item (by code)");
            System.out.println("0) Back");
            System.out.print("Choose an option: ");

            while (!stdIn.hasNextInt()) {
                System.out.println("Invalid input. Enter a number.");
                stdIn.nextLine();
            }
            choice = stdIn.nextInt();
            stdIn.nextLine();

            switch (choice) {
                case 1:
                    tableHeader("LOW STOCK ITEMS");
                    int count = 1;
                    for (int i = 0; i < productCodes.length; i++) {
                        if (productStock[i] < 5) {                                  // This will only print out products with less than 5 stocks
                            System.out.printf("%-10d %-15s %-25s %20.2f %20d %n",
                                    count++, productCodes[i], productNames[i],
                                    productPrices[i], productStock[i]);
                            System.out.printf("───────────────────────────────────────────────────────────────────────────────────────────────────────\n %n");
                        }
                    }
                    if (count == 1) System.out.println("No low stock items.");
                    break;

                case 2:
                    System.out.print("Enter product code to restock: ");
                    String code = stdIn.nextLine().trim().toUpperCase();
                    int idx = indexOfCode(code);
                    if (idx == -1) {
                        System.out.println("Product code not found.");
                        break;
                    }

                    System.out.print("Enter quantity to add: ");
                    while (!stdIn.hasNextInt()) {
                        System.out.println("Invalid input. Enter a positive number.");
                        stdIn.nextLine();
                    }
                    int qty = stdIn.nextInt();
                    stdIn.nextLine();

                    if (qty <= 0) {
                        System.out.println("Quantity must be positive.");
                    } else {
                        productStock[idx] += qty;
                        System.out.println("Succesfully Restocked " + qty + " units of " + productNames[idx]);
                    }
                    break;

                case 0:
                    System.out.println("Returning to main menu...\n");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}
