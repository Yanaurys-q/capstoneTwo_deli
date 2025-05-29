package com.ps;

public class Chip extends Product {
    private String flavor;
    private double price;

    public Chip(String flavor)
    {
        this.flavor = flavor;
        this.price = 1.50;
    }

    @Override
    public String getName() { return "Chips (" + flavor + ")"; }
    @Override
    public double getPrice() { return price; }
    @Override
    public String getDetails() { return getName(); }
}
