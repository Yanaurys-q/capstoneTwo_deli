package com.ps;

public class Drink extends Product {
    public enum Size { SMALL, MEDIUM, LARGE }
    private String flavor;
    private Size size;

    public Drink(String flavor, Size size)
    {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public String getName() { return size + " " + flavor + " Drink"; }
    @Override
    public double getPrice()
    {
        return switch (size)
        {
            case SMALL -> 1.50;
            case MEDIUM -> 2.00;
            case LARGE -> 2.50;
        };
    }
    @Override
    public String getDetails() { return getName(); }
}