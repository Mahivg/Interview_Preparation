package com.vg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayOperations {
    public static void main(String args[]) {
        ArrayOperations arOps = new ArrayOperations();

        int[] sumArray = {1,2,3,4,5,6,8};
        int n = 8; // end number
        int totalSum = Arrays.stream(sumArray).sum();
        int expectedSum = (n * (n + 1))/2;
//        System.out.println("The sum is " + expectedSum);
        // To find only one missing number
        System.out.println("*** Missing element in ordered array ***");
        System.out.println(String.format("Missing element in given array %s is %s ", Arrays.toString(sumArray), expectedSum - totalSum ));

//        Finding Largest and Smallest element in unsorted array
        System.out.println("*** Largest and Smallest element in Array ***");
        int[] unSortedArray = {10, 3, 5 ,8, -1, 2, 9, 4};
        arOps.findLargestAndSmallest(unSortedArray);

//        Find pairs of element which is equal to given sum
//        Here for given array find unique pair of elements which give sum as 7
        System.out.println("*** Finding sum of pairs ***");
        int[] pairArray = {2, 4, 3, 5, 7, 8, 9};
        int pairSum = 7;
        arOps.findPairsForSum(pairArray, pairSum);

        System.out.println("*** Rotating array given k times ***");
        int[] rotateInputArray = {1,2,3,4,5,6,7,8};
        int k = 3;
        System.out.println("Array before rotating : " + Arrays.toString(rotateInputArray));
        // Clock wise or Right rotate
        arOps.rotateClockWise(rotateInputArray, k);
        System.out.println("Array after rotating right "  + k + " times : "+ Arrays.toString(rotateInputArray));
        // Anti-clock wise or left rotate
        arOps.rotateAntiClockWise(rotateInputArray, k);
        System.out.println("Array after rotating left "  + k + " times : "+ Arrays.toString(rotateInputArray));

        System.out.println("*** Reversing Array ***");
        int[] revInput = {1,2,3,4,5,6,7};
        System.out.println("Array Before Reverse : " + Arrays.toString(revInput));
        arOps.reverseArray(revInput);
        System.out.println("Array After Reverse : " + Arrays.toString(revInput));

        System.out.println("*** Combine Two Array ***");
        int[] array1 = {1,2,3,4};
        int[] array2 = {5,6,7,8};
        int[] combinedArray = arOps.combineTwoArray(array1,array2);
        System.out.println(String.format("Result of combining array %s and %s is %s", Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(combinedArray)));

        int[] L = {1,9,13, 21};
        int[] R = {15, 12,20,30};
        // Reference https://www.geeksforgeeks.org/maximum-occurred-integer-n-ranges/
        arOps.findMaximumOccurredInteger(n,L,R);

    }

    private int[] combineTwoArray(int[] array1, int[] array2) {

//      Using library
//      If you have org.apache.commons.lang.ArrayUtils then use ArrayUtils.addAll(array1, array2)
//      also we can use Guava's ObjectArrays like ObjectArrays.concat(array1, array2, Integer.class)

//        Using JDK method
        int length = array1.length + array2.length;
        int[] combinedArray = new int[length];
        System.arraycopy(array1, 0, combinedArray,0, array1.length);
        System.arraycopy(array2,0, combinedArray, array1.length, array2.length);
        return combinedArray;
    }

    private void reverseArray(int[] revInput) {

//        Using library
//        If you have org.apache.commons.lang.ArrayUtils then you can use ArrayUtils.reverse(iArray);

//        In Place (Without using any other object)
//        Two pointer method
//        Instead of int use Object to make this method Generic
        for(int i = 0; i <revInput.length / 2; i++) {
            int temp = revInput[i];
            revInput[i] = revInput[revInput.length-i-1];
            revInput[revInput.length-i-1] = temp;
        }
    }

    private void rotateAntiClockWise(int[] rotateInputArray, int k) {
        if(k<= 1) {
            return;
        }
        k = k % rotateInputArray.length;
        for(int i = 0; i<k; i++) {
            rotateAntiClockWiseOnce(rotateInputArray);
        }
    }

    private void rotateAntiClockWiseOnce(int[] rotateInputArray) {
        int first = rotateInputArray[0];
        for(int i = 0; i< rotateInputArray.length-1; i++){
            rotateInputArray[i] = rotateInputArray[i+1];
        }
        rotateInputArray[rotateInputArray.length-1] = first;
    }

    private void rotateClockWise(int[] rotateInputArray, int k) {

        if(k<= 1) {
            return;
        }
        k = k % rotateInputArray.length;
        for(int i = 0; i<k; i++) {
            rotateClockWiseOnce(rotateInputArray);
        }
//        for(int i = 0; i<rotateInputArray.length; i++) {
//            System.out.print(rotateInputArray[(rotateInputArray.length - k + i) % rotateInputArray.length]);
//        }
    }

    private void rotateClockWiseOnce(int[] rotateInputArray) {
        int last = rotateInputArray[rotateInputArray.length - 1];
        for(int j = rotateInputArray.length - 2; j>=0;j--){
            rotateInputArray[j+1] = rotateInputArray[j];
        }
        rotateInputArray[0] = last;
    }

    private void findPairsForSum(int[] inputArray, int sum) {
//        Brute Force method
//        for(int i = 0; i <inputArray.length; i++) {
//            for(int j = i+1; j<inputArray.length; j++) {
//                if(inputArray[i] + inputArray[j] == sum) {
//                    System.out.println(String.format("Element %d and %d makes sum %d", inputArray[i], inputArray[j], sum));
//                    break;
//                }
//            }
//        }

//        Using Collections
//        Set<Integer> pairSet = new HashSet<>(inputArray.length);
//        for(Integer elem1 : inputArray) {
//            int elem2 = sum-elem1;
//            if(pairSet.contains(elem2)) {
//                System.out.println(String.format("Element %d and %d makes sum %d", elem1, elem2, sum));
//            } else {
//                pairSet.add(elem1);
//            }
//        }

//        Using two pointers
        Arrays.sort(inputArray);
        int start = 0;
        int end = inputArray.length - 1;

        while(start < end) {
            int target = inputArray[start] + inputArray[end];
            if(target == sum) {
                System.out.println(String.format("Element %d and %d makes sum %d", inputArray[start], inputArray[end], sum));
                start++;
                end--;
            }else if(target < sum) {
                start++;
            }else if(target > sum) {
                end--;
            }
        }
    }

    private void findLargestAndSmallest(int[] array) {
        int smallest = array[0];
        int largest = array[0];
        for(int i = 1; i<array.length; i++) {
            if(largest < array[i]) {
                largest = array[i];
            }
            if(smallest > array[i]) {
                smallest = array[i];
            }
        }
        System.out.println("Largest : " + largest);
        System.out.println("Smallest : " + smallest);
    }
    private void findMaximumOccurredInteger(int n, int[] l, int[] r) {

        int MAX = 1000;

        int[] arr = new int[MAX];

        for(int i = 0; i<n; i++){
            arr[l[i]] +=1;
            arr[r[i] + 1] -=1;
        }
        System.out.println(Arrays.toString(arr));
        int mSum = arr[0];
        int ind = 0;
        for(int i = 1; i<MAX; i++){
            arr[i] += arr[i-1];

            if(mSum < arr[i]){
                mSum = arr[i];
                ind = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Index : " + ind);
    }
}
