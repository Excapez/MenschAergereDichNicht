package com.company;

public class MenschSpieler extends Spieler{
    public MenschSpieler(Integer farbe, Integer nummer, String name)
    {
        super(farbe, nummer, name);
    }

    @Override
    public Figur auswaehlen() {
        return null;
    }
}
