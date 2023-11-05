package org.example.Calculator;

import java.util.Objects;

import java.util.regex.Pattern;
public class StringCalculator {
    public int add(String numbers) throws IncorrectInput {

        String copynumbers=numbers;
        StringBuilder Incorchars= new StringBuilder();
        StringBuilder NegativeNum= new StringBuilder();
        String delimiter="";

        if (numbers.isEmpty() )
        {
            return 0;
        }
        if(numbers.charAt(0)=='/' && numbers.charAt(1)=='/')
        {
            if (Character.isDigit(numbers.charAt(2)))
            {
                throw new IncorrectInput("the delimiter cannot be a number: the pattern //[delimiter]\\n[numbers...].");
            }
            if (numbers.charAt(3)!='\n')
            {
                throw new IncorrectInput("your expression does not match the pattern //[delimiter]\\n[numbers...].");
            }
            delimiter=String.valueOf(numbers.charAt(2));
            numbers=numbers.substring(4);
        }
        if (numbers.contains("\n,") || numbers.contains(",\n"))
        {
            throw new IncorrectInput("you cannot enter mathematical expressions \\n, and ,\\n ");
        }

        String[] numberArray = numbers.split("[" + Pattern.quote(delimiter) + ",\n]");
        int sum = 0;

        for (String num : numberArray) {
            if (num.isEmpty())
            {
                //check right here
                throw new IncorrectInput("you cannot enter mathematical expression: "+copynumbers.replace("\n", "\\n"));

            }
            if (!num.matches("-?\\d+") )
            {
                Incorchars.append(num.replaceAll("-?\\d+", ""));
            }
            if (num.contains("-"))
            {
                NegativeNum.append(num);
                NegativeNum.append(" ");
            }
        }

        if(!NegativeNum.isEmpty())
        {
            throw new IncorrectInput("input cannot contains negative numbers: "+NegativeNum);
        }

        if (!Incorchars.isEmpty())
        {
            throw new IncorrectInput("input contains non-numeric characters: "+Incorchars);
        }

        for (String num : numberArray)
        {
            int numb = Integer.parseInt(num);
            sum += numb;
        }

        return sum;
    }


}
