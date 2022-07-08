package com.example.demo.designpatterns.behavioral;

public class StrategyPatternDemo {

  public static void main(String[] args) {
    EmployeeCollection employeeCollection = new EmployeeCollection(new BubbleSort());
    employeeCollection.sort();

    employeeCollection.setStrategy(new QuickSort());
    employeeCollection.sort();
  }

}

interface Strategy {

  void sort();
}


class EmployeeCollection {

  Strategy strategy;

  public EmployeeCollection(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public void sort() {
    this.strategy.sort();
  }


}

class QuickSort implements Strategy {

  @Override
  public void sort() {
    System.out.println("Quick sort is done");
  }
}

class BubbleSort implements Strategy {

  @Override
  public void sort() {
    System.out.println("Bubble sort is done");
  }
}
