package com.vg.competitive;

import java.util.Arrays;

public class MaxProfitOnK {

    public static void main(String[] args) {

        MaxProfitOnK mp = new MaxProfitOnK();
        int[] prices = {2, 5, 7, 1, 4, 3, 1, 3};
        int k  = 3;
        mp.findMaxProfitOnK(prices, k);
    }

    private void findMaxProfitOnK(int[] prices, int k) {
        int t[][] = new int[k+1][prices.length]; // Array to keep transactions

        for (int i = 1; i < t.length; i++) {
            int maxDiff = -prices[0];

            for(int j = 1; j < t[0].length; j++){
//                 Either without transaction with previous highest profit, or
//                 new profit by difference + price on that day
                t[i][j] = Math.max(maxDiff+ prices[j], t[i][j-1]);
//                Updating maxDiff by comparing with previous transaction profit
                maxDiff = Math.max(maxDiff, t[i-1][j] - prices[j]);
            }
        }

        for (int i = 0; i < t.length ; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        System.out.println("Max Profit : " + t[k][prices.length-1]);
    }

}
