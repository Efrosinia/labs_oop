package org.example.Calculator;

public class IncorrectInput extends Exception
{
    public IncorrectInput(String message)
    {
        super("Input error: " + message);
    }
}
