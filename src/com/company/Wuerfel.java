package com.company;

import java.util.Random;

public class Wuerfel {
    private static Random random = new Random();

    public Wuerfel()
    {
    }

    public static Integer wuerfeln()
    {
        return random.nextInt(6)+1;
    }
}
