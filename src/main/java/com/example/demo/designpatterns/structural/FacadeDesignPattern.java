package com.example.demo.designpatterns.structural;

/**
 * The type Facade design pattern - provides simplified interface to a set of complicated
 * interfaces
 */
public class FacadeDesignPattern {

  public static void main(String[] args) {
    MobileHandler.display("model", "Iphone");
    MobileHandler.display("price", "Samsung");
  }

}

interface Mobile {

  void displayPrice();

  void displayModel();
}


class Iphone implements Mobile {

  @Override
  public void displayModel() {
    System.out.println("Iphone 14");
  }

  @Override
  public void displayPrice() {
    System.out.println("Rs.100000");
  }
}

class Samsung implements Mobile {

  @Override
  public void displayModel() {
    System.out.println("Galaxy S22");
  }

  @Override
  public void displayPrice() {
    System.out.println("Rs.900000");
  }
}

class MobileHandler {

  static void display(String info, String phone) {
    Mobile mobile;
    switch (phone) {
      case "Iphone":
        mobile = new Iphone();
        if ("model".equals(info)) {
          mobile.displayModel();
        } else {
          mobile.displayPrice();
        }
        break;
      case "Samsung":
        mobile = new Samsung();
        if ("model".equals(info)) {
          mobile.displayModel();
        } else {
          mobile.displayPrice();
        }
        break;
    }
  }

}


