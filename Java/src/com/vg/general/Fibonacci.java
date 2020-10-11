package com.vg.general;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String args[]) {

        System.out.println("**** Fibonacci Series **** ");

        System.out.println("Enter the number : ");

        int number = new Scanner(System.in).nextInt();

        if(number == 0 ) {
            System.out.println(" For Zero fibonacci cannot be computed...");
        } else {
//           int fibonacci = getFibonacciWithLoop(number);
           int fibonacci = getFibonacciWithRecursion(number);

            System.out.println(String.format("Fibonacci for number %d is %d", number, fibonacci));

        }
    }

    private static int getFibonacciWithRecursion(int number) {
        if(number == 1 || number == 2) {
            return 1;
        }
        return getFibonacciWithRecursion(number-2) + getFibonacciWithRecursion(number - 1);
    }

    private static int getFibonacciWithLoop(int number) {

        if(number == 1 || number == 2) {
            return 1;
        }
        int fib1 = 1, fib2 = 1, fibonacci = 1;

        for(int i = 3; i <= number; i++ ) {
            fibonacci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonacci;
        }
        return fibonacci;
    }
}
