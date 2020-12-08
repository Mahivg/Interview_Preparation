package com.vg;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String args[]) {
        SortingAlgorithms sortAlgms = new SortingAlgorithms();

        int[] inputArray = {4,-1,6,8,0,5,-3};
        System.out.println("*** Array before sorting ***");
        System.out.println(Arrays.toString(inputArray));
//        Quick Sort Example
        sortAlgms.doQuickSort(inputArray,0, inputArray.length - 1);
        System.out.println("*** Array after doing quick sorting ***");
        System.out.println(Arrays.toString(inputArray));
    }

    private void doQuickSort(int[] inputArray, int start, int end) {
        if(start< end) {
            int pivot = findPivot(inputArray, start,end);
            System.out.println("Pivot set to : " + pivot + " for start : " + start + " and end : " + end);
            doQuickSort(inputArray, start, pivot-1);
            doQuickSort(inputArray, pivot+1, end);
        }

    }

    private int findPivot(int[] inputArray, int start, int end) {
        int pivot = inputArray[end];
        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(inputArray[j] <= pivot) {
                i++;
                if( inputArray[i] != inputArray[j]) {
                    System.out.println("Swapping " + inputArray[i] + " and " + inputArray[j]);
                    swap(inputArray, j, i);
                }
            }
        }
        swap(inputArray, i+1, end);
        System.out.println("*** Pivot : " + pivot + " ***");
        System.out.println("*** Array current state ***");
        System.out.println(Arrays.toString(inputArray));

        return i+1;
    }
    private void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}


/**
 * Quick Sort
 *  https://javarevisited.blogspot.com/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html
 *
 */