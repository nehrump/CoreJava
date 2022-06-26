package com.nehru.designpatterns.behavioral;

/**
 * The type Visitor pattern - defines a new operation without introducing the modifications to an
 * existing object structure.
 */
public class VisitorPatternDemo {

  public static void main(String[] args) {
    Visitor visitor = new Visitor();

    School school = new School();
    school.accept(visitor);

    PlayGround playGround = new PlayGround();
    playGround.accept(visitor);

  }
}

interface Management {

  void accept(Visitor v);
}


class Visitor {

  void visitSchool(School school) {
    System.out.println("Visiting school name : " + school.name);
  }

  void visitPlayGround(PlayGround playGround) {
    System.out.println("Visiting playground name : " + playGround.name);
  }

}

class School implements Management {

  String name = "GV School";

  @Override
  public void accept(Visitor v) {
    v.visitSchool(this);
  }
}

class PlayGround implements Management {

  String name = "FootBall";

  @Override
  public void accept(Visitor v) {
    v.visitPlayGround(this);
  }
}

