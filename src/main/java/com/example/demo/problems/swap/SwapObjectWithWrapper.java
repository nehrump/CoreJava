package com.example.demo.problems.swap;

public class SwapObjectWithWrapper {

  public static void main(String[] args) {

    LL x = new LL(10, 1000);
    LL y = new LL(20, 2000);

    LLWrapper xWrapper = new LLWrapper(x);
    LLWrapper yWrapper = new LLWrapper(y);

    System.out.println("Before Swapping");
    System.out.println("X Value : " + xWrapper.ll.toString());
    System.out.println("Y Value : " + yWrapper.ll.toString());

    LL temp = xWrapper.ll;
    xWrapper.ll = yWrapper.ll;
    yWrapper.ll = temp;

    System.out.println("After Swapping");
    System.out.println("X Value : " + xWrapper.ll.toString());
    System.out.println("Y Value : " + yWrapper.ll.toString());


  }

}


class LLWrapper {

  LL ll;

  LLWrapper(LL ll) {
    this.ll = ll;
  }

}

class LL {

  int model;
  int price;

  public LL(int model, int price) {
    this.model = model;
    this.price = price;
  }

  @Override
  public String toString() {
    return "LL{" +
        "model=" + model +
        ", price=" + price +
        '}';
  }
}
