package com.example.demo.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Java8Problems {

  public static void main(String[] args) {
    List<Employee> list = new ArrayList<>();
    Employee e1 = new Employee(23, "e1", "d1");
    Employee e2 = new Employee(32, "e4", "d1");
    Employee e3 = new Employee(33, "e5", "d2");
    Employee e4 = new Employee(34, "e2", "d2");
    Employee e5 = new Employee(27, "e3", "d3");
    Employee e6 = new Employee(23, "e6", "d3");

    list.add(e1);
    list.add(e2);
    list.add(e3);
    list.add(e4);
    list.add(e5);
    list.add(e6);

    displayMaxSalaryByDept(list);

    Map<String, Employee> map;

    map = list.stream().collect(Collectors.toMap(Employee::getName, Function.identity()));

    sortMapByAge(map);

  }

  static void sortMapByAge(Map<String, Employee> employeeMap) {

    Map<String, Employee> map = employeeMap.entrySet().stream()
        .sorted(Comparator.comparing(em -> em.getValue().getAge()))
        .collect(
            Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    System.out.println(map.toString());
  }

  public static void main2(String[] args) {
    Integer[] arr = new Integer[]{1, 2, 3, 2, 4, 1, 1, 5, 5, 5, 5};
    List<Integer> list = Stream.of(arr).collect(Collectors.toList());

    int x = 10;

    Map<Integer, Integer> map = Stream.of(arr)
        .distinct()
        .collect(
            Collectors.toMap(
                Function.identity(),
                i -> Collections.frequency(list, i),
                (a, b) -> a,
                LinkedHashMap::new)
        );

    map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));


  }


  static void displayMaxSalaryByDept(List<Employee> list) {

    Map<String, Employee> employeeMap = list.stream()
        .collect(Collectors.toMap(Employee::getDept, Function.identity(),
            BinaryOperator.maxBy(Comparator.comparing(Employee::getAge))));

    System.out.println(employeeMap.toString());

  }


  @Data
  @AllArgsConstructor
  static class Employee {

    int age;
    String name;
    String dept;

  }


}


