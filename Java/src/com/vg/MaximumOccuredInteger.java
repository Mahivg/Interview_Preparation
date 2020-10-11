import java.util.Arrays;

public class MaximumOccuredInteger {

    public static void main(String[] args){

        int[] L = {1,9,13, 21};
        int[] R = {15, 12,20,30};
        int n = L.length;
        MaximumOccuredInteger mi = new MaximumOccuredInteger();
        mi.findMaximumOccurredInteger(n,L,R);

    }

    private void findMaximumOccurredInteger(int n, int[] l, int[] r) {

        int MAX = 1000;

        int[] arr = new int[MAX];

        for(int i = 0; i<n; i++){
            arr[l[i]] +=1;
            arr[r[i] + 1] -=1;
        }

        printIntArray(arr);

        int mSum = arr[0];
        int ind = 0;
        for(int i = 1; i<MAX; i++){
            arr[i] += arr[i-1];

            if(mSum < arr[i]){
                mSum = arr[i];
                ind = i;
            }
        }
        printIntArray(arr);

        System.out.println("Index : " + ind);
    }

    private void printIntArray(int[] arr){

        System.out.println(Arrays.toString(arr));

    }
}
