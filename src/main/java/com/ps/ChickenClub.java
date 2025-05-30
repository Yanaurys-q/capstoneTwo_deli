package com.ps;

public class ChickenClub extends Sandwich
{
    public ChickenClub() {
        super(Size.EIGHT, Bread.WHITE, true);
        addTopping(new Premium("Grilled Chicken", 1));
        addTopping(new Premium("Bacon", 1));
        addTopping(new Regular("Lettuce", 1));
        addTopping(new Regular("Tomato", 1));
        addTopping(new Regular("Mayo", 1));
    }

    @Override
    public String getName() {
        return "Chicken Club";
    }
}

