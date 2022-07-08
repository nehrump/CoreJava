package com.example.demo.designpatterns.behavioral;

/**
 * The type Template pattern - defines template of algorithm and allows subclass to redefine the
 * steps of algorithm without changing the structure
 */
public class TemplatePatternDemo {

  public static void main(String[] args) {

    Game coc = new ClashOfClans();
    coc.play();

    Game freeFire = new FreeFire();
    freeFire.play();

  }

}

abstract class Game {

  abstract void initialise();

  abstract void start();

  abstract void end();

  void play() {
    initialise();
    start();
    end();
  }

}

class ClashOfClans extends Game {

  @Override
  void initialise() {
    System.out.println("Clash of clans is loading");
  }

  @Override
  void start() {
    System.out.println("Clash of clans started");
  }

  @Override
  void end() {
    System.out.println("Clash of clans ended");
  }
}

class FreeFire extends Game {

  @Override
  void initialise() {
    System.out.println("FreeFire is loading");
  }

  @Override
  void start() {
    System.out.println("FreeFire started");
  }

  @Override
  void end() {
    System.out.println("FreeFire ended");
  }
}

