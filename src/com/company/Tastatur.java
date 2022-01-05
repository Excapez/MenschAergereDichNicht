package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// Diese Klasse dient dazu, Zahlen, Buchstaben und Texte von der Tastatur
// einzulesen.

public class Tastatur
{
    // Einlesen eines einzelnen Buchstabens (char).
    public static char liesZeichen()
    {
        try
        {
            return liesText().charAt(0);
        } catch (Exception e)
        {
            return ' ';
        }
    }

    // Einlesen einer Zahl (int).
    public static int liesZahl()
    {
        try
        {
            return Integer.parseInt(liesText());
        } catch (Exception e)
        {
            return -1;
        }
    }

    // Einlesen einer Kommazahl (double).
    public static double liesKommazahl()
    {
        try
        {
            return Double.parseDouble(liesText().replace(',', '.'));
        } catch (Exception e)
        {
            return 0;
        }
    }

    // Einlesen eines Textes (String).
    public static String liesText()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (Exception e)
        {
            return " ";
        }
    }

    // Wait for Enter key
    public static void waitForEnter()
    {
        System.out.println("Press Enter to continue");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {

        }
    }

}