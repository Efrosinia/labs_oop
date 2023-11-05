package org.example.Calculator;

import java.util.Objects;

import java.util.regex.Pattern;
import java.util.Arrays;
public class StringCalculator {
    public int add(String numbers) throws IncorrectInput {

        String copynumbers=numbers;
        StringBuilder Incorchars= new StringBuilder();
        StringBuilder NegativeNum= new StringBuilder();
        String delimiter="";
        Boolean check=false;
        String SpecDelimiter="";


        int count=0;

        if (numbers.isEmpty())
        {
            return 0;
        }
        if(numbers.charAt(0)=='/' && numbers.charAt(1)=='/')
        {
            check=true;
            if (Character.isDigit(numbers.charAt(2)))
            {
                throw new IncorrectInput("your expression does not match the pattern //[delimiter]\\n[numbers...].");
            }
            if(numbers.charAt(2)=='[')
            {
                for (int i = 2; i < numbers.length(); i++)
                {
                    if (numbers.charAt(i)=='[')
                    {
                        count++;
                    }

                    if(numbers.contains("]"))

                    {
                        if(numbers.charAt(i)=='\n')
                            break;

                        if(numbers.charAt(i)==']')
                        {
                            SpecDelimiter+=",";
                        }
                        if(numbers.charAt(i+1)!=']' && numbers.charAt(i+1)!='[')
                        {
                            SpecDelimiter+=numbers.charAt(i+1);
                        }
                        if (numbers.charAt(i)==']' && numbers.charAt(i+1)!='[' && !Character.isDigit(numbers.charAt(i+2)))
                        {
                            throw new IncorrectInput("your expression does not match the pattern //[delimiter]\\n[numbers...].");
                        }

                    }

                    else
                    {
                        throw new IncorrectInput("your expression does not match the pattern //[delimiter]\\n[numbers...].");
                    }
                }
                numbers=numbers.substring(2+SpecDelimiter.length()+count);
                String[] Array_del= SpecDelimiter.split(",");
                int[] DelLen = new int[SpecDelimiter.split(",").length];
                for(int i = 0; i < Array_del.length; i++)
                {
                    DelLen[i]=Array_del[i].length();
                }
                Arrays.sort(DelLen);
                for(int i = Array_del.length-1; i>=0; i--)
                {
                    for(String del: Array_del)
                    {
                        if(del.length()==DelLen[i])
                        {
                            numbers=numbers.replaceAll(Pattern.quote(del),",");
                        }
                    }
                }

            }
            else
            {
                delimiter=String.valueOf(numbers.charAt(2));
                numbers=numbers.substring(4);
            }

        }
        if (numbers.contains("\n,") || numbers.contains(",\n"))
        {
            if(check)
            {
                throw new IncorrectInput("your expression does not match the pattern //[delimiter]\\n[numbers...].");
            }
            throw new IncorrectInput("you cannot enter mathematical expressions \\n, and ,\\n ");
        }

        String[] numberArray = numbers.split("[" + Pattern.quote(delimiter) + ",\n]");
        int sum = 0;

        for (String num : numberArray) {
            if (num.isEmpty())
            {
                if(check)
                {
                    throw new IncorrectInput("your expression does not match the pattern //[delimiter]\\n[numbers...].");
                }
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
            if(numb>1000)
            {
                numb=0;
            }
            sum += numb;
        }

        return sum;
    }


}
