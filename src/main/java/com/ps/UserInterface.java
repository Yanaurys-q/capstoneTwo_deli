package com.ps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class UserInterface
{
    private static Scanner scanner = new Scanner(System.in);

    public static void init() {
        display();
    }

    public static void display()
    {
        int mainMenuCommand;
        do {
            System.out.println("--------Welcome to DELI-cious Sandwich Shop!--------");
            System.out.println("1) Start New Order");
            System.out.println("0) Exit");
            System.out.print("Command: ");
            mainMenuCommand = getIntInput(0, 1);

            switch (mainMenuCommand) {
                case 1:
                    displayOrderMenu();
                    break;
                case 0:
                    System.out.println("Exiting... Stay tasty!");
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
            System.out.println("\n--------Order Menu--------");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Command: ");
            orderMenuInput = getIntInput(0, 4);

            switch (orderMenuInput)
            {
                case 1:
                    Sandwich sandwich = buildSandwich();
                    order.addProduct(sandwich);
                    System.out.println("Sandwich added!");
                    break;
                case 2:
                    Drink drink = buildDrink();
                    order.addProduct(drink);
                    System.out.println("Drink added!");
                    break;
                case 3:
                    Chip chip = buildChip();
                    order.addProduct(chip);
                    System.out.println("Chips added!");
                    break;
                case 4:
                    handleCheckout(order, customerName);
                    return;
                case 0:
                    System.out.println("Order cancelled. Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid command, try again");
            }
        } while (true);
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

        scanner.nextLine();
        ArrayList<Topping> toppings = new ArrayList<>();
        String[] regulars = {"Lettuce", "Tomato", "Onion", "Pickles","Cheddar", "Swiss"};
        String[] premiums = {"Turkey", "Ham", "Roast Beef"};

        System.out.println("Add regular toppings (each $0.50). Enter quantity for each (0 for none):");
        for (String reg : regulars) {
            System.out.print(reg + ": ");
            int qty = getIntInput(0, 5);
            if (qty > 0) toppings.add(new Regular(reg, qty));
        }

        System.out.println("Add premium toppings (each $1.00). Enter quantity for each (0 for none):");
        for (String prem : premiums) {
            System.out.print(prem + ": ");
            int qty = getIntInput(0, 5);
            if (qty > 0) toppings.add(new Premium(prem, qty));
        }

        for (Topping t : toppings) sandwich.addTopping(t);

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