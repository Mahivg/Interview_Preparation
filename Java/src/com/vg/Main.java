package com.vg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Integer> myIntegerList = Arrays.asList(1,2,3,4,5,6);
        myIntegerList.stream().forEach(System.out::println);

    }
}
