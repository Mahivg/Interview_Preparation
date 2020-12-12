package com.vg;

import java.util.*;

public class StringRecursivePermutation {

    public static void main(String args[]){

        String str = "abc";
        int index = 0;
        String curr = "";

        StringRecursivePermutation sp = new StringRecursivePermutation();
        System.out.println("===== Power Set =====");
        sp.powerSet(str,index,curr);
        System.out.println("===== Permutation =====");
        sp.permute(str,0, str.length()-1);

        System.out.println("===== Subsets of String =====");
          sp.allSubsetAddOneByOne("abc","",0);
//        Finding how many combination of words we can do with the given number
        System.out.println("===== Finding Possible combination of phone number =====");
        List<String> r = sp.letterCombinations("234");
        System.out.println(r);

        int[] k = {10, 11, -1, 20, 22, -1};

        sp.checkCount(k);
    }
    public void powerSet(String str, int index, String curr){

        int n = str.length();
//        System.out.println(" *** Str :  " + str + " ***");
//        System.out.println(" *** index :  " + index + " ***");
//        System.out.println(" *** curr :  " + curr + " ***");

        if(index == n){
//            System.out.println(" *** Base Condition Met ***");
            System.out.println(str);
//            System.out.println(" ************************");
            return;
        }
        powerSet(str, index+1, curr+str.charAt(index));
//        System.out.println(" <<< Calling Next One <<<");
        powerSet(str, index+1, curr);
    }

    public void permute(String str, int left, int right){

//        System.out.println("===== Permutation =====");
//        System.out.println(" *** Str :  " + str + " ***");
//        System.out.println(" *** Left :  " + left + " ***");
//        System.out.println(" *** Right :  " + right + " ***");
        if(left == right){
//            System.out.println(" *** Base Condition Met ***");
            System.out.println(str);

        }else{
            for(int i = left; i<=right;i++){
                if( i != left) {
//                    System.out.println(" *** Swapping from " + left + " to  " + i + " ***");
                    str = swap(str, left, i);
                }
//                System.out.println(" *** Str : "+ str +" ***");
                permute(str, left+1 , right);
//                System.out.println(" *** Str : "+ str +" ***");
//                System.out.println(" *** Re Swapping from " + left +" to  " + i + " ***");
                str = swap(str, left, i);
            }
        }
    }

    private String swap(String str, int i, int right) {

        char[] tempArray = str.toCharArray();
        char temp = tempArray[i];
        tempArray[i] = tempArray[right];
        tempArray[right] = temp;
        return  String.valueOf(tempArray);
    }

    public void allSubsetAddOneByOne(String st, String current, int index) {

        if (index >= st.length()) {
            return;
        }

        String curr = current + st.charAt(index);
        System.out.println(curr);
        allSubsetAddOneByOne(st, curr, index + 1);
        allSubsetAddOneByOne(st, current, index + 1);
    }

    public String[] phoneDigits(String[] arr, int n){

        String[] strList = {"1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "*", "0"};

        int[] numbers = {2, 3, 4};

        int index = 0;

        int len = 0;

        String[] keys = new String[numbers.length];

        for(int l : numbers){
            String s = strList[l-1];
            keys[index] = s;
            index++;
            len += s.length();
        }

        int size = (int) Math.pow(2,len);

        String[] res = new String[size];

        getAllCombination(keys, res);

        return null;

    }

    private String[] getAllCombination(String[] keys, String[] res) {

        for(int i = 0; i< keys.length; i++){
            String s1 = keys[i];


        }


        return null;
    }

    public List<String> letterCombinations(String digits) {

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> l = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return l;
        }

        l.add("");

        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            String option = map.get(digits.charAt(i));

            for (int j = 0; j < l.size(); j++) {
                for (int p = 0; p < option.length(); p++) {
                    String s = new StringBuilder(l.get(j)).append(option.charAt(p)).toString();
                    System.out.println("Adding "+ s);
                    temp.add(s);
                }
            }
            l.clear();
            l.addAll(temp);
            System.out.println(l);
        }

        return l;
    }

    public void checkCount(int[] arr){


//        HashMap<Integer, Integer> countMap = new HashMap<>();
//
//        for(int i = 0; i < arr.length; i++){
//
//            if(countMap.containsKey(arr[i])){
//                countMap.put(arr[i], countMap.get(arr[i]) + 1);
//            }else{
//                countMap.put(arr[i], 1);
//            }
//        }
//        for (Map.Entry<Integer,Integer> entry : countMap.entrySet())
//            System.out.println(entry.getKey() +
//                    ", count = " + entry.getValue());

//        Arrays.sort(arr);

        for( int i = 0; i < arr.length; i++){

            int a = arr[i];

            int count = 1;
            if(a != -1) {
                for (int j = i + 1; j < arr.length; j++) {

                    if (a == arr[j]) {
                        count++;
                        arr[j] = -1;
                    }
                }
                System.out.println(a + " count = " + count);
            }
        }


    }
}
