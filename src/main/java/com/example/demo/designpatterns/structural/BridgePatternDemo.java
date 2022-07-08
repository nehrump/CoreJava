package com.example.demo.designpatterns.structural;

/**
 * The type Bridge pattern - decouples abstraction from its implementation so that both changed
 * independently
 */
public class BridgePatternDemo {

  public static void main(String[] args) {

    ToyMaker rectangleGreenToy = new ToyMaker(new Rectangle(), new GreenColor());
    ToyMaker squareGreenToy = new ToyMaker(new Square(), new RedColor());

    rectangleGreenToy.makeToy();
    squareGreenToy.makeToy();

  }

}


class ToyMaker {

  private final Shape shape;
  private final Color color;

  public ToyMaker(Shape shape, Color color) {
    this.shape = shape;
    this.color = color;
  }

  void makeToy() {
    shape.draw();
    color.fillColor();
  }
}


interface Shape {

  void draw();
}

class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Drawing Rectangle");
  }
}

class Square implements Shape {

  @Override
  public void draw() {
    System.out.println("Drawing Rectangle");
  }
}

interface Color {

  void fillColor();
}

class RedColor implements Color {

  @Override
  public void fillColor() {
    System.out.println(" with Red color");
  }
}

class GreenColor implements Color {

  @Override
  public void fillColor() {
    System.out.println(" with Green color");
  }
}
