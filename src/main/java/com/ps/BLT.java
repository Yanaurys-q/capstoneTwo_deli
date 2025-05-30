package com.ps;

public class BLT extends Sandwich
{
    public BLT() {
        super(Size.EIGHT, Bread.WHITE, true);
        addTopping(new Premium("Bacon", 1));
        addTopping(new Premium("Cheddar", 1));
        addTopping(new Regular("Lettuce", 1));
        addTopping(new Regular("Tomato", 1));
        addTopping(new Regular("Ranch", 1));
    }

    @Override
    public String getName() {
        return "BLT";
    }
}


