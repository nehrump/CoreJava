package com.example.demo.problems.swap;

public class SwapWithMemberSwap {

  public static void main(String[] args) {

    Car a = new Car(1);
    Car b = new Car(2);

    System.out.println("Swap before Swap");
    System.out.println("A No : " + a.getNo());
    System.out.println("B No : " + b.getNo());

    int temp = a.getNo();
    a.setNo(b.getNo());
    b.setNo(temp);

    System.out.println("Swap after Swap");
    System.out.println("A No : " + a.getNo());
    System.out.println("B No : " + b.getNo());
  }
}

class Car {

  private int no;

  Car(int no) {
    this.no = no;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }
}



