package org.example.Calculator;

import java.util.Objects;

public class StringCalculator {
    public int add(String numbers) throws IncorrectInput {
        StringBuilder Incorchars= new StringBuilder();

        if (numbers.isEmpty() ) {
            return 0;
        }
        if (numbers.contains("\n,") || numbers.contains(",\n"))
        {
            throw new IncorrectInput("you cannot enter mathematical expressions \\n, and ,\\n ");
        }
        String[] numberArray = numbers.split("[,\n]");
        int sum = 0;

        for (String num : numberArray) {
            if (num.isEmpty())
            {
                throw new IncorrectInput("you cannot enter mathematical expression: "+numbers.replace("\n", "\\n"));
            }
            if (!num.matches("-?\\d+") )
            {
                Incorchars.append(num.replaceAll("-?\\d+", ""));
            }
            String [] isNumber = num.split("-");
            int count=0;
            for(String i: isNumber)
            {
                if(!Objects.equals(i, ""))
                {
                    count++;
                }
                if (count>1)
                {
                    throw new IncorrectInput("you cannot enter mathematical expression: "+num);
                }
            }
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
