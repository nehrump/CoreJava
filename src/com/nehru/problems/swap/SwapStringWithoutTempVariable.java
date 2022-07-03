package com.nehru.problems.swap;

public class SwapStringWithoutTempVariable {

  public static void main(String[] args) {
    String x = "Hi";
    String y = "World";

    x = x + y; //HiWorld
    y = x.substring(0, x.length() - y.length()); //Hi
    x = x.substring(y.length()); //World

    System.out.println("X : " + x);
    System.out.println("Y : " + y);

  }

}
