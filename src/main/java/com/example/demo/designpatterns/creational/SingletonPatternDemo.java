package com.example.demo.designpatterns.creational;

import java.io.Serializable;

public class SingletonPatternDemo {

  public static void main(String[] args) {
    SingletonLazyFactory.getEmployee();
    SingletonLazyFactory.getEmployee();
    SingletonLazyFactory.getEmployee();
    SingletonLazyFactory.getEmployee();
    SingletonLazyFactory.getEmployee();
  }

}

class Employee {

  public Employee() {
    System.out.println("Employee created");
  }
}

class SingletonEagerFactory {

  private static final Employee employee = new Employee();

  public static Employee getEmployee() {
    return employee;
  }
}

class SingletonLazyFactory implements Serializable, Cloneable {

  private static Employee employee;


  public static Employee getEmployee() {
    synchronized (Employee.class) {
      if (employee == null) {
        employee = new Employee();
      }
      return employee;
    }
  }

  public Object readResolve() {
    return getEmployee();
  }


}
