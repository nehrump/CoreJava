package com.example.demo.designpatterns.behavioral;

/**
 * The type State pattern allow the object for changing its behavior(based on current state) without
 * changing its class
 */
public class StatePatternDemo {


  public static void main(String[] args) {
    Employee activeEmployee = new Employee(new ActiveStatus());
    Employee inactiveEmployee = new Employee(new InactiveStatus());
    activeEmployee.checkAccess();

    inactiveEmployee.checkAccess();
  }
}

interface Status {

  void validateAccess(Employee employee);
}


class Employee {

  private final Status status;

  Employee(Status status) {
    this.status = status;
  }

  void checkAccess() {
    status.validateAccess(this);
  }
}

class ActiveStatus implements Status {

  @Override
  public void validateAccess(Employee employee) {
    System.out.println("Employee is active");
  }
}

class InactiveStatus implements Status {

  @Override
  public void validateAccess(Employee employee) {
    System.out.println("Employee is inactive");
  }
}



