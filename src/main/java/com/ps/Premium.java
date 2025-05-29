package com.ps;

public class Premium extends Topping
{
    public Premium(String name, int quantity)
    {
        super(name, quantity);
    }
    @Override
    public double getUnitPrice() { return 1.00; }
}