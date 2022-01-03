package com.company;

public class KISpieler extends Spieler{
    public KISpieler(Integer farbe, Integer nummer)
    {
        super(farbe, nummer);
    }

    @Override
    public Figur auswaehlen() {
        return null;
    }
}
