package org.example;

import org.example.Calculator.IncorrectInput;
import org.example.Calculator.StringCalculator;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IncorrectInput {
        String Line= "1,2,3";
        StringCalculator Object= new StringCalculator();
        System.out.println("Result: "+Object.add(Line));

    }
}