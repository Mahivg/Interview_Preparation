package com.vg.List;

import com.vg.model.Employee;

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
        mergedList.stream().forEach(System.out::print);

        System.out.println("** Java 8 stream operations **");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Magesh", 25000.00, "SSE", "Chennai"));
        employeeList.add(new Employee(2,"Sethuraman", 35000.00, "Devops", "Chennai"));
        employeeList.add(new Employee(3,"Prakash", 45000.00, "SSE", "Hyderabad"));
        employeeList.add(new Employee(4,"Mrudula", 55000.00, "SSE", "Hyderabad"));
        employeeList.add(new Employee(5,"Manikanta", 15000.00, "SSE", "Vizag"));

        listOps.performLambdaOperations(employeeList);
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

    private void performLambdaOperations(List<Employee> employeeList) {
//        Sorting using ID
        Collections.sort(employeeList, (e1, e2) -> e1.getEmpId().compareTo(e1.getEmpId()));

//        Find employee salary greaterthan 25000

        employeeList.stream().filter(emp -> emp.getSalary() > 25000.00).map(Employee::getName).forEach(System.out::println);

//        Group employee whose name starts with M
        Map<String, List<Employee>> nameStartWithM = employeeList.stream().filter(emp -> emp.getName().startsWith("M"))
                                                            .collect(Collectors.groupingBy(emp -> emp.getName()));
        for(Map.Entry<String, List<Employee>> entry: nameStartWithM.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().stream().forEach(System.out::print);
        }


    }

}