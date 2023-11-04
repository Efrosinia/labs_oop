package org.example.Calculator;

import java.util.Objects;

public class StringCalculator {
    public int add(String numbers) throws IncorrectInput {
        StringBuilder Incorchars= new StringBuilder();
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.contains(",,")) {
            throw new IncorrectInput("you cannot enter mathematical expressions: ,, ");
        }
        String[] numberArray = numbers.split(",");
        if(numberArray.length>2)
        {
            throw new IncorrectInput("the number of digits should be no more than two ");
        }
        int sum = 0;

        for (String num : numberArray) {
            if(num.isEmpty())
            {
                throw new IncorrectInput("you cannot enter mathematical expressions: "+ numbers);
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
                    throw new IncorrectInput("you cannot enter mathematical expressions:  "+num);
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
