package com.vg;

import java.util.*;
import java.util.stream.Collectors;

public class StringOperations {

    public static void main(String args[]) {
        StringOperations strOps = new StringOperations();
        String nonRepeatedString = "abcdefjgha";
        Character c = strOps.findFirstNonRepeatingCharacter(nonRepeatedString);
        System.out.printf("First Non repeated character in String %s is %c \n" , nonRepeatedString, c);

        // Same characters with different positions
        boolean isAnagram = strOps.checkAnagramStrings("stop", "tops");
        System.out.println("isAnagram? : " + isAnagram);
        
        // Find the string is rotated String
        // input 'ingprogramm' is rotated string of given string 'programming'
        boolean isRotatedString = strOps.checkStringEqualsToRotated("programming", "ingprogramm");
        System.out.println("The given string is a rotated string? : " + (isRotatedString? "Yes" : "No") );

        // Reverse the string without library (recursion / iteration)
        String revStrInput = "Magesh";
        // Prepare for how to reverse words using split and join (https://www.baeldung.com/java-join-and-split)
        String revStr = strOps.reverseString(revStrInput);
        // Reusing the same method to find whether the string is Palindrome or Not
        System.out.println(String.format("The String %s === %s, is %s ", revStrInput, revStr, (revStrInput.equalsIgnoreCase(revStr) ? "Palindrome" : "Not a palindrome")));
        System.out.println(String.format("The Given String %s's reverse is %s " , revStrInput, revStr));

        strOps.printCharacterCountInString("Lorum epsum");
        strOps.printGivenCharacterCount("Today is good day.", 'o');

//        write a program which return
//                "fizz" if the number is a multiplier of 3,
//                return "buzz" if its multiplier of 5
//                and return "fizzbuzz" if the number is divisible by both 3 and 5.
//        If the number is not divisible by either 3 or 5 then it should just return the number itself.
        strOps.printFizzBuzz(45);

        // Regular expression pattern to test input is only Digits
        String regex = "(.)*(\\d)(.)*";

    }

    private void printFizzBuzz(int num) {
        if(num % (3 * 5) == 0) {
            System.out.println("fizzbuzz");
        } else if(num % 3 == 0) {
            System.out.println("fizz");
        } else if(num % 5 == 0) {
            System.out.println("buzz");
        } else {
            System.out.println(String.valueOf(num));
        }
    }

    private void printCharacterCountInString(String inputStr) {
        System.out.println("*** Printing Character Count ***");

        Map<Character, Integer> inputMap = new HashMap<>(inputStr.length());
        for(char c : inputStr.toCharArray()) {
            if(inputMap.containsKey(c)) {
                inputMap.put(c, inputMap.get(c) + 1);
            } else {
              inputMap.put(c, 1);
            }
        }
        String output = inputMap.entrySet().stream().map(entry -> "Character: " + entry.getKey() + ",count = " + entry.getValue()).collect(Collectors.joining(", "));
        System.out.println(output);
    }

    private void printGivenCharacterCount(String input, char ch) {
//        int charCount = 0;
//        Iterative method
//        for(char c : input.toCharArray()) {
//            if(c == ch) {
//                charCount++;
//            }
//        }
//        System.out.println(String.format("The given character %c is presented in %d times in string %s", ch, charCount, input));

//        Stream API in Java 1.8
        long charCountLong =  input.chars().filter(c -> c == ch).count();
        System.out.println(String.format("The given character %c is presented in %d times in string %s", ch, charCountLong, input));
    }


    private String reverseString(String revStrInput) {

        if(revStrInput.length() < 2) {
            return revStrInput;
        }
//        ** StringBuffer/ String Builder **
//        StringBuilder sb = new StringBuilder(revStrInput);
//        return sb.reverse().toString();

//        ** Iterative Method **
//        String reverse = "";
//        for(int i = revStrInput.length()-1; i>= 0 ; i--) {
//            reverse = reverse.concat(revStrInput.charAt(i) + "");
//        }
//        return reverse;

//        *** In Place ***
//        char[] c = revStrInput.toCharArray();
//        int start = 0;
//        int end = c.length-1;
//        for(int i = 0; i < c.length/2; i++) {
//            char temp = c[start];
//            c[start] = c[end];
//            c[end] = temp;
//            start++;
//            end--;
//        }
//        return String.valueOf(c);

//        ** Recursive Method **
        return (revStrInput.substring(revStrInput.length() - 1) + reverseString(revStrInput.substring(0, revStrInput.length()-1)));
    }

    private boolean checkStringEqualsToRotated(String programming, String ingprogramm) {
        String combinedString = programming.concat(programming);
        return (combinedString.indexOf(ingprogramm) > -1);
    }

    private char findFirstNonRepeatingCharacter(String nonRepeatedString) {

        LinkedHashMap<Character, Integer> characterHashMap = new LinkedHashMap<>(nonRepeatedString.length());
        for(char c : nonRepeatedString.toCharArray()) {
            if(characterHashMap.containsKey(c)) {
                characterHashMap.put(c, characterHashMap.get(c) + 1);
            }else {
                characterHashMap.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> c : characterHashMap.entrySet()) {
            if(c.getValue() == 1) {
                return c.getKey();
            }
        }
        return '.';
    }

    private boolean checkAnagramStrings(String first, String second) {

        //Using String builder
        StringBuilder sb = new StringBuilder(second);

        for(char c : first.toCharArray()) {
            if(sb.indexOf("" + c) != -1) {
                sb.deleteCharAt(sb.indexOf("" + c));
            }
        }
        return sb.toString().isEmpty();


    }

}
