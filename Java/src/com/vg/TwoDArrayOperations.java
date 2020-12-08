package com.vg;

public class TwoDArrayOperations {

    public static void main(String[] args) {
        TwoDArrayOperations twoDArrayOps = new TwoDArrayOperations();
        int m = 5, n= 4;
        int mat[][] = {{0, 6, 8, 9, 11},
                {20, 22, 28, 29, 31},
                {36, 38, 50, 61, 63},
                {64, 66, 100, 122, 128}};
        int elementToFind = 20;

        twoDArrayOps.findElementInSortedArray(mat, m, n, elementToFind);
    }

    private void findElementInSortedArray(int[][] mat, int m, int n, int elementToFind) {
        int i = 0;
        int j = n-1;

        while(i<n && j>=0) {
            if(mat[i][j] == elementToFind) {
                System.out.println("Element found at : { " + i + " , " + j + " }" );
                break;
            }
            else if(mat[i][j] > elementToFind) {
                j--;
            }
            else {
                i++;
            }
        }
    }
}
