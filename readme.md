

## Deli Application
This is a console-based deli management system that allows users to select and customize sandwiches, drinks, and chips.

## Features:

- Signature Sandwiches: Choose from a variety of predefined sandwiches.
- Custom Sandwiches: Build your own sandwich with a selection of toppings.
- Topping Customization: Add or remove toppings from your sandwich.
- Interactive Menu: Navigate through a user-friendly console menu.


## How it works:

Startup: The application loads and displays a welcome logo.
Main Menu: Users can choose to start a new order or exit the application.
Order Process:
Select Sandwich: Choose a signature sandwich or build a custom one.
Customize Toppings: Add or remove toppings to suit your taste.
Add Drinks and Chips: Enhance your meal with a selection of drinks and chips.
Checkout: Review your order and finalize the purchase.
Data Management: All interactions are handled in-memory, ensuring a smooth user experience.

## Interesting Code:

One interesting aspect of this project is the topping customization logic. It allows users to dynamically add or remove toppings from their sandwiches, providing a flexible and personalized experience.

    private static void customizeSandwich(Sandwich sandwich) {
    System.out.println("Would you like to customize your sandwich? (y/n)");
    String response = scanner.next();
    if (response.equalsIgnoreCase("y")) {
    boolean customizing = true;
    while (customizing) {
    System.out.println("\nCurrent toppings:");
    ArrayList<Topping> currentToppings = sandwich.getToppings();
    for (int i = 0; i < currentToppings.size(); i++) {
    System.out.println((i + 1) + ") " + currentToppings.get(i).getName());
    }

            System.out.println("\nCustomization options:");
            System.out.println("1) Add Topping");
            System.out.println("2) Remove Topping");
            System.out.println("0) Done");
            System.out.print("Choose an option: ");
            int choice = getIntInput(0, 2);

            switch (choice) {
                case 1:
                    ToppingManager.addTopping(sandwich);
                    break;
                case 2:
                    ToppingManager.removeTopping(sandwich);
                    break;
                case 0:
                    customizing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


    My Class Diagram (just for you greg)

    class Main{
    +main()
    class FileManager {
    saveOrder()
    }

    class UserInterface {
        -Order order
        +init()
        +display()
        +checkout()
    }

    class Order {
        +addProduct(Product)
        +getOrderDetails()
    }

    class Product {
        <<abstract>>
        +getPrice()
        +getName()
    }

    class Sandwich {
        -Size size
        -Bread bread
        -boolean toasted
        -ArrayList~Topping~ toppings
        +addTopping(Topping)
        +getToppings()
    }

    class Drink {
        -String flavor
        -Size size
    }

    class Chip {
        -String flavor
    }

    class Topping {
        -String name
        -int quantity
    }

    class Regular {
        -String name
        -int quantity
    }

    class Premium {
        -String name
        -int quantity
    }

    class ToppingManager {
        +addTopping(Sandwich)
        +removeTopping(Sandwich)
    }

    class DeliColor {
        +printLogo()
        +printMenuArt()
    }

    class KeanuEffect {
        +printMatrixLogo()
    }

    class BLT {
        +BLT()
    }

    class ChickenClub {
        +ChickenClub()
    }

    class PhillyCheeseSteak {
        +PhillyCheeseSteak()
    }

    class VeggieDelight {
        +VeggieDelight()
    }

    Main --> UserInterface
    UserInterface --> Order
    UserInterface --> FileManager
    Order --> Product : Has many
    Product <|-- Sandwich : Extends
    Product <|-- Drink : Extends
    Product <|-- Chip : Extends
    Sandwich --> Topping : Has many
    Topping <|-- Regular : Extends
    Topping <|-- Premium : Extends
    Sandwich <|-- BLT : Extends
    Sandwich <|-- ChickenClub : Extends
    Sandwich <|-- PhillyCheeseSteak : Extends
    Sandwich <|-- VeggieDelight : Extends


![MainMenu](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195937.png)

![CheckoutProcess](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195849.png)

![InterestingCode](../../../OneDrive/Pictures/Screenshots/Screenshot%202025-04-20%20195749.png)