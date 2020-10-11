import java.util.Arrays;

public class RearrangeArray {

    public static void main(String[] args){

        RearrangeArray ra = new RearrangeArray();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        ra.reArrangeSortedArray(arr);

        int[] arr2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};

        ra.reArrangeUnContinuousElements(arr2, arr2.length);

        int[] arr3 = {3, 2, 0, 1};

        ra.reArrangeAofItoAofAofI(arr3, arr3.length);

        int[] arr4 = {34, 8, 10, 3, 2, 80,30,33,1};

        ra.findMaxDiffBWIandJ(arr4, arr4.length);

    }

    private void findMaxDiffBWIandJ(int[] arr4, int length) {

        int i = 0;
        int j = length-1;
        int mid = length/2;
        int diff = 0;

        for(int k=0; k<mid; k++){

//            if(arr4[i] <= arr4[j]){
//
//                if(j-i > diff) {
//                    diff = j - i;
//                    System.out.println("Assigning diff with i " + i + " , j "+ j);
//                }
//            }
//            i++;
//            j--;
            i = k;

            while(arr4[i]>arr4[j] && i<j){

                i++;
                j--;
            }
            if(j-i > diff) {
                diff = j - i;
                System.out.println("Assigning diff with i " + i + " , j "+ j);
            }
        }

        System.out.println("Max j = i : " + diff);
    }

    private void reArrangeAofItoAofAofI(int[] arr3, int length) {

        for(int i = 0; i<length; i++){

            arr3[i] += (arr3[arr3[i]] % length) * length;
        }
        for(int i = 0; i<length; i++){

            arr3[i] /= length;
        }

        System.out.println(Arrays.toString(arr3));

    }

    private void reArrangeUnContinuousElements(int[] arr2, int length) {

//        int minElement = arr2[0];
//        int maxElement = arr2[length-1] + 1;
//        int minIndex = 0;
//        int maxIndex = length-1;
//
//        for(int i = 0; i<length; i++){
//            if(i % 2 == 0){
//                arr2[i] += arr2[maxIndex] % maxElement * maxElement;
//                maxIndex--;
//            }else{
//                arr2[i] += (arr2[minIndex] % maxElement) * maxElement;
//                minIndex++;
//            }
//        }
//
//        for(int i = 0; i<length; i++){
//            System.out.print(arr2[i]/maxElement + " ");
//        }
        //System.out.println(Arrays.toString(arr2));

        int i;
        for(int k =0; k<length; k++){
            int j = k;
            if(arr2[k] > 0){
                do{
                    if(j%2 == 0){
                        i = (length - 1) - (j/2);
                    }else{
                        i = (j-1)/ 2;
                    }
                    if(i != k){
                        swap(arr2, i , j);
                        System.out.println("Swapping i = "+ i + " , j = " + j);
                    }
                    arr2[j] = -1*arr2[j];
                    System.out.println("Made negative for " + arr2[j]);
                    j = i;
                }while (j != k);
            }
        }

        System.out.println(Arrays.toString(arr2));

    }

    private void swap(int[] array, int src, int dest) {

        int temp = array[src];
        array[src] = array[dest];
        array[dest] = temp;
    }

    private void reArrangeSortedArray(int[] arr) {

        int n = arr.length;
        int maxElem = arr[n-1];
        int minElem = arr[0];

        for(int i=0; i < n; i++){

            if(i%2 == 0){
                arr[i] = maxElem;
                maxElem -= 1;
            }
            else{
                arr[i] = minElem;
                minElem += 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
