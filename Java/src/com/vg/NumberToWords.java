package com.vg;

import java.util.Scanner;

public class NumberToWords {
    private static String[] singleUnits = {"", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine" ,"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};
    private static String[] additionsOfTen = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = sc.nextInt();
        NumberToWords ntw = new NumberToWords();
        String numberInWords = ntw.convertNumber(number);
        System.out.println(number + " In Words : ");
        System.out.println(numberInWords.trim());
    }

    private String convertNumber(int number) {
        String result = "";

        if(number == 0) {
            return "zero";
        }
        if(number < 0) {
            String str = String.valueOf(number);
            str = str.substring(1);
            return "minus " + convertNumber(Integer.parseInt(str));
        }

        if((number / 1000000) > 0) {
            result += convertNumber(number / 1000000 ) + " million ";
            number %= 1000000;
        }
        if((number / 1000) > 0) {
            result += convertNumber(number / 1000) + " thousand ";
            number %= 1000;
        }
        if((number/ 100) > 0) {
            result += convertNumber(number/100) + " hundred ";
            number %= 100;
        }
        if(number > 0) {
            if(number < 20) {
                result += singleUnits[number%singleUnits.length];
            }else {
                result += additionsOfTen[number/10];
                if(number % 10 > 0) {
                    result += "-" + singleUnits[number%10];
                }
            }
        }
        return result;
    }
}
