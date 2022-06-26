package com.nehru.designpatterns.structural;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Fly weight design pattern - says reuse already existing similar kind of objects by
 * storing them and create new object when no matching object is found
 */
public class FlyWeightDesignPatternDemo {

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      Employee employee = EmployeeFactory.getEmployee(i);
      employee.performTask();
      employee.fillTimesheet();
    }
  }

}

interface Employee {

  void performTask();

  void fillTimesheet();
}


class EmployeeFactory {

  static Map<String, Employee> employeeMap = new HashMap<>();

  public static Employee getEmployee(int employeeId) {

    String empType = employeeId % 2 == 0 ? "Developer" : "Tester";
    Employee employee = null;
    if (employeeMap.get(empType) != null) {
      employee = employeeMap.get(empType);
    } else {
      switch (empType) {
        case "Developer":
          employee = new Developer(employeeId);
          employeeMap.put("Developer", employee);
          break;
        case "Tester":
          employee = new Tester(employeeId);
          employeeMap.put("Tester", employee);
          break;
      }
    }
    return employee;
  }

}

class Developer implements Employee {

  int employeeId;

  public Developer(int employeeId) {
    this.employeeId = employeeId;
    System.out.println("*********** Developer created **********");
  }

  @Override
  public void performTask() {
    System.out.println(employeeId + ": Developer developed code");
  }

  @Override
  public void fillTimesheet() {
    System.out.println(employeeId + ": Developer filled timesheet");
  }
}

class Tester implements Employee {

  int employeeId;

  public Tester(int employeeId) {
    this.employeeId = employeeId;
    System.out.println("*********** Tester created **********");
  }

  @Override
  public void performTask() {
    System.out.println(employeeId + ": Tester developed code");
  }

  @Override
  public void fillTimesheet() {
    System.out.println(employeeId + ": Tester filled timesheet");
  }
}

