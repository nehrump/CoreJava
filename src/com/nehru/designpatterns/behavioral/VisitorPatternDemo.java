package com.nehru.designpatterns.behavioral;

interface Management {

  void accept(Visitor v);
}

public class VisitorPatternDemo {

  public static void main(String[] args) {
    Visitor visitor = new Visitor();

    School school = new School();
    school.accept(visitor);

    PlayGround playGround = new PlayGround();
    playGround.accept(visitor);

  }
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

