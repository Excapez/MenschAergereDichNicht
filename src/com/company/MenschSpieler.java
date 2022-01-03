package com.company;

public class MenschSpieler extends Spieler{
    public MenschSpieler(Integer farbe, Integer nummer)
    {
        super(farbe, nummer);
    }

    @Override
    public Figur auswaehlen() {
        return null;
    }
}
