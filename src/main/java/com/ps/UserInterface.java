package com.ps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class UserInterface
{
    private static Scanner scanner = new Scanner(System.in);

    public static void init()
    {
        display();
    }

    public static void display()
    {
        int mainMenuCommand;
        do {

            DeliColor.printWelcome();
            System.out.println("1) Start New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");
            mainMenuCommand = scanner.nextInt();

            switch (mainMenuCommand) {
                case 1:
                    displayOrderMenu();
                    break;
                case 0:
                    DeliColor.printReceiptArt();
                    break;
                default:
                    System.out.println("Invalid command, try again");
            }
        } while (mainMenuCommand != 0);
    }

    private static void displayOrderMenu()
    {
        scanner.nextLine();
        System.out.print("Please enter your name: ");
        String customerName = scanner.nextLine();

        Order order = new Order();

        int orderMenuInput;

        do
        {
            DeliColor.printMenuArt();
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Signature Sandwich");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Chips");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Command: ");
            orderMenuInput = getIntInput(0, 5);

            switch (orderMenuInput)
            {
                case 1:
                    DeliColor.printSandwichArt();
                    Sandwich sandwich = buildSandwich();
                    order.addProduct(sandwich);
                    TextEffects.typewriterEffect("Sandwich added!");
                    break;
                case 2:
                    DeliColor.printSelectSandwichArt();
                    Sandwich signatureSandwich = chooseSignatureSandwich();
                    if (signatureSandwich != null) {
                        order.addProduct(signatureSandwich);
                        TextEffects.typewriterEffect("Signature Sandwich added!");
                    }
                    break;
                case 3:
                    DeliColor.printDrinkArt();
                    Drink drink = buildDrink();
                    order.addProduct(drink);
                    TextEffects.typewriterEffect("Drink added!");
                    break;
                case 4:
                    DeliColor.printChipsArt();
                    Chip chip = buildChip();
                    order.addProduct(chip);
                    TextEffects.typewriterEffect("Chips added!");
                    break;
                case 5:
                    handleCheckout(order, customerName);
                    return;
                case 0:
                    TextEffects.typewriterEffect("Order cancelled. Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid command, try again");
            }
        } while (true);
    }

    private static Sandwich chooseSignatureSandwich()
    {
        int choice;
        do {
            System.out.println("Choose a Signature Sandwich:");
            System.out.println("1) BLT");
            System.out.println("2) Philly Cheese Steak");
            System.out.println("3) Veggie Delight");
            System.out.println("4) Chicken Club");
            System.out.println("0) Back to Order Menu");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            Sandwich sandwich = null;
            switch (choice) {
                case 1:
                    sandwich = new BLT();
                    break;
                case 2:
                    sandwich = new PhillyCheeseSteak();
                    break;
                case 3:
                    sandwich = new VeggieDelight();
                    break;
                case 4:
                    sandwich = new ChickenClub();
                    break;
                case 0:
                    return null;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            if (sandwich != null)
            {
                TextEffects.typewriterEffect("You chose: " + sandwich.getName());
                System.out.println(sandwich.getDetails());
                customizeSandwich(sandwich);
                return sandwich;
            }
        } while (choice != 0);

        return null;
    }

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


    private static Sandwich buildSandwich()
    {
        System.out.println("Choose sandwich size:");
        System.out.println("1) 4\"");
        System.out.println("2) 8\"");
        System.out.println("3) 12\"");
        Sandwich.Size size = switch (getIntInput(1, 3))
        {
            case 1 -> Sandwich.Size.FOUR;
            case 2 -> Sandwich.Size.EIGHT;
            case 3 -> Sandwich.Size.TWELVE;
            default -> Sandwich.Size.FOUR;
        };

        System.out.println("Choose bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");

        Sandwich.Bread bread = switch (getIntInput(1, 4))
        {
            case 1 -> Sandwich.Bread.WHITE;
            case 2 -> Sandwich.Bread.WHEAT;
            case 3 -> Sandwich.Bread.RYE;
            case 4 -> Sandwich.Bread.WRAP;
            default -> Sandwich.Bread.WHITE;
        };

        System.out.print("Would you like your sandwich toasted? (y/n): ");
        boolean toasted = scanner.next().trim().toLowerCase().startsWith("y");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        ToppingManager.addTopping(sandwich);

        return sandwich;
    }

    private static Drink buildDrink() {
        System.out.println("Choose drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        Drink.Size size = switch (getIntInput(1, 3)) {
            case 1 -> Drink.Size.SMALL;
            case 2 -> Drink.Size.MEDIUM;
            case 3 -> Drink.Size.LARGE;
            default -> Drink.Size.SMALL;
        };

        String[] flavors = {"Coke", "Lemonade", "Iced Tea", "Sprite"};
        System.out.println("Choose drink flavor:");
        for (int i = 0; i < flavors.length; i++)
            System.out.println((i + 1) + ") " + flavors[i]);
        String flavor = flavors[getIntInput(1, flavors.length) - 1];

        return new Drink(flavor, size);
    }

    private static Chip buildChip()
    {
        String[] chips = {"Classic", "BBQ", "Sour Cream", "Salt & Vinegar"};
        System.out.println("Choose chip flavor:");
        for (int i = 0; i < chips.length; i++)
            System.out.println((i + 1) + ") " + chips[i]);
        String flavor = chips[getIntInput(1, chips.length) - 1];
        return new Chip(flavor);
    }

    private static void handleCheckout(Order order, String customerName)
    {
        System.out.println("\nChecking out for " + customerName + "...");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(formatter);

        String filename = timestamp + ".txt";


        System.out.println(order.getOrderDetails());
        FileManager fm = new FileManager();
        fm.saveOrder(order, filename, customerName);
        System.out.println("Receipt successfully printed as " + filename + ". Enjoy your meal, " + customerName + "!");
    }


    private static int getIntInput(int min, int max)
    {
        int val;
        while (true) {
            try {
                val = Integer.parseInt(scanner.next());
                if (val >= min && val <= max) return val;
            } catch (Exception ignored) {}
            System.out.print("Please enter a number between " + min + " and " + max + ": ");
        }
    }
}