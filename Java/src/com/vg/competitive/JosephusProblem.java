package com.vg.competitive;

import java.util.ArrayList;
import java.util.List;

/**
 * There are n people standing in a circle waiting to be executed.
 * The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
 * In each step, a certain number of people are skipped and the next person is executed.
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed),
 * until only the last person remains, who is given freedom.
 */
public class JosephusProblem {

    public static void main(String args[]){
        JosephusProblem jsp = new JosephusProblem();
        int n = 41, k = 3;
//        int freed = jsp.findTheFreed(n,k);
        int freed = jsp.execute(n,k);
        System.out.println("Freed person : " + freed);
    }

    private int findTheFreed(int n, int k) {
        if(n<=1){
            System.out.println("Killing person at " + k + " in " + (n-1) + " people" );
            return n;
        }
        System.out.println("Killing person at " + k + " in " + (n-1) + " people" );
        return (findTheFreed(n-1,k) + k) % n;
//        return (findTheFreed(n-1,k) + k - 1) % n;
//        return (findTheFreed(n-1,k) + k - 1) % n + 1;
    }

    private int iterativeMethod(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }

    private Integer execute(int n, int k) {
        int killIndex = 0;
        List<Integer> prisoners = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order : ");
        while( prisoners.size() > 1) {
            killIndex = (killIndex + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killIndex) + " ");
            prisoners.remove(killIndex);
        }
        System.out.println();
        return prisoners.get(0);
    }

    private List<Integer> executeAllButM(int n, int k, int m) {
        int killIndex = 0;
        List<Integer> prisoners = new ArrayList<>(n);

        for(int i = 0; i < n; i++) {
            prisoners.add(i);
        }
        System.out.println("Prisoners executed in order : ");
        while (prisoners.size() > m) {
            killIndex = (killIndex + k - 1) % prisoners.size();
            System.out.print(prisoners.get(killIndex) + " ");
            prisoners.remove(killIndex);
        }
        System.out.println();
        return prisoners;

    }
}
