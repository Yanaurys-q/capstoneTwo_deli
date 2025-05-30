package com.ps;

public class PhillyCheeseSteak extends Sandwich
{
    public PhillyCheeseSteak() {
        super(Size.EIGHT, Bread.WHITE, true);
        addTopping(new Premium("Steak", 1));
        addTopping(new Premium("American Cheese", 1));
        addTopping(new Regular("Peppers", 1));
        addTopping(new Regular("Mayo", 1));
    }

    @Override
    public String getName() {
        return "Philly Cheese Steak";
    }
}