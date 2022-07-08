package com.example.demo.designpatterns.behavioral;

/**
 * The type Mediator pattern - defines an object that encapsulates how a set of objects interact
 */
public class MediatorPatternDemo {

  public static void main(String[] args) {

    WhatsappMediator whatsappMediator = new WhatsappMediator();

    WhatsappUser user1 = new User1(whatsappMediator, "Siva");
    WhatsappUser user2 = new User2(whatsappMediator, "Sakthi");

    user1.sendMessage("Hello Sakthi,How are you ?");
    user2.sendMessage("Hello Siva. I am good");

  }
}


class WhatsappMediator {

  void showMessage(String message, WhatsappUser user) {
    System.out.println(user.getUserName() + " has sent message " + message);
  }
}


abstract class WhatsappUser {

  abstract void sendMessage(String message);

  abstract String getUserName();
}

class User1 extends WhatsappUser {

  WhatsappMediator mediator;
  String userName;


  User1(WhatsappMediator mediator, String userName) {
    this.mediator = mediator;
    this.userName = userName;
  }

  @Override
  void sendMessage(String message) {
    mediator.showMessage(message, this);
  }

  public String getUserName() {
    return userName;
  }
}

class User2 extends WhatsappUser {

  WhatsappMediator mediator;
  String userName;


  User2(WhatsappMediator mediator, String userName) {
    this.mediator = mediator;
    this.userName = userName;
  }

  @Override
  public String getUserName() {
    return userName;
  }

  @Override
  void sendMessage(String message) {
    mediator.showMessage(message, this);
  }
}

