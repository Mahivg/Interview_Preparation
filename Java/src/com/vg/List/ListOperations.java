package com.vg.List;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {

    public static void main(String[] args) {
        ListOperations listOps = new ListOperations();
        Integer[] firstArray = {1,4,5,3,9,7,2};
        Integer[] secondArray = {3,1,5,7,6,4};
        List<Integer> listOne = Arrays.asList(firstArray);
        List<Integer> listTwo = Arrays.asList(secondArray);
        List<Integer> mergedList = listOps.mergeList(listOne, listTwo);
        mergedList.stream().forEach(System.out::println);
    }

    private List<Integer> mergeList(List<Integer> listOne, List<Integer> listTwo) {
//        Removes duplicate
//        Set<Integer> set = new LinkedHashSet<>(listOne);
//        set.addAll(listTwo);
//        List<Integer> combinedList = new ArrayList<>(set);

//        < Java 1.8
//        List<Integer> combinedList = new ArrayList<>(listOne);
//        combinedList.addAll(listTwo);

//        Java 1.8
//       List<Integer> combinedList = Stream.of(listOne,listTwo).flatMap(listItem -> listItem.stream()).collect(Collectors.toList());
       List<Integer> combinedList = Stream.concat(listOne.stream(), listTwo.stream()).collect(Collectors.toList());

       Collections.sort(combinedList);
       return combinedList;
    }

}