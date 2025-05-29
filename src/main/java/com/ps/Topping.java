package com.ps;

public abstract class Topping
{
    protected String name;
    protected int quantity;

    public Topping(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public abstract double getUnitPrice();
    public double getPrice() { return getUnitPrice() * quantity; }
}