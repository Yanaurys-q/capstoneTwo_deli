package com.ps;

import java.util.ArrayList;

public class Sandwich extends Product {
    public enum Size { FOUR, EIGHT, TWELVE }
    public enum Bread { WHITE, WHEAT, RYE, WRAP }

    private Size size;
    private Bread bread;
    private boolean toasted;
    private ArrayList<Topping> toppings;

    public Sandwich(Size size, Bread bread, boolean toasted)
    {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping)
    {
        toppings.add(topping);
    }

    @Override
    public String getName()
    {
        return sizeToString() + " " + bread.toString() + " Sandwich";
    }

    @Override
    public double getPrice()
    {
        double base = switch (size)
        {
            case FOUR -> 5.00;
            case EIGHT -> 7.00;
            case TWELVE -> 8.00;
        };
        double total = base;
        for (Topping t : toppings) total += t.getPrice();
        return total;
    }

    @Override
    public String getDetails()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(toasted ? " (Toasted)" : " (Not Toasted)").append("\n");
        for (Topping t : toppings)
            sb.append("  - ").append(t.getName()).append(" x").append(t.getQuantity()).append("\n");
        return sb.toString();
    }

    private String sizeToString()
    {
        return switch (size)
        {
            case FOUR -> "4\"";
            case EIGHT -> "8\"";
            case TWELVE -> "12\"";
        };
    }
}