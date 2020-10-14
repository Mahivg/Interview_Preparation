package com.vg.competitive;

public class WaterTrappingProblem {

    public static void main(String[] args){


        int[] traps = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        WaterTrappingProblem wtp = new WaterTrappingProblem();
        int savings = wtp.findSavings(traps, traps.length-1);

        System.out.println("Total Savings : " + savings);

    }

    private int findSavings(int[] traps, int n) {

        int left_max = 0 , right_max = 0;

        int low = 0, high = n;

        int result = 0;

        while(low <= high){

            if(traps[low] < traps[high]){
                if(traps[low] > left_max){
                    left_max = traps[low];
                }
                else{
                    result += left_max - traps[low];
                    low++;
                }
            }else{
                if(traps[high] > right_max){
                    right_max = traps[high];
                }
                else {
                    result += right_max - traps[high];
                    high--;
                }
            }
        }

        return result;
    }
}
