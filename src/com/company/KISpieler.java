package com.company;

public class KISpieler extends Spieler{
    public KISpieler(Integer farbe, Integer nummer, String name)
    {
        super(farbe, nummer, name);
    }

    @Override
    public Figur auswaehlen() {
        return null;
    }

    /**
     * Mögliche KI:
     * Wenn 6 gewürfelt immer Figur aus Haus raus
     * Sonst wenn Zug in Ziel möglich diesen durchführen
     * Sonst wenn schmeißen anderer Figur möglich dies durchführen
     * Sonst Figur am nähesten zum Ziel ziehen
     */
}
