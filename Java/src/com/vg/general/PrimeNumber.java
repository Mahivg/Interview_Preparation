package com.vg.general;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String args[]) {

        System.out.println("*** Prime Number ***");
        System.out.println("Enter the number : ");
        int number = new Scanner(System.in).nextInt();

//        boolean isPrime = checkNumberIsPrimeOrNot(number);
//        System.out.println(String.format("The number %d is %s", number, (isPrime? "prime" : "Not a Prime")));

        System.out.println("Printing prime numbers within range : ");
        IntStream.range(1, number).forEach(n -> {
            System.out.println(String.format("The number %d is %s", n, (checkNumberIsPrimeOrNot(n)? "prime" : "Not a Prime")));
        });
    }

    private static boolean checkNumberIsPrimeOrNot(int number) {
        boolean isPrime = true;
        if(number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for(int i = 3; i<sqrt; i+= 2) {
            if(number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
