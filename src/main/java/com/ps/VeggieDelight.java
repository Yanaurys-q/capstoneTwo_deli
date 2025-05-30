package com.ps;

public class VeggieDelight extends Sandwich
{
    public VeggieDelight() {
        super(Size.EIGHT, Bread.WHEAT, false);
        addTopping(new Regular("Lettuce", 1));
        addTopping(new Regular("Tomato", 1));
        addTopping(new Regular("Cucumber", 1));
        addTopping(new Regular("Avocado", 1));
    }

    @Override
    public String getName() {
        return "Veggie Delight";
    }
}
