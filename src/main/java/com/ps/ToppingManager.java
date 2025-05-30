package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class ToppingManager {
    private static Scanner scanner = new Scanner(System.in);

    static void addTopping(Sandwich sandwich) {
        System.out.println("Select regular toppings (each $0.50):");
        String[] regulars = {"Lettuce", "Tomato", "Onion", "Pickles", "Cucumber", "Mayo"};
        for (int i = 0; i < regulars.length; i++) {
            System.out.println((i + 1) + ") " + regulars[i]);
        }
        System.out.print("Enter the numbers of the toppings to add (ex:1,3): ");
        String[] regChoices = scanner.next().split(",");
        for (String choice : regChoices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < regulars.length) {
                    sandwich.addTopping(new Regular(regulars[index], 1));
                }
            } catch (NumberFormatException ignored) {}
        }

        System.out.println("Select premium toppings (each $1.00):");
        String[] premiums = {"Bacon", "Turkey", "Ham", "Roast Beef", "Avocado", "Cheddar", "Swiss"};
        for (int i = 0; i < premiums.length; i++) {
            System.out.println((i + 1) + ") " + premiums[i]);
        }
        System.out.print("Enter the numbers of the toppings to add (ex:1,3): ");
        String[] premChoices = scanner.next().split(",");
        for (String choice : premChoices) {
            try {
                int index = Integer.parseInt(choice.trim()) - 1;
                if (index >= 0 && index < premiums.length) {
                    sandwich.addTopping(new Premium(premiums[index], 1));
                }
            } catch (NumberFormatException ignored) {}
        }
    }

    public static void removeTopping(Sandwich sandwich) {
        ArrayList<Topping> currentToppings = sandwich.getToppings();
        if (currentToppings.isEmpty()) {
            System.out.println("No toppings to remove.");
            return;
        }

        System.out.println("Enter the number of the topping to remove (0 to cancel):");
        for (int i = 0; i < currentToppings.size(); i++) {
            System.out.println((i + 1) + ") " + currentToppings.get(i).getName());
        }
        int removeIndex = getIntInput(0, currentToppings.size()) - 1;
        if (removeIndex >= 0) {
            Topping removed = currentToppings.remove(removeIndex);
            System.out.println("Removed: " + removed.getName());
        }
    }

    private static int getIntInput(int min, int max) {
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