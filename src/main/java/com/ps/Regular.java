package com.ps;

public class Regular extends Topping
{
    public Regular(String name, int quantity)
    {
        super(name, quantity);
    }
    @Override
    public double getUnitPrice() { return 0.50; }
}
