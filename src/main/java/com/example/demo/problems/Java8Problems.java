package com.example.demo.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

public class Java8Problems {

  public static void main(String[] args) {

    displayMaxSalaryByDept();

  }


  static void displayMaxSalaryByDept() {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee(23, "e1", "d1"));
    list.add(new Employee(32, "e4", "d1"));
    list.add(new Employee(33, "e5", "d2"));
    list.add(new Employee(34, "e2", "d2"));

    list.add(new Employee(27, "e3", "d3"));
    list.add(new Employee(23, "e6", "d3"));

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


