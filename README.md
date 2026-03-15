## Project Title
    Pharmacy Ordering System / Botika ni Sinta Ordering System

## Description
    The Pharmacy Ordering System is a console-based Java application that simulates a simple point-of-sale ordering system for a pharmacy. It allows users to browse products, search items, add products to a shopping cart, view cart contents, apply discount codes, and complete purchases.

    The system also provides inventory management features such as low stock reporting and product restocking.

## Features
    - List available pharmacy products
    - Search products by keyword
    - Add products to a shopping cart
    - View cart items with subtotal calculation
    - Checkout with discount codes
    - Automatic stock deduction after purchase
    - Low stock reporting
    - Restock items by product code

## Technologies Used
    - Java

## Java Programming Concepts Applied
    - Loops: for (array iteration/traverse), while (menu iteration), do-while (menu iteration)
    - Conditional Statements: if-else if, switch
    - Arrays (1D, Parallel)
    - Input validation
    - Methods
    - String Manipulation (.trim(), .toUpperCase(), .toLowerCase())
    - Output Formatting through printf

## Program Structure
    The system is organized into several methods:

    Major methods: 
    - `listProducts()` – Displays all available pharmacy products.
    - `searchProduct()` – Searches products using a keyword.
    - `addToCart()` – Adds selected items to the shopping cart.
    - `viewCart()` – Displays cart contents and subtotal.
    - `checkout()` – Handles discount codes, receipt generation, and purchase confirmation.
    - `reportsAndRestock()` – Provides inventory reports and restocking functionality.

    Helper methods:
    - `tableHeader()` - Prints out the header for tables used in listing and searching products.
    - `cartHeader()` - Prints out the header for tables used in View Cart and Checkout.
    - `indexOfCode()` – Finds the index of a product using its code.
    - `isCartEmpty()` – Checks whether the cart has items.
    - `emptyCartPrint()` - Printed out as viewCart() and checkout()'s response to an empty cart request.
    - `computeSubtotal()` – Calculates the cart subtotal.
    - `printCartRows()` – Prints cart items in table format (for viewCart() & checkout() only).

## Limitations
    - The program is console-based; it does not have a graphical interface.  
    - Product data is hard-coded; new products cannot be added without modifying the code.   
    - Input validation is implemented, but if the user enters an invalid value, the program will prompt them to try again. Multiple attempts may be needed 
      before valid input is accepted.  
    - Long product names may cause misalignment in the cart or receipt table.  
    - User input spaces are only trimmed at the start and end using `.trim()`; spaces inside the string are **not removed**, so e.g., `"PAR 500"` would not match the product code `"PAR500"`.

## How to Run 
    1. Compile the Program
    2. Run the Program
    3. Follow the menu instructions displayed in the console.

## Author
    ADVINCULA, Aliyah V.  
    BSIT 2-1
    2024-000002-SR-0
